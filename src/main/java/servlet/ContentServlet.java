package servlet;

import com.google.gson.Gson;
import dto.ContentDto;
import service.ContentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ContentServlet extends HttpServlet{

    private ContentService contentService;
    private List<ContentDto> contentDtoList;

    @Override
    public void init() throws ServletException {
        this.contentService=new ContentService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.contentDtoList=this.contentService.findAllContent();
        String json=new Gson().toJson(this.contentDtoList);
        response.getWriter().write(json);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String name=request.getParameter("name");
        String comment=request.getParameter("comment");
        this.contentService.addContent(name,comment);
    }

}
