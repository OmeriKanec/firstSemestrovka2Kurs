package com.semestr.firstsemestrovka2kurs.dao.impl;

import com.semestr.firstsemestrovka2kurs.JDBCConnection;
import com.semestr.firstsemestrovka2kurs.dao.DAO;
import com.semestr.firstsemestrovka2kurs.models.Comment;
import com.semestr.firstsemestrovka2kurs.models.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements DAO<Comment> {
    @Override
    public void create(Comment c) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement("insert into comment(name, content, commenterid, postid, postername) values (?, ?, ?, ?, ?)");
            statement.setString(1, c.getName());
            statement.setString(2, c.getContent());
            statement.setLong(3, c.getCommenterId());
            statement.setLong(4, c.getPostId());
            statement.setString(5, c.getPosterName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comment get(long id) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from comment where id = ?"
            );
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Comment c = new Comment(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getLong("commenterid"),
                        rs.getDate("dateofpost").toLocalDate(),
                        rs.getLong("postid"),
                        rs.getString("postername"));
                return c;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }


    @Override
    public void update(Comment c) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Comment> getAll() {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from comment"
            );
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Comment c = new Comment(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getLong("commenterid"),
                        rs.getDate("dateofpost").toLocalDate(),
                        rs.getLong("postid"),
                        rs.getString("postername"));
                comments.add(c);
            }
            return comments;
        } catch (SQLException e) {
            return null;
        }
    }
    public List<Comment> getAllWithPostId(long postId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from comment where postid = ?"
            );
            statement.setLong(1, postId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Comment c = new Comment(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getLong("commenterid"),
                        rs.getDate("dateofcomment").toLocalDate(),
                        rs.getLong("postid"),
                        rs.getString("postername"));
                comments.add(c);
            }
            return comments;
        } catch (SQLException e) {
            return null;
        }
    }
}
