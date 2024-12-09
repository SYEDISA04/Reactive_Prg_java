package com.example.Reactiveprg.controller;

import com.example.Reactiveprg.dto.Customer;
import com.example.Reactiveprg.service.Customerser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class CustomerCon {

    @Autowired
    private Customerser ser;

    @GetMapping("/any")
    public List<Customer> getAll(){
      return ser.loadAll();
    }

    @GetMapping(value = "/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllStream(){
        return ser.loadAllStream();
    }
}
