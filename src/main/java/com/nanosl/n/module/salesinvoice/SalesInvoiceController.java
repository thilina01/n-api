package com.nanosl.n.module.salesinvoice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.dao.Combo;
import com.nanosl.n.module.appsession.AppSessionService;
import com.nanosl.n.module.salesinvoiceitem.SalesInvoiceItem;
import com.nanosl.n.utility.Format;
import com.nanosl.n.utility.Page;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/salesInvoices")
public class SalesInvoiceController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SalesInvoiceService service;

    @JsonView(SalesInvoiceView.AllAndSalesInvoiceItemAllAndAllItemAll.class)
    @GetMapping
    public Iterable<SalesInvoice> findAll() {
        return service.findAll();
    }

    @JsonView(SalesInvoiceView.AllAndSalesInvoiceItemAllAndAllItemAll.class)
    @GetMapping("/page")
    Page<SalesInvoice> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SalesInvoiceView.AllAndSalesInvoiceItemAllAndAllItemAll.class)
    @GetMapping(value = "/invoiceDatePage", params = {"startDate", "endDate"})
    public Page<SalesInvoice> invoiceDatePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByInvoiceDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(SalesInvoiceView.AllAndSalesInvoiceItemAllAndAllItemAll.class)
    @PostMapping
    public SalesInvoice save(@RequestBody SalesInvoice salesInvoice,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<SalesInvoiceItem> salesInvoiceItemes = salesInvoice.getSalesInvoiceItemList();
            if (salesInvoiceItemes != null) {
                for (SalesInvoiceItem salesInvoiceItem : salesInvoiceItemes) {
                    salesInvoiceItem.setSalesInvoice(salesInvoice);
                }
            }
            salesInvoice = service.save(salesInvoice);
            return salesInvoice;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SalesInvoice> salesInvoices,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(salesInvoices);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SalesInvoiceView.AllAndSalesInvoiceItemAllAndAllItemAll.class)
    @GetMapping("/{id}")
    public SalesInvoice findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(SalesInvoiceView.AllAndSalesInvoiceItemAllAndAllItemAll.class)
    @PutMapping("/{id}")
    public SalesInvoice updateCustomer(@PathVariable int id, @RequestBody SalesInvoice salesInvoice,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesInvoice.setId(id);
        salesInvoice = service.save(salesInvoice);
        return salesInvoice;
    }
}
