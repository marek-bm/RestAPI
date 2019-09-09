package com.mj.restapi.controller;

import com.mj.restapi.model.Item;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ItemResourceAssembler implements ResourceAssembler<Item, Resource> {

    @Override
    public Resource toResource(Item item) {
        return new Resource(item,
                linkTo(methodOn(ItemController.class).findOneItem(item.getId())).withSelfRel(),
                linkTo(methodOn(ItemController.class).findAllItems()).withRel("items"));
    }
}
