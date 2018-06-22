package top.dolo.springboot02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ApplicationTests {


	@Autowired
	ApplicationContext ac;



	@Test
	public void testService(){
		System.out.println(ac.containsBean("helloService"));
	}

}
