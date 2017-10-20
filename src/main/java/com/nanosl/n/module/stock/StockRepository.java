package com.nanosl.n.module.stock;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StockRepository extends PagingAndSortingRepository<Stock, Integer> {

    public Stock findByCode(String code);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, '', '')"
            + " FROM Stock o")
    public List<Combo> getCombo();
}
