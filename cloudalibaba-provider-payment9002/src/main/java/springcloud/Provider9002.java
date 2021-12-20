package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wang Yuran
 * @create 2021-09-02 17:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9002 {
    public static void main(String[] args) {
        SpringApplication.run(Provider9002.class,args);
    }
}

