package com.mj.restapi.preloadData;

import com.mj.restapi.dao.ItemDao;
import com.mj.restapi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PreloadToH2 implements CommandLineRunner {

    @Autowired
    ItemDao itemDao;

    @Override
    public void run(String... args) throws Exception {
        itemDao.save(new Item("Item No 1"));
        itemDao.save(new Item("Item No 2"));
    }
}
