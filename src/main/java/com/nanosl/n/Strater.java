package com.nanosl.n;

import com.nanosl.n.module.country.Country;
import com.nanosl.n.module.country.CountryService;
import com.nanosl.n.module.status.Status;
import com.nanosl.n.module.status.StatusService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Strater {

    @Autowired
    private StatusService statusService;
    @Autowired
    private CountryService countryService;

    @PostConstruct
    public void afterStarted() {
        System.out.println("Init process started");
        initStatus();
        initCountry();
        System.out.println("Init process finished");
    }

    private void initStatus() {
        List<Status> statuses = statusService.findAll();
        if (statuses.isEmpty()) {
            Status active = new Status();
            active.setName("active");
            Status inactive = new Status();
            inactive.setName("inactive");

            statuses.add(active);
            statuses.add(inactive);

            statusService.save(statuses);
        }
    }

    private void initCountry() {
        Country country = countryService.findByCode("NA");
        if (country == null) {
            country = new Country();
            country.setCode("NA");
            country.setName("NOT AVAILABLE");
            countryService.save(country);
        }
    }
}
