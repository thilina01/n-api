package com.nanosl.n.module.purchaseinvoice;

import com.nanosl.n.module.item.ItemView;
import com.nanosl.n.module.purchaseinvoiceitem.PurchaseInvoiceItemView;
import com.nanosl.n.module.purchaseinvoiceitem.PurchaseInvoiceItemView.Item;
import com.nanosl.n.utility.PageView;

public class PurchaseInvoiceView {

    public static interface Id {
    }

    public static interface InvoiceDate {
    }

    public static interface Amount {
    }

    public static interface PaidAmount {
    }

    public static interface Discount {
    }

    public static interface PurchaseInvoiceItem {
    }

    public static interface All extends Id, InvoiceDate, Amount, PaidAmount, Discount, PageView.All {
    }

    public static interface AllAndPurchaseInvoiceItemAll extends All, PurchaseInvoiceItem, PurchaseInvoiceItemView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndPurchaseInvoiceItemAllAndAllItemAll extends All, PurchaseInvoiceItem, PurchaseInvoiceItemView.All, Item, ItemView.All {
    }

}
