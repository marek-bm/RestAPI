package com.mj.restapi.service;

import com.mj.restapi.model.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


public interface ItemService {

    public Item updateItem(Item item, Map<String, Object> updates);
}
