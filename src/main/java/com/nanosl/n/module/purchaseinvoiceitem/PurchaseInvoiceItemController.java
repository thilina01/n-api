package com.nanosl.n.module.purchaseinvoiceitem;

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
@RequestMapping("/purchaseInvoiceItems")
public class PurchaseInvoiceItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PurchaseInvoiceItemService service;

    @JsonView(PurchaseInvoiceItemView.All.class)
    @GetMapping
    public Iterable<PurchaseInvoiceItem> findAll() {
        return service.findAll();
    }

    @JsonView(PurchaseInvoiceItemView.All.class)
    @GetMapping("/page")
    Page<PurchaseInvoiceItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PurchaseInvoiceItemView.All.class)
    @PostMapping
    public PurchaseInvoiceItem save(@RequestBody PurchaseInvoiceItem purchaseInvoiceItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);

        try {

            purchaseInvoiceItem = service.save(purchaseInvoiceItem);
            return purchaseInvoiceItem;

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PurchaseInvoiceItemView.All.class)
    @GetMapping("/{id}")
    public PurchaseInvoiceItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(PurchaseInvoiceItemView.All.class)
    @PutMapping("/{id}")
    public PurchaseInvoiceItem updateCustomer(@PathVariable int id, @RequestBody PurchaseInvoiceItem purchaseInvoiceItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        purchaseInvoiceItem.setId(id);
        purchaseInvoiceItem = service.save(purchaseInvoiceItem);
        return purchaseInvoiceItem;
    }
}
