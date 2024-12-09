package com.example.Reactiveprg.service;

import com.example.Reactiveprg.dau.CustomerDau;
import com.example.Reactiveprg.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class Customerser {

    @Autowired
    private CustomerDau custdau;

    public List<Customer> loadAll(){
        return custdau.getAllcus();
    }

    public Flux<Customer> loadAllStream(){
        return custdau.getAllcusstream();
    }

}
