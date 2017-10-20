package com.nanosl.n.module.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nanosl.n.dao.Combo;
import com.nanosl.n.utility.Page;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Iterable<Item> findAll() {
        return repository.findAll();
    }

    public Page<Item> findAll(Pageable pageable) {
        return new Page<Item>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Item save(Item item) {
        return repository.save(item);
    }

    public void save(List<Item> items) {
        repository.save(items);
    }

    public Item findOne(int id) {
        return repository.findOne(id);
    }

    public Item findByCode(String code) {
        return repository.findByCode(code);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
