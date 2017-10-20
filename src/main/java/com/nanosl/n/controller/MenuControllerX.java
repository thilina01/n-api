package com.nanosl.n.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosl.n.entity.AppSession;
import com.nanosl.n.dao.Menu;
import com.nanosl.n.module.appsession.AppSessionService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/menusX")
public class MenuControllerX {

    @Autowired
    private AppSessionService appSessionService;

    @GetMapping
    public ArrayList<Menu> getMenus(@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        ArrayList<Menu> menus = new ArrayList<>();
        //System.out.println(email);      
        //AppSession appSession = null;
        //if (!email.equals("")) {}
        AppSession appSession = appSessionService.findOne(email);

        Menu planningMenu = new Menu("Planning", "", "#/kpi");
        planningMenu.getMenus().add(new Menu("Planning", "#controlPointPlanModal"));
        menus.add(planningMenu);

        if (appSession != null) {
            menus.add(new Menu("Logout", "#logoutModal"));
        } else {
            menus.add(new Menu("Login", "#loginModal"));
            menus.add(new Menu("Register", "#registerModal"));
        }

        Menu testMenu2 = new Menu("M2", "M2", "M2");
        menus.add(testMenu2);
        return menus;
    }

}
