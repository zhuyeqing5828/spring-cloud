package me.zhuyeqing.springclouddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.IdGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired IdGenerator snowFlakeGenerator;
	@Test
	public void testGenerateiId(){
		System.out.println(snowFlakeGenerator.generateId());
	}
}
