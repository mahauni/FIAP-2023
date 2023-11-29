package org.mahauni.dao;

import org.mahauni.model.HealthTech;
import org.mahauni.model.User;

public interface UserDAO {
    void createUser(User user);

    boolean validateUser(User user);

    User getUserByEmail(String email);

    User getUserById(int id);
}
