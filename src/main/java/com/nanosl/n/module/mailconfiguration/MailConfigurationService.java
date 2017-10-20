package com.nanosl.n.module.mailconfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nanosl.n.dao.Combo;
import org.springframework.data.domain.Page;

@Service
public class MailConfigurationService {

    @Autowired
    private MailConfigurationRepository repository;

    public Iterable<MailConfiguration> findAll() {
        return repository.findAll();
    }

    public Page<MailConfiguration> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public MailConfiguration save(MailConfiguration mailConfiguration) {
        return repository.save(mailConfiguration);
    }

    public void save(List<MailConfiguration> items) {
        repository.save(items);
    }

    public MailConfiguration findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

   
}
