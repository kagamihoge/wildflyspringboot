package com.kagamihoge.wildflyspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.kagamihoge.wildflyspringboot.ApplicationTest.MyTestsConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=test"})
@Import(MyTestsConfiguration.class)
public class ApplicationTest {
	
	@Value("${unit-test.value}")
	String value;

	@Test
	public void test() {
		System.out.println(value);
	}
	
	@TestConfiguration
	static class MyTestsConfiguration {
		
	}

}
