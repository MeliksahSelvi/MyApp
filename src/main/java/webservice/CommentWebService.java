package webservice;

import domain.Comment;
import dto.CommentDto;
import service.CommentService;

import java.util.ArrayList;
import java.util.List;

public class CommentWebService {

    private CommentService commentService;

    public CommentWebService() {
        commentService = new CommentService();
    }

    public void addComment(CommentDto commentDto){
        Comment comment = new Comment(commentDto.getName(),commentDto.getContent());
        commentService.addComment(comment);
    }

    public List<CommentDto> findAllComment() {
        List<Comment> commentList = commentService.findAllComment();

        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentDto commentDto = new CommentDto();
            commentDto.setId(comment.getId());
            commentDto.setName(comment.getName());
            commentDtoList.add(commentDto);
        }

        return commentDtoList;
    }
}