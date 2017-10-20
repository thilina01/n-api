package com.nanosl.n.module.item;

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
import com.nanosl.n.module.itemtype.ItemType;
import com.nanosl.n.module.appsession.AppSessionService;
import com.nanosl.n.module.itemtype.ItemTypeService;
import com.nanosl.n.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ItemService service;
    @Autowired
    private ItemTypeService itemTypeService;

    @JsonView(ItemView.All.class)
    @GetMapping
    public Iterable<Item> findAll() {
        return service.findAll();
    }

    @JsonView(ItemView.All.class)
    @GetMapping("/page")
    Page<Item> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ItemView.All.class)
    @PostMapping
    public Item save(@RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            if (item.getId() == null && service.findByCode(item.getCode()) != null) {
                throw new Error("Already Exists [ " + item.getCode() + " ]");
            }
            item = service.save(item);
            return item;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Item> items, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            //List<Item> itemsToRemove = new ArrayList<>();
            for (Item item : items) {
                String code = item.getCode();
                if (code == null) {
                    continue;
                }

            }

            /*System.out.println(items.size());
            System.out.println(itemsToRemove.size());
            for (Item item : itemsToRemove) {
                System.out.println(item.getCode());
                Predicate<Item> itemPredicate = i -> i.getCode() == item.getCode();
                items.removeIf(itemPredicate);
            }
            System.out.println(items.size());
            //items.removeAll(itemsToRemove);*/
            service.save(items);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ItemView.All.class)
    @GetMapping("/{id}")
    public Item findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Item update(@PathVariable int id, @RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        item.setId(id);
        item = service.save(item);
        return item;
    }
}
