package com.mycompany.wsalunos20191.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemListaPedido implements Serializable {
    @Id
    private Long id;
    private String data;
    private double valor;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
