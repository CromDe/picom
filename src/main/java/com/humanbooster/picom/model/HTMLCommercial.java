package com.humanbooster.picom.model;

import javax.persistence.Entity;

@Entity
public class HTMLCommercial extends Commercial {
    private String content;

    public HTMLCommercial(Client client, String content) {
        super(client);
        this.content = content;
    }

    public HTMLCommercial() {
        super();
    }
}
