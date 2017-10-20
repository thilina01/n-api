package com.nanosl.n.module.item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanosl.n.dao.Combo;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {

    public Item findByCode(String code);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.name)"
            + " FROM Item o")
    public List<Combo> getCombo();
}
