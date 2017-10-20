/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.user;

import com.nanosl.n.module.status.StatusView;
import com.nanosl.n.module.team.TeamView;
import com.nanosl.n.utility.PageView;

/**
 *
 * @author Daminda
 */
public class UserView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Email {
    }

    public static interface Password {
    }

    public static interface Status {
    }

    public static interface Team {
    }

    public static interface All extends Id, Name, Email, Status, PageView.All {
    }

    public static interface AllAndTeamAll extends All, Team, TeamView.All {
    }

    public static interface AllAndTeamAllAndStatusAll extends AllAndTeamAll, Status, StatusView.All {
    }

    public static interface AllAndTeamAllAndMenuAll extends All, Team, TeamView.AllAndMenuAll {
    }
}
