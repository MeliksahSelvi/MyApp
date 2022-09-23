package service;

import helper.DbConnect;
import dto.ContentDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContentService {

    public List<ContentDto> findAllContent(){
        ArrayList<ContentDto> list=new ArrayList<>();
        String query="SELECT * FROM aboutus";

        try {
            Statement st= DbConnect.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);

            while(rs.next()){
                int id=rs.getInt("ID");
                String head=rs.getString("Head");
                String content=rs.getString("Content");
                ContentDto contentDto =new ContentDto(id,head,content);
                list.add(contentDto);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }
    public boolean addContent(String head,String comment){

        String query="INSERT INTO aboutus(Head,Content) VALUES(?,?);";
        try {
            PreparedStatement pr=DbConnect.getInstance().prepareStatement(query);
            pr.setString(1,head);
            pr.setString(2,comment);
            return pr.executeUpdate()!=1;
        } catch (SQLException e) {
            e.getMessage();
        }
        return true;
    }
}
