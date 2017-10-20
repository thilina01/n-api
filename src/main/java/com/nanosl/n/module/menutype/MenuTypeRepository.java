package com.nanosl.n.module.menutype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanosl.n.dao.Combo;

public interface MenuTypeRepository extends PagingAndSortingRepository<MenuType, Integer> {

    public MenuType findByName(String name);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.name)"
            + " FROM MenuType o")
    public List<Combo> getCombo();
}
