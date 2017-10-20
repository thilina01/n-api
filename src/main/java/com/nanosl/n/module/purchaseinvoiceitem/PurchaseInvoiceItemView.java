package com.nanosl.n.module.purchaseinvoiceitem;

import com.nanosl.n.module.item.ItemView;
import com.nanosl.n.module.purchaseinvoice.PurchaseInvoiceView;
import com.nanosl.n.utility.PageView;

public class PurchaseInvoiceItemView {

    public static interface Id {
    }

    public static interface Price {
    }

    public static interface Quantity {
    }

    public static interface Item {
    }

    public static interface PurchaseInvoice {
    }

    public static interface All extends Id, Price, Quantity, PageView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndPurchaseInvoiceAll extends All, PurchaseInvoice, PurchaseInvoiceView.All {
    }

}
