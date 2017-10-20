package com.nanosl.n.module.salesinvoiceitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosl.n.module.appsession.AppSessionService;
import com.nanosl.n.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/salesInvoiceItems")
public class SalesInvoiceItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SalesInvoiceItemService service;

    @JsonView(SalesInvoiceItemView.All.class)
    @GetMapping
    public Iterable<SalesInvoiceItem> findAll() {
        return service.findAll();
    }

    @JsonView(SalesInvoiceItemView.All.class)
    @GetMapping("/page")
    Page<SalesInvoiceItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SalesInvoiceItemView.All.class)
    @PostMapping
    public SalesInvoiceItem save(@RequestBody SalesInvoiceItem salesInvoiceItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);

        try {

            salesInvoiceItem = service.save(salesInvoiceItem);
            return salesInvoiceItem;

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SalesInvoiceItemView.All.class)
    @GetMapping("/{id}")
    public SalesInvoiceItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(SalesInvoiceItemView.All.class)
    @PutMapping("/{id}")
    public SalesInvoiceItem updateCustomer(@PathVariable int id, @RequestBody SalesInvoiceItem salesInvoiceItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesInvoiceItem.setId(id);
        salesInvoiceItem = service.save(salesInvoiceItem);
        return salesInvoiceItem;
    }
}
