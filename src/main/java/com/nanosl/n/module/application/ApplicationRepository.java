package com.nanosl.n.module.application;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Integer> {

    public Application findByCode(String code);

    public Application findByName(String name);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.name)"
            + " FROM Application o")
    public List<Combo> getCombo();
}
