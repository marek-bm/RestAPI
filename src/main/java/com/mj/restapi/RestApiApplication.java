package com.mj.restapi;

import com.mj.restapi.dao.ItemDao;
import com.mj.restapi.dao.ItemDaoImpl;
import com.mj.restapi.model.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@SpringBootApplication
public class RestApiApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(RestApiApplication.class, args);
        ItemDao itemDao=ctx.getBean(ItemDaoImpl.class);
        Item aaa=new Item();
        aaa.setName("Name");
        aaa.setSecondName("2 Name");
        aaa.setAge(22);
        itemDao.save(aaa);

    }

}
