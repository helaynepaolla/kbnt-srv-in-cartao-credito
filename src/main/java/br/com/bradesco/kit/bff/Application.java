package br.com.bradesco.kit.bff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableFeignClients
//@EnableLoggingAutoConfiguration
public class Application implements CommandLineRunner {

        @Autowired
        private Environment environment;

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}