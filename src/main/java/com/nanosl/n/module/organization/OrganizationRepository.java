package com.nanosl.n.module.organization;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Integer> {

    public Organization findByCode(String code);

    public Organization findByName(String name);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.name)"
            + " FROM Organization o")
    public List<Combo> getCombo();
}
