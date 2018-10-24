/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.repository;

import com.recp.recpbooking.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roshan_inova
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    Iterable<Item> findAllByIsGroup(boolean b);
}
