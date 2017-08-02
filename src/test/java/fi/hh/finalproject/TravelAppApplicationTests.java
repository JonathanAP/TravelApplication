package fi.hh.finalproject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.finalproject.TravelAppApplication;

//testing that the controller is being created, smoke testing

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAppApplicationTests {

	@Autowired 
	private TravelAppApplication controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}


}
