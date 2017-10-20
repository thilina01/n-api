package com.nanosl.n.module.employee;

import com.nanosl.n.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    public Employee findByCode(String code);

    @Query(value = "SELECT"
            + " new com.nanosl.n.dao.Combo(o.id, o.code, o.firstName + ' ' + o.lastName)"
            + " FROM Employee o")
    public List<Combo> getCombo();
}
