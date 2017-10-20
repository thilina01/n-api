package com.nanosl.n.module.menutype;

import com.nanosl.n.utility.PageView;

public class MenuTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
