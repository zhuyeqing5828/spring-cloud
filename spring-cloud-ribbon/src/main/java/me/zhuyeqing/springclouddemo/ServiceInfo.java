package me.zhuyeqing.springclouddemo;

import me.zhuyeqing.springclouddemo.context.ReturnContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * info about service info
 */
@RestController
public class ServiceInfo {
    @Value("${spring.application.name}")
    String serverName ;
    @Value("${server.port}")
    Integer port;

    @GetMapping("/serviceInfo")
    public ReturnContext getServiceInfo() throws InterruptedException {
        Map map = new HashMap<>();
        map.put("serverName",serverName);
        map.put("port",port);
        ReturnContext returnContext = ReturnContext.Success();
        returnContext.setContent(map);
        Thread.sleep(new Random().nextInt(3000));
        return returnContext;
    }
}
