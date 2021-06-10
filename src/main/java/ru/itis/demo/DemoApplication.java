package ru.itis.demo;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.itis.demo.mappers.MapperFactoryConfigurer;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private List<MapperFactoryConfigurer> mapperFactoryConfigurers;

    @Bean
    public MapperFactory mapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Bean
    public MapperFacade mapperFacade() {
        final MapperFactory mapperFactory = mapperFactory();
        mapperFactoryConfigurers.forEach(configurer -> configurer.configure(mapperFactory));
        return mapperFactory.getMapperFacade();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
