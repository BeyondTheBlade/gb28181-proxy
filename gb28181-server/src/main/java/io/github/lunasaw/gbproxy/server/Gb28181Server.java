package io.github.lunasaw.gbproxy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luna
 * @date 2023/10/11
 */
@SpringBootApplication
public class Gb28181Server {

    public static void main(String[] args) {
        SpringApplication.run(Gb28181Server.class, args);
    }
}
