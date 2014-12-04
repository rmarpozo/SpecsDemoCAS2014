package es.ruben.cas2014.demoWebApp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.ruben.cas2014.demoWebApp.service.Forecast;
import es.ruben.cas2014.demoWebApp.service.ForecastService;

@Controller
public class HomeController {
	
	@Autowired
	ForecastService forecastService;

	@RequestMapping(value="/")
	public ModelAndView test(
			@RequestParam("humidity") double humidity, 
			@RequestParam("pressure") double pressure) throws IOException{
		
		Forecast nextWeekForecast = forecastService.calculateForecast(humidity, pressure);
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("forecast", nextWeekForecast);
		data.put("humidity", humidity);
		data.put("pressure", pressure);
		
		return new ModelAndView("home", data);
	}
}
