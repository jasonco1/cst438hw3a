//This class uses HW2 suggested solution Code
package cst438hw2.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.CountryRepository;
import cst438hw2.service.CityService;
 
//Create a CityController class that handles http get request. 
//The @PathVariable annotation tells spring to parse the URL and 
//put the text that occurs after /cities/ into the cityName parameter.
//name,countryCode,countryName.district,population.temp(f),time
@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	@GetMapping("/cities/{city}")
	public String getWeather(@PathVariable("city") String cityName, Model model) {
		CityInfo cityInfo = cityService.getCityInfo(cityName);
		if (cityInfo == null) {
			//error city no found
			model.addAttribute("error", "City not found. "+cityName);
			return "cityerror";
		} else {
			model.addAttribute("cityInfo", cityInfo);
			return "cityshow";
		}
	}
	
@PostMapping ("/cities/reservation")
	public String createReservation(
			@RequestParam("city") String cityName,
			@RequestParam("vacationLevel") String vacationLevel,
			@RequestParam("email") String email, 
			Model model) {	
		
		model.addAttribute("city", cityName);
		model.addAttribute("vacationLevel", vacationLevel);
		model.addAttribute("email", email);	
		cityService.requestReservation(cityName, vacationLevel, email);
		return "request_reservation";	
	}
}

