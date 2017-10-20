package com.nanosl.n.module.country;

import com.nanosl.n.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Iterable<Country> findAll() {
        return repository.findAll();
    }

    public Page<Country> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Country save(Country country) {
        return repository.save(country);
    }

    public void save(List<Country> countries) {
        repository.save(countries);
    }

    public Country findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Country findByCode(String code) {
        return repository.findByCode(code);
    }

    public Country findByName(String name) {
        return repository.findByName(name);
    }
}
