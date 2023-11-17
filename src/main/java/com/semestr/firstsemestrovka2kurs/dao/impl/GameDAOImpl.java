package com.semestr.firstsemestrovka2kurs.dao.impl;

import com.semestr.firstsemestrovka2kurs.JDBCConnection;
import com.semestr.firstsemestrovka2kurs.dao.DAO;
import com.semestr.firstsemestrovka2kurs.models.Game;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImpl implements DAO<Game> {
    @Override
    public void create(Game g) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement("insert into games(name, genre, dateofrelise, developer, publisher, creatorid) values (?, ?, ?, ?, ?, ?)");
            statement.setString(1, g.getName());
            statement.setString(2, g.getGenre());
            statement.setDate(3, Date.valueOf(g.getDateOfRelise()));
            statement.setString(4, g.getDeveloper());
            statement.setString(5, g.getPublisher());
            statement.setLong(6, g.getCreatorid());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Game get(long id) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from games where id = ?"
            );
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Game g = new Game(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getDate("dateofrelise").toLocalDate(),
                        rs.getString("developer"),
                        rs.getString("publisher"),
                        rs.getLong("creatorid"));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public void update(Game g) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement("update games set name = ?, genre = ?, dateofrelise = ?, developer = ?, publisher = ?, creatorid = ? where id = ?");
            statement.setString(1, g.getName());
            statement.setString(2, g.getGenre());
            statement.setDate(3, Date.valueOf(g.getDateOfRelise()));
            statement.setString(4, g.getDeveloper());
            statement.setString(5, g.getPublisher());
            statement.setLong(6, g.getCreatorid());
            statement.setLong(7, g.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Game> getAll() {
        List<Game> games = new ArrayList<>();
        try {
        PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                "select * from games"
        );
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Game g = new Game(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getDate("dateofrelise").toLocalDate(),
                        rs.getString("developer"),
                        rs.getString("publisher"),
                        rs.getLong("creatorid"));
                games.add(g);
            }
            return games;
        } catch (SQLException e) {
            return null;
        }
    }
}
