package com.nanosl.n.module.salesinvoiceitem;

import com.nanosl.n.module.item.ItemView;
import com.nanosl.n.module.salesinvoice.SalesInvoiceView;
import com.nanosl.n.utility.PageView;

public class SalesInvoiceItemView {

    public static interface Id {
    }

    public static interface Price {
    }

    public static interface Quantity {
    }

    public static interface Item {
    }

    public static interface SalesInvoice {
    }

    public static interface All extends Id, Price, Quantity, PageView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndSalesInvoiceAll extends All, SalesInvoice, SalesInvoiceView.All {
    }

}
