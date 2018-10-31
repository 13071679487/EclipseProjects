package com.rifu.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.junit.Test;

import com.rifu.interceptor.SubmitInterceptor;
import com.rifu.service.WeatherService;
import com.rifu.service.WeatherServiceService;

public class ClientTest {
	@Test
	public void testGetWeatherByCityname()throws Exception{
		WeatherService weatherServicePort = new WeatherServiceService().getWeatherServicePort();
		Client client = ClientProxy.getClient(weatherServicePort);
		client.getInInterceptors().add(new LoggingInInterceptor());
		client.getOutInterceptors().add(new LoggingOutInterceptor());
		client.getOutInterceptors().add(new SubmitInterceptor("rifu", "528428"));
		String resp = weatherServicePort.getWeatherByCity("Ω≠√≈ –");
		System.out.println(resp);
	}
}
