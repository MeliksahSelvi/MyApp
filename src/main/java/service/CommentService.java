package service;

import dao.CommentDao;
import domain.Comment;
import dto.CommentDto;

import java.util.List;
import java.util.stream.Collectors;

public class CommentService {

    private CommentDao commentDao;

    public CommentService() {
        commentDao = new CommentDao();
    }

    public List<Comment> findAllComment(){
        List<Comment> commentList = commentDao.findAllComment();
        return commentList.stream()
                .filter(comment -> comment.getName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public void addComment(Comment comment){
        commentDao.addComment(comment);
    }
}
