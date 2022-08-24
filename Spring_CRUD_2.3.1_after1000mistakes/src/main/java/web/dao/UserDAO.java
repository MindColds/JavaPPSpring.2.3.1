package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUser(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
