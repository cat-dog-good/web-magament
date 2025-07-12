package org.example.webmagament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启了对servlet组件的支持
@SpringBootApplication
public class WebMagamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMagamentApplication.class, args);
    }

}
