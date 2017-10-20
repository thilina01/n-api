package com.nanosl.n.module.salesinvoiceitem;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalesInvoiceItemRepository extends PagingAndSortingRepository<SalesInvoiceItem, Integer> {
     public SalesInvoiceItem findByid(Integer id);
 
    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, '','')"
            + " FROM SalesInvoiceItem o")
    public List<Combo> getCombo();
}
