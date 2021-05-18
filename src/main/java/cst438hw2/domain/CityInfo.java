package cst438hw2.domain;

//import org.springframework.beans.factory.annotation.Autowired;

public class CityInfo {
	
	public City city;
//	public Country country;
//	public TempAndTime tempAndTime;
	public String name;
	public double tempf;
	public String adjustTime;
		
	public CityInfo(City city, String name, double tempf, String adjustTime) {
		this.city = city;
		this.name = name;
		this.tempf = tempf;
		this.adjustTime = adjustTime;
	}
}
