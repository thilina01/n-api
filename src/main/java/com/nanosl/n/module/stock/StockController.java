package com.nanosl.n.module.stock;

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
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private StockService service;

    @JsonView(StockView.AllAndItemAll.class)
    @GetMapping
    public Iterable<Stock> findAll() {
        return service.findAll();
    }

    @JsonView(StockView.AllAndItemAll.class)
    @GetMapping("/page")
    Page<Stock> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(StockView.All.class)
    @PostMapping
    public Stock save(@RequestBody Stock stock, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            stock = service.save(stock);
            return stock;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(StockView.AllAndItemAll.class)
    @GetMapping("/{id}")
    public Stock findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(StockView.AllAndItemAll.class)
    @PutMapping("/{id}")
    public Stock updateCustomer(@PathVariable int id, @RequestBody Stock stock, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        stock.setId(id);
        stock = service.save(stock);
        return stock;
    }
}
