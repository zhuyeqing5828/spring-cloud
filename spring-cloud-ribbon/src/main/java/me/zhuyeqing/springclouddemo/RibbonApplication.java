package me.zhuyeqing.springclouddemo;

import me.zhuyeqing.springclouddemo.util.SnowFlake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.util.IdGenerator;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonApplication {

	private static final int SERVER_PORT = new Random().nextInt(50000)+10000;

	public static void main(String[] args) {
		System.getProperties().setProperty("server.port",String.valueOf(SERVER_PORT));
		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean("snowFlakeGenerator")
	public IdGenerator idGenerator(@Value("${database_id}") long databaseId,@Value("${machine_id}") long machineId){
		final SnowFlake snowFlake = new SnowFlake(databaseId,machineId);
		final long nodeId = (databaseId<<32) + machineId;
		return new IdGenerator() {
			@Override
			public UUID generateId() {
				return new UUID(nodeId,snowFlake.nextId());
			}
		};

	}

}
