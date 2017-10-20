package com.nanosl.n.module.purchaseinvoiceitem;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseInvoiceItemRepository extends PagingAndSortingRepository<PurchaseInvoiceItem, Integer> {
     public PurchaseInvoiceItem findByid(Integer id);
 
    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, '','')"
            + " FROM PurchaseInvoiceItem o")
    public List<Combo> getCombo();
}
