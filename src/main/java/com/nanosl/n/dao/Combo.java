package com.nanosl.n.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Combo {

    int id;
    String code;
    String name;
    String description;

    public Combo(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

}
