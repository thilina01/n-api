package com.nanosl.n.module.salesinvoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nanosl.n.dao.Combo;
import com.nanosl.n.module.item.Item;
import java.util.Date;
import org.springframework.data.domain.Page;

@Service
public class SalesInvoiceService {

    @Autowired
    private SalesInvoiceRepository repository;

    public Iterable<SalesInvoice> findAll() {
        return repository.findAll();
    }

    public Page<SalesInvoice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SalesInvoice save(SalesInvoice salesInvoice) {
        return repository.save(salesInvoice);
    }

    public void save(List<SalesInvoice> items) {
        repository.save(items);
    }

    public SalesInvoice findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<SalesInvoice> findByInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInvoiceDateBetween(startDate, endDate, pageable);

    }
}
