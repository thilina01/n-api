package com.nanosl.n.module.purchaseinvoice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanosl.n.dao.Combo;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseInvoiceRepository extends PagingAndSortingRepository<PurchaseInvoice, Integer> {

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, '', '')"
            + " FROM PurchaseInvoice  o")
    public List<Combo> getCombo();

    public Page<PurchaseInvoice> findByInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable);

}
