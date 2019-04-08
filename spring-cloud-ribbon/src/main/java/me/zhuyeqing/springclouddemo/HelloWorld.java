package me.zhuyeqing.springclouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class HelloWorld {

    @Autowired
    private DiscoveryClient client;


    @InitBinder
    public void init(){
        System.out.println("init");
    }
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, String name){
        System.out.println(request.getAttribute("name"));
        return "hello"+ name;
    }
    @RequestMapping("/service-instances/{applicationName}")
    public Object getServerInstances(@PathVariable String applicationName){
        return client.getInstances(applicationName);
    }
}
