package com.nanosl.n.module.salesinvoiceitem;

import com.nanosl.n.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SalesInvoiceItemService {

    @Autowired
    private SalesInvoiceItemRepository repository;

    public Iterable<SalesInvoiceItem> findAll() {
        return repository.findAll();
    }

    public Page<SalesInvoiceItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SalesInvoiceItem save(SalesInvoiceItem SalesInvoiceItem) {
        return repository.save(SalesInvoiceItem);
    }

    //public void save(List<SalesInvoiceItem> SalesInvoiceItem) {
       // repository.save(SalesInvoiceItem);
    //}

    public SalesInvoiceItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public SalesInvoiceItem findByid(Integer id) {
        return repository.findByid(id);
    }

}
