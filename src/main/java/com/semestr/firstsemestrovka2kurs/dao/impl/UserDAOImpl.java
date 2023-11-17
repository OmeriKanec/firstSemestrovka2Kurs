package com.semestr.firstsemestrovka2kurs.dao.impl;

import com.semestr.firstsemestrovka2kurs.JDBCConnection;
import com.semestr.firstsemestrovka2kurs.dao.DAO;
import com.semestr.firstsemestrovka2kurs.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                        rs.getString("bio"),
                        rs.getLong("id"));
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
                        rs.getString("bio"),
                        rs.getLong("id"));
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public User getByUserName(String username) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from users where username = ?"
            );
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("profilepicture"),
                        rs.getString("bio"),
                        rs.getLong("id"));
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
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement("update users set email = ?, username = ?, password = ?, profilepicture = ?, bio = ? where id = ?");
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getUserName());
            statement.setString(3, u.getPassword());
            statement.setString(4, u.getProfilePicture());
            statement.setString(5, u.getBio());
            statement.setLong(6, u.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from users"
            );
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("profilepicture"),
                        rs.getString("bio"),
                        rs.getLong("id"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }
}
