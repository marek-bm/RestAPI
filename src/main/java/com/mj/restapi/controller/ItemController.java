package com.mj.restapi.controller;

import com.mj.restapi.dao.ItemDao;
import com.mj.restapi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemResourceAssembler resourceAssembler;

    @GetMapping("/items/{id}")
    public Resource findOneItem(@Min(1) @PathVariable long id) {
        Item item = itemDao.findById(id);
        return resourceAssembler.toResource(item);

    }

    @GetMapping("/items")
    public Resources<Resource<Item>> findAllItems() {
        List<Item> items = itemDao.findAll();

        List resources = items.stream()
                .map(item -> resourceAssembler.toResource(item))
                .collect(Collectors.toList());

        return new Resources<Resource<Item>>(resources,
                linkTo(methodOn(ItemController.class).findAllItems()).withSelfRel());
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public Resource<Item> saveItem(@Valid @RequestBody Item i) {
        itemDao.save(i);
        return resourceAssembler.toResource(i);
    }

    @PutMapping("/items")
    public Resource<Item> updateItem(@Valid @RequestBody Item item) {
        itemDao.update(item);
        return  resourceAssembler.toResource(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemDao.deleteById(id);
    }

    @PatchMapping("/items/{id}")
    public Resource<Item> patchUpdateItem(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        itemDao.patchById(id, fields);
        return resourceAssembler.toResource(itemDao.findById(id));
    }
}
