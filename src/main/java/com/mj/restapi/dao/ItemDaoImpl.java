package com.mj.restapi.dao;

import com.mj.restapi.model.Item;
import com.mj.restapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ItemService itemService;

    @Override
    public void save(Item item) {
        entityManager.persist(item);
    }

    @Override
    public Item findById(long id) {
        Item item = entityManager.find(Item.class, id);
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public List<Item> findAll() {
        String jpq = "SELECT i from Item i";
        Query query = entityManager.createQuery(jpq);
        List<Item> items = query.getResultList();
        Collections.shuffle(items);
        return items;
    }

    @Override
    public void update(Item item) {
        entityManager.merge(item);
    }

    @Override
    public void deleteById(long id) {
        Item item = findById(id);
        entityManager.remove(item);
    }

    @Override
    public void patchById(long id, Map<String, Object> updates) {
        Item item = findById(id);
        itemService.updateItem(item, updates);
        entityManager.merge(item);
    }
}
