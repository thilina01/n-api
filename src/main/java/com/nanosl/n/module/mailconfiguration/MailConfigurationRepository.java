package com.nanosl.n.module.mailconfiguration;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanosl.n.dao.Combo;

public interface MailConfigurationRepository extends PagingAndSortingRepository<MailConfiguration, Integer> {


    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.port,o.user )"
            + " FROM MailConfiguration o")
    public List<Combo> getCombo();
}
