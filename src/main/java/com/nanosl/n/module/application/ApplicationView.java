/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.application;

import com.nanosl.n.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ApplicationView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface ShortName {
    }

    public static interface All extends Id, Code, Name, ShortName, PageView.All {
    }

}
