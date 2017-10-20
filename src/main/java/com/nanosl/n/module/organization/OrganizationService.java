package com.nanosl.n.module.organization;

import com.nanosl.n.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    public Iterable<Organization> findAll() {
        return repository.findAll();
    }

    public Page<Organization> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Organization save(Organization organization) {
        return repository.save(organization);
    }

    public Organization findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Organization findByCode(String code) {
        return repository.findByCode(code);
    }
}
