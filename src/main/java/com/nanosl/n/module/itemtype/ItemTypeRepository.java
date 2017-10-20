package com.nanosl.n.module.itemtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanosl.n.dao.Combo;

public interface ItemTypeRepository extends PagingAndSortingRepository<ItemType, Integer> {

    public ItemType findByName(String name);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.name)"
            + " FROM ItemType o")
    public List<Combo> getCombo();
}
