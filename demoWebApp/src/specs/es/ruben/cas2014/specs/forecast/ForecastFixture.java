package es.ruben.cas2014.specs.forecast;

import java.util.HashMap;
import java.util.Map;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import es.ruben.cas2014.demoWebApp.service.Forecast;
import es.ruben.cas2014.demoWebApp.service.ForecastService;

@RunWith(ConcordionRunner.class)
public class ForecastFixture {
	
	ForecastService forecastService = new ForecastService();
	private static Map<Forecast, String> translateMap = new HashMap<Forecast, String>();
	
	@BeforeClass
	public static void initTranslateMap() {
		
		translateMap.put(Forecast.RAINY, "Lluvia");
		translateMap.put(Forecast.CLOUDY, "Nublado");
		translateMap.put(Forecast.SUNNY, "Soleado");
		translateMap.put(Forecast.UNDEFINED, "No se puede calcular");
		
	}
	
	public String getForecast(double humidity, double pressure) {
		Forecast forecast = forecastService.calculateForecast(humidity, pressure);
		return translateMap.get(forecast);
		
	}

}
