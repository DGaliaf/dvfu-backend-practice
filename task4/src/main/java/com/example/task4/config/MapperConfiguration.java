package com.example.task4.config;

import org.modelmapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        return mapper;
    }


}