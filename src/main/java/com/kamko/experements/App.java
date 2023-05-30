package com.kamko.experements;

import com.kamko.experements.configuration.ConfigurationFile;
import com.kamko.experements.service.ItemService;
import com.kamko.experements.service.impl.ItemServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigurationFile.class);

        ItemService service = context.getBean("itemServiceImpl", ItemServiceImpl.class);
        System.out.println(service.add("Bear", "59.99", 100, LocalDate.of(2023, 5, 11), 60));
//        System.out.println(service.add("Lemonade", "89.99", 150, LocalDate.of(2022, 11, 7), 360));
//        System.out.println(service.add("Water", "29.99", 300, LocalDate.of(2023, 2, 7), 360));
//        service.printAll();
//        System.out.println(service.find(2));
//        // заменяет товар, но присваивает ему новый ID
//        System.out.println(service.update(3, "Water", "39.99", 200, LocalDate.of(2023, 2, 7), 360));
//        service.printAll();
    }
}
