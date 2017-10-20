package com.nanosl.n.module.item;

import com.nanosl.n.module.itemtype.ItemTypeView;
import com.nanosl.n.utility.PageView;

public class ItemView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface ItemType {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface AllAndItemTypeAll extends All, ItemType, ItemTypeView.All {
    }

}
