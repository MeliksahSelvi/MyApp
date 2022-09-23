package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Comment;
import dto.CommentDto;
import service.CommentService;
import webservice.CommentWebService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CommentServlet extends HttpServlet {

    private CommentWebService commentWebService;
    private List<CommentDto> commentList;

    @Override
    public void init() throws ServletException {
        this.commentWebService = new CommentWebService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        commentList = commentWebService.findAllComment();
        String json = new Gson().toJson(this.commentList);
        response.getWriter().write(json);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        int bufferSize = 1024;
        char[] buffer = new char[bufferSize];
        StringBuilder out = new StringBuilder();
        Reader in = null;
        try {
            in = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);

            for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0; ) {
                out.append(buffer, 0, numRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String contentDtoAsJson = out.toString();
        contentDtoAsJson = contentDtoAsJson.replace("contentDtoAsJson=", "");
        Gson gson = new GsonBuilder().create();
        CommentDto commentDto = gson.fromJson(contentDtoAsJson, CommentDto.class);
        if (commentDto == null) {
            String name = request.getParameter("name");
            String content = request.getParameter("content");

            commentDto = new CommentDto();
            commentDto.setName(name);
            commentDto.setContent(content);
        }
        commentWebService.addComment(commentDto);
    }
}
