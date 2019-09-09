package com.mj.restapi.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull (message = "Name cannot be null")
    @Size( min = 2, message = "Name must be longer than 2 chars")
    private String name;

    private Timestamp created;

    public Item() {
        this.created= new Timestamp(System.currentTimeMillis());
    }

    public Item(String name) {
        this.name=name;
        this.created= new Timestamp(System.currentTimeMillis());
    }
}

