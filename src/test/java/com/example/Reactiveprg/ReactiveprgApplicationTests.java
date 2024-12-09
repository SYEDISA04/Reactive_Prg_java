package com.example.Reactiveprg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveprgApplicationTests {


	   @Test
	   public void testMono(){
       Mono<String> m1 = Mono.just("Hello everyone").log();
        m1.subscribe(System.out::println);
    }

	@Test
   public void fluxTest(){
        Flux<String> f1 = Flux.just("abc", "efg", "hij");
        f1.subscribe(System.out::println);
    }

}
