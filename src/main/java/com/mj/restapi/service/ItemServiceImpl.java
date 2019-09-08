package com.mj.restapi.service;

import com.mj.restapi.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public Item updateItem(Item item, Map<String, Object> updates) {
        updates.forEach((key,val)->{
            Field field= ReflectionUtils.findField(Item.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, item, val);
        });
        return item;
    }
}
