package org.kyawhlaing.springdatajdbc3;

import org.junit.jupiter.api.Test;
import org.kyawhlaing.springdatajdbc3.model.Speaker;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class Springdatajdbc3ApplicationTests {

	@Test
	void testCreateSpeaker()
	{
		RestTemplate restTemplate = new RestTemplate();

		Speaker speaker = new Speaker();
		speaker.setName("John Henry");

		restTemplate.put("http://localhost:8080/", speaker);
	}

	@Test
	void contextLoads() {
	}

}
