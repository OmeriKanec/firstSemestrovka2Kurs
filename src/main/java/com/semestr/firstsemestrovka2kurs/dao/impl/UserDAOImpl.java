package com.semestr.firstsemestrovka2kurs.dao.impl;

import com.semestr.firstsemestrovka2kurs.JDBCConnection;
import com.semestr.firstsemestrovka2kurs.dao.DAO;
import com.semestr.firstsemestrovka2kurs.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements DAO<User> {


    @Override
    public void create(User u) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement("insert into users(email, username, password) values (?, ?, ?)");
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getUserName());
            statement.setString(3, u.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User get(long id) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from users where id = ?"
            );
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("profilepicture"),
                        rs.getString("bio"));
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }

    }

    public User getByEmail(String email) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from users where email = ?"
            );
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("profilepicture"),
                        rs.getString("bio"));
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public void update(User u) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
