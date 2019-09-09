package com.mj.restapi;

import com.mj.restapi.dao.ItemDao;
import com.mj.restapi.dao.ItemDaoImpl;
import com.mj.restapi.model.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RestApiApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(RestApiApplication.class, args);
        ItemDao itemDao=ctx.getBean(ItemDaoImpl.class);
        itemDao.save(new Item("Item No 1"));
        itemDao.save(new Item("Item No 2"));
    }

}
