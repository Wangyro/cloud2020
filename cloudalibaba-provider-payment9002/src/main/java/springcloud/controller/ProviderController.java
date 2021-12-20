package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Yuran
 * @create 2021-09-02 17:39
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string+",port:"+serverPort;
    }
}
