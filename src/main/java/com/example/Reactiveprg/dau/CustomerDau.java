package com.example.Reactiveprg.dau;

import com.example.Reactiveprg.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



@Component
public class CustomerDau {


    private static void sleepexe(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getAllcus(){
        return IntStream.rangeClosed(1,10)
                .peek(CustomerDau::sleepexe)
                .peek(i-> System.out.println("processing"+i))
                .mapToObj(i->new Customer(i,"customer"+i))
                  .collect(Collectors.toList());
    }

    public Flux<Customer> getAllcusstream(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("processing"+i))
                .map(i->new Customer(i,"customer"+i));
}}
