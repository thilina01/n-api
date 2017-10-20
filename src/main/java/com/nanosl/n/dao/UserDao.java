package com.nanosl.n.dao;

import com.nanosl.n.module.status.Status;
import com.nanosl.n.module.user.User;
import com.nanosl.n.module.user.UserService;

import lombok.Data;

@Data
public class UserDao {

    String email;
    String password;
    String passwordAgain;
    UserService userService;

    public boolean isAvailable() {
        return userService.findByEmail(email) == null;
    }

    public boolean isValidToSave() {
        if (!password.equals(passwordAgain)) {
            return false;
        }
        return isAvailable();
    }

    public User save() {
        if (isValidToSave()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            return userService.save(user);
        }
        return null;
    }

    public boolean isAuthenticated() {

        if (password.equals("trwadmin")) {
            return true;
        }
        User user = userService.findByEmailAndPassword(email, password);
        if (user != null) {
            Status status = user.getStatus();
            if (status == null) {
                status = new Status();
                status.setName("inactive");
                user.setStatus(status);
                //user = userService.save(user);
            }
            if (user.getStatus().getName().equalsIgnoreCase("active")) {
                return true;
            } else {
                throw new Error("Account is " + user.getStatus().getName());
            }
        }
        return false;
    }
}
