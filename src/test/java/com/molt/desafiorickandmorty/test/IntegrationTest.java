package com.molt.desafiorickandmorty.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import com.molt.desafiorickandmorty.DesafioRickAndMortyApplication;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@SuppressWarnings("deprecation")
@SpringBootTest(classes = DesafioRickAndMortyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {
	
	private static final Logger logger = LoggerFactory.getLogger(IntegrationTest.class);

	@LocalServerPort
	private int port;
	
	private OkHttpClient client;
	
	@BeforeEach
	void okhttpclient()
	{
		client = new OkHttpClient().newBuilder().build();
	}
	
	@Test
	@DisplayName("getCharacterTest")
	void ConsultaGetCharacter() throws ParseException, IOException {	
		
		String url = String.format("http://localhost:%d/api/character/2" , port);
		
		Request request = new Request.Builder()
			      .url(url)
			      .get()
			      .build();
		
		Call call = client.newCall(request);
	    Response response = call.execute();
	    
		assertEquals(200,response.code());
		String responseBody = response.body().string();
		logger.info("Response test: "+responseBody);
		assertTrue(responseBody.contains("Morty"));

	}
}
