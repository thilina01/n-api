/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.stock;

import com.nanosl.n.module.item.ItemView;
import com.nanosl.n.utility.PageView;

/**
 *
 * @author Daminda
 */
public class StockView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface SellingPrice {
    }

    public static interface Item {
    }

    public static interface All extends Id, Code, SellingPrice, PageView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

}
