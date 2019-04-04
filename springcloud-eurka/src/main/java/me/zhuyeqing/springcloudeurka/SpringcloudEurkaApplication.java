package me.zhuyeqing.springcloudeurka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEurkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurkaApplication.class, args);
	}

}
