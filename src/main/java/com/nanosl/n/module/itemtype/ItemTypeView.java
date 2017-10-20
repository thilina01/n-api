package com.nanosl.n.module.itemtype;

import com.nanosl.n.utility.PageView;

public class ItemTypeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
