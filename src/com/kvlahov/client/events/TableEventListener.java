/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.events;

/**
 *
 * @author lordo
 */
@FunctionalInterface
public interface TableEventListener<T> {
    void tableEventOccured(TableEvent<T> evt);
}
