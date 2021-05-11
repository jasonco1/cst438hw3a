package cst438hw2.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.CountryRepository;
import cst438hw2.service.CityService;
 
//Create a CityController class that handles http get request. 
//The @PathVariable annotation tells spring to parse the URL and 
//put the text that occurs after /cities/ into the cityName parameter.
//name,countryCode,countryName.district,population.temp(f),time
//id,name,countrycode,countryname,district,poplocalweather,localtime
@Controller
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	CityService cityService;
	
    //TO ADD
    //kelvin to Fahrenheit : (temp - 273.15) * 9.0/5.0 + 32.0;
	@GetMapping("/cities/{city}")
	public String getCityInfo(@PathVariable("city") String cityName, 
                               Model model) {
      CityInfo cityInfo = cityService.getCityInfo(cityName);
           
      model.addAttribute("ID", cityInfo.city.getID());
      model.addAttribute("name", cityName);
      model.addAttribute("countryCode", cityInfo.country.getCode());
      model.addAttribute("countryName", cityInfo.country.getName());
      model.addAttribute("district", cityInfo.city.getDistrict());
      model.addAttribute("population", cityInfo.city.getPopulation());
      model.addAttribute("localWeather", cityInfo.tempAndTime.temp);
      model.addAttribute("localTime", cityInfo.tempAndTime.time);
      
      return "city_info";
     }
}

