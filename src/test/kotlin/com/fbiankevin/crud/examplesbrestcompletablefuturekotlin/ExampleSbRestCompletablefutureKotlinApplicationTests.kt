package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.model.Student
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.lang.RuntimeException
import java.util.concurrent.CompletableFuture

class ExampleSbRestCompletablefutureKotlinApplicationTests {

    @Test
    fun contextLoads() {
        val name = "Kevin"


        CompletableFuture.supplyAsync {
            Thread.sleep(1000)
            println(Thread.currentThread().name)
            "Hello $name"
        }.thenApplyAsync {
            println(Thread.currentThread().name);Thread.sleep(1000); "Mr. $it"
        }.thenApply { println("hehehehe") }
                .thenAccept {  }
                .thenApply {  }





//        CompletableFuture<String> completableFuture
//        =  CompletableFuture.supplyAsync{
//            if (name == null) {
//                throw RuntimeException("Computation error!");
//            }
//             "Hello, " + name;
//        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
//
//        assertEquals("Hello, Stranger!", completableFuture.get());
    }

}
