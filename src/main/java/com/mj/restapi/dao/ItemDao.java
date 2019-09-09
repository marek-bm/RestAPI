package com.mj.restapi.dao;

import com.mj.restapi.model.Item;
import java.util.List;
import java.util.Map;

public interface ItemDao {

    public void save(Item item);
    public Item findById(long id);
    public List<Item> findAll();
    public void update(Item item);
    public void deleteById(long id);
    public void patchById(long id, Map<String, Object> updates);

}
