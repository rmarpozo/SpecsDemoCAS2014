package es.ruben.cas2014.demoWebApp.service;

import org.springframework.stereotype.Service;

@Service
public class ForecastService {
	
	public Forecast calculateForecast(double humidity, double pressure) {

		if(pressure >= 1.7 && humidity >= 0.80) {
			return Forecast.RAINY;
		}
		else if(pressure < 1.7 && humidity >= 0.80) {
			return Forecast.CLOUDY;
		}
		else if(pressure < 1.7 && humidity < 0.80) {
			return Forecast.SUNNY;
		}
		else return Forecast.UNDEFINED;
	}

}
