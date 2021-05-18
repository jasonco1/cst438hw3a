package cst438hw2.domain;

//import org.springframework.beans.factory.annotation.Autowired;

public class CityInfo {
	
	public City city;
//	public Country country;
//	public TempAndTime tempAndTime;
	public String name;
	public double tempF; //use camel-case for local variable names per Google Java style guide
	public String adjustTime;
		
	public CityInfo(City city, String name, double tempF, String adjustTime) {
		this.city = city;
		this.name = name;
		this.tempF = tempF;
		this.adjustTime = adjustTime;
	}
}
