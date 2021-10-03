/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

/**
 *
 * @author user
 */
import com.example.demo.model.Inventories;
import java.util.List;

import com.example.demo.repository.InventoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class InventoriesService {
 
    @Autowired
    private InventoriesRepository repo;
     
    public List<Inventories> listAll() {
        return repo.findAll();
    }
     
    public void save(Inventories inventories) {
        repo.save(inventories);
    }
     
    public Inventories get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}