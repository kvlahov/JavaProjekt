/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.events;

import java.util.EventObject;

public class TableEvent<T> extends EventObject{
    private T model;

    public TableEvent(Object source) {
        super(source);
    }
    
    public TableEvent(Object source, T model) {
        super(source);
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
    
}
