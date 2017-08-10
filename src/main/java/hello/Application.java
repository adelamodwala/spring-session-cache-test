package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static final String USE_HAZELCAST = "true";

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

}
