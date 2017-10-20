package com.nanosl.n.module.team;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamRepository extends PagingAndSortingRepository<Team, Integer> {

    Team findByCode(String code);

    Team findByName(String name);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.name)"
            + " FROM Team o")
    public List<Combo> getCombo();
}
