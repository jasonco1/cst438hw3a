package cst438hw2.domain;

//import org.springframework.beans.factory.annotation.Autowired;

public class CityInfo {
	
	public City city;
	public Country country;
	public TempAndTime tempAndTime;
		
	public CityInfo(City city, Country country, TempAndTime tempAndTime) {
		this.city = city;
		this.country = country;
		this.tempAndTime = tempAndTime;
	}

}
