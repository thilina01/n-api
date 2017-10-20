package com.nanosl.n.module.salesinvoice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanosl.n.dao.Combo;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalesInvoiceRepository extends PagingAndSortingRepository<SalesInvoice, Integer> {

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, '', '')"
            + " FROM SalesInvoice  o")
    public List<Combo> getCombo();

    public Page<SalesInvoice> findByInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable);

}
