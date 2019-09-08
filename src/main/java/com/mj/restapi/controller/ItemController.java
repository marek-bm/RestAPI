package com.mj.restapi.controller;

import com.mj.restapi.dao.ItemDao;
import com.mj.restapi.model.Item;
import com.mj.restapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping ("/items/{id}")
    public Item findOneItem(@Min(1) @PathVariable long id){
        return itemDao.findById(id);
    }

    @GetMapping ("/items")
    public List<Item> findAllItems(){
        return  itemDao.findAll();
    }

    @PostMapping ("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@Valid @RequestBody Item i){
        itemDao.save(i);
    }

    @PutMapping("/items")
    public void updateItem(@Valid @RequestBody Item item){
        itemDao.update(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id){
        itemDao.deleteById(id);
    }

    @PatchMapping("/items/{id}")
    public void patchUpdateItem(@PathVariable long id, @RequestBody Map<String, Object> fields){
        itemDao.patchById(id, fields);
    }












}
