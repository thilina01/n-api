package com.nanosl.n.module.purchaseinvoice;

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
import com.nanosl.n.module.purchaseinvoiceitem.PurchaseInvoiceItem;
import com.nanosl.n.utility.Format;
import com.nanosl.n.utility.Page;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/purchaseInvoices")
public class PurchaseInvoiceController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PurchaseInvoiceService service;

    @JsonView(PurchaseInvoiceView.AllAndPurchaseInvoiceItemAllAndAllItemAll.class)
    @GetMapping
    public Iterable<PurchaseInvoice> findAll() {
        return service.findAll();
    }

    @JsonView(PurchaseInvoiceView.AllAndPurchaseInvoiceItemAllAndAllItemAll.class)
    @GetMapping("/page")
    Page<PurchaseInvoice> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PurchaseInvoiceView.AllAndPurchaseInvoiceItemAllAndAllItemAll.class)
    @GetMapping(value = "/invoiceDatePage", params = {"startDate", "endDate"})
    public Page<PurchaseInvoice> invoiceDatePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByInvoiceDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(PurchaseInvoiceView.AllAndPurchaseInvoiceItemAllAndAllItemAll.class)
    @PostMapping
    public PurchaseInvoice save(@RequestBody PurchaseInvoice purchaseInvoice,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            List<PurchaseInvoiceItem> purchaseInvoiceItemes = purchaseInvoice.getPurchaseInvoiceItemList();
            if (purchaseInvoiceItemes != null) {
                for (PurchaseInvoiceItem purchaseInvoiceItem : purchaseInvoiceItemes) {
                    purchaseInvoiceItem.setPurchaseInvoice(purchaseInvoice);
                }
            }

            purchaseInvoice = service.save(purchaseInvoice);
            return purchaseInvoice;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<PurchaseInvoice> purchaseInvoices,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(purchaseInvoices);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PurchaseInvoiceView.AllAndPurchaseInvoiceItemAllAndAllItemAll.class)
    @GetMapping("/{id}")
    public PurchaseInvoice findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(PurchaseInvoiceView.AllAndPurchaseInvoiceItemAllAndAllItemAll.class)
    @PutMapping("/{id}")
    public PurchaseInvoice updateCustomer(@PathVariable int id, @RequestBody PurchaseInvoice purchaseInvoice,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        purchaseInvoice.setId(id);
        purchaseInvoice = service.save(purchaseInvoice);
        return purchaseInvoice;
    }
}
