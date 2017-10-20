/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.team;

import com.nanosl.n.module.menu.MenuView;
import com.nanosl.n.module.teammenu.TeamMenuView;
import com.nanosl.n.utility.PageView;

/**
 *
 * @author Daminda
 */
public class TeamView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface TeamMenuList {
    }

    public static interface User {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface AllAndMenuAll extends All, TeamMenuList, TeamMenuView.Menu, MenuView.All {
    }
}
