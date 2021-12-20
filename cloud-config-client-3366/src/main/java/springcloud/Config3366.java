package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Wang Yuran
 * @create 2021-08-31 17:01
 */
@SpringBootApplication
@EnableEurekaClient
public class Config3366 {

    public static void main(String[] args) {
        SpringApplication.run(Config3366.class,args);
    }
}
