package com.nanosl.n.module.mailconfiguration;

import com.nanosl.n.utility.PageView;

public class MailConfigurationView {

    public static interface Id {
    }

    public static interface Host {
    }

    public static interface Port {
    }

    public static interface User {
    }

    public static interface Password {
    }

    public static interface All extends Id, Host, Port, User, Password, PageView.All {
    }

}
