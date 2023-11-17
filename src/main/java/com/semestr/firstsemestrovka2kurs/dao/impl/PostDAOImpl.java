package com.semestr.firstsemestrovka2kurs.dao.impl;

import com.semestr.firstsemestrovka2kurs.JDBCConnection;
import com.semestr.firstsemestrovka2kurs.dao.DAO;
import com.semestr.firstsemestrovka2kurs.models.Game;
import com.semestr.firstsemestrovka2kurs.models.Post;
import com.semestr.firstsemestrovka2kurs.models.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements DAO<Post> {
    @Override
    public void create(Post p) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement("insert into posts(name, content, posterid, allowcomments, postername) values (?, ?, ?, ?, ?)");
            statement.setString(1, p.getName());
            statement.setString(2, p.getContent());
            statement.setLong(3, p.getPosterId());
            statement.setBoolean(4, p.isAllowComments());
            statement.setString(5, p.getPosterName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post get(long id) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from posts where id = ?"
            );
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Post p = new Post(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getLong("posterid"),
                        rs.getDate("dateofpost").toLocalDate(),
                        rs.getBoolean("allowcomments"),
                        rs.getString("postername"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }


    @Override
    public void update(Post u) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from posts"
            );
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Post p = new Post(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getLong("posterid"),
                        rs.getDate("dateofpost").toLocalDate(),
                        rs.getBoolean("allowcomments"),
                        rs.getString("postername"));
                posts.add(p);
            }
            return posts;
        } catch (SQLException e) {
            return null;
        }
    }

}
