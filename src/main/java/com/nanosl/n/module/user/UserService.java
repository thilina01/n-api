package com.nanosl.n.module.user;

import com.nanosl.n.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosl.n.utility.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public Page<User> findAll(Pageable pageable) {
        return new Page<User>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);

    }

    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);

    }

    public Object findByEmailAndPasswordAndStatus(String email, String password, String status) {
        return repository.findByEmailAndPasswordAndStatus(email, password, status);
    }

    List<User> findByTeamName(String name) {
        return repository.findByTeamName(name);
    }
}
