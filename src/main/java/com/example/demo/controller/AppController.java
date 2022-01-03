/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

/**
 *
 * @author user
 */
import com.example.demo.model.Inventories;
import com.example.demo.service.InventoriesService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class AppController {
 
    @Autowired
    private InventoriesService service;
     // ini adalah kode untuk menangani method yang ada
    // handler methods...
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Inventories> listInventories = service.listAll();
        model.addAttribute("listInventories", listInventories);

        return "index";
    }
    
    @RequestMapping("/new")
    public String showNewInventoriesPage(Model model) {
        Inventories inventories = new Inventories();
        model.addAttribute("inventories", inventories);
     
        return "new_inventories";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("inventories") Inventories inventories) {
        service.save(inventories);
     
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditInventoriesPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_inventories");
        Inventories inventories = service.get(id);
        mav.addObject("inventories", inventories);

        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteInventories(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
}
