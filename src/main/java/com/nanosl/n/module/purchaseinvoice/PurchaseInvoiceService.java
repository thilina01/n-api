package com.nanosl.n.module.purchaseinvoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nanosl.n.dao.Combo;
import java.util.Date;
import org.springframework.data.domain.Page;

@Service
public class PurchaseInvoiceService {

    @Autowired
    private PurchaseInvoiceRepository repository;

    public Iterable<PurchaseInvoice> findAll() {
        return repository.findAll();
    }

    public Page<PurchaseInvoice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public PurchaseInvoice save(PurchaseInvoice salesInvoice) {
        return repository.save(salesInvoice);
    }

    public void save(List<PurchaseInvoice> items) {
        repository.save(items);
    }

    public PurchaseInvoice findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
     public Page<PurchaseInvoice> findByInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInvoiceDateBetween(startDate, endDate, pageable);

    }

}
