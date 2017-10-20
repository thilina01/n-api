package com.nanosl.n.module.purchaseinvoiceitem;

import com.nanosl.n.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PurchaseInvoiceItemService {

    @Autowired
    private PurchaseInvoiceItemRepository repository;

    public Iterable<PurchaseInvoiceItem> findAll() {
        return repository.findAll();
    }

    public Page<PurchaseInvoiceItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public PurchaseInvoiceItem save(PurchaseInvoiceItem PurchaseInvoiceItem) {
        return repository.save(PurchaseInvoiceItem);
    }

    public void save(List<PurchaseInvoiceItem> PurchaseInvoiceItem) {
       repository.save(PurchaseInvoiceItem);
    }

    public PurchaseInvoiceItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public PurchaseInvoiceItem findByid(Integer id) {
        return repository.findByid(id);
    }

}
