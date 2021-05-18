package cst438hw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cst438hw2.domain.CityInfo;
import cst438hw2.service.CityService;


//CityRestController returns a JSON object with city weather data from the public
//OpenWeatherMap API
@RestController
public class CityRestController {
	@Autowired
	private CityService cityService;
	@GetMapping("/api/cities/{city}")
	public CityInfo getWeather(@PathVariable("city") String cityName) {
		CityInfo cityInfo = cityService.getCityInfo(cityName);
		if (cityInfo == null) {
			// city not found
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"The city " + cityName + " not found."
					);
		} else {
			return cityInfo;
		}
	}
}

