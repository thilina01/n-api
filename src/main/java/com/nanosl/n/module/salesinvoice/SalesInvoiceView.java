package com.nanosl.n.module.salesinvoice;

import com.nanosl.n.module.item.ItemView;
import com.nanosl.n.module.salesinvoiceitem.SalesInvoiceItemView;
import com.nanosl.n.module.salesinvoiceitem.SalesInvoiceItemView.Item;
import com.nanosl.n.utility.PageView;

public class SalesInvoiceView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface InvoiceDate {
    }

    public static interface SalesInvoiceItem {
    }

    public static interface Amount {
    }

    public static interface All extends Id, InvoiceDate, Code, Amount, PageView.All {
    }

    public static interface AllAndSalesInvoiceItemAll extends All, SalesInvoiceItem, SalesInvoiceItemView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndSalesInvoiceItemAllAndAllItemAll extends All, SalesInvoiceItem, SalesInvoiceItemView.All, Item, ItemView.All {
    }
}
