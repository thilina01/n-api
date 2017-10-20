package com.nanosl.n.module.user;

import com.nanosl.n.dao.Combo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    List<User> findByTeamName(String name);

    User findByEmailAndPasswordAndStatus(String email, String password, String status);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.email, o.email)"
            + " FROM User o")
    public List<Combo> getCombo();
}
