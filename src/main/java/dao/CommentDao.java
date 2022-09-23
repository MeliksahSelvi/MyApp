package dao;

import domain.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public List<Comment> findAllComment(){
        List<Comment> list=new ArrayList<>();

        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Comment.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();

        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> criteria = builder.createQuery(Comment.class);
        criteria.from(Comment.class);
        list=session.createQuery(criteria).getResultList();

        return list;
    }

    public void addComment(Comment comment){

        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Comment.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();

        factory.close();
    }
}
