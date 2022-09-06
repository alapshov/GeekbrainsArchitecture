package ru.geekbrains.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection conn;

    private final PreparedStatement selectUser;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection conn) {
        this.conn = conn;
        try {
            this.selectUser = conn.prepareStatement("select id, username, password from users where id = ?");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
                user = new User(rs.getLong(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public void update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("No id in entity to update");
        }
        User oldUser = findById(user.getId()).orElseThrow(() -> new IllegalStateException("No entity with id"));
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        identityMap.put(oldUser.getId(), oldUser);
        // TODO
    }

    public User insert(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("New entity should not have id");
        }
        // TODO
        //user.setId(...);
        return null;
    }

    public void delete(User user) {

    }
}
