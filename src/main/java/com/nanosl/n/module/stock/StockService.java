package com.nanosl.n.module.stock;

import com.nanosl.n.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public Iterable<Stock> findAll() {
        return repository.findAll();
    }

    public Page<Stock> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Stock save(Stock stock) {
        return repository.save(stock);
    }

    public Stock findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Stock findByCode(String code) {
        return repository.findByCode(code);
    }
}
