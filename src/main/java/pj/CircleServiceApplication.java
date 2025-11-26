package pj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleServiceApplication.class, args);

        System.out.println("========================================");
        System.out.println("Circle REST Service has been started.");
        System.out.println("Available endpoints:");
        System.out.println("  GET http://localhost:8080/api/circles");
        System.out.println("  GET http://localhost:8080/api/circles/count");
        System.out.println("  GET http://localhost:8080/api/circles/info");
        System.out.println("========================================");
        System.out.println();
    }
}
