package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Class for web service.
 * 
 * @author Neel Singhal
 */
@WebService
public class FahrenheitToCelsius {

	/**
	 * Convert fahrenheit to celsius.
	 *
	 * @param temperature     the temperature to convert into celsius.
	 * @return temperature    the value of temperature in celsius.
	 */
	@WebMethod
	public double convertFahrenheitToCelsius(double temperature) {
		// Conversion of temperature from fahrenheit to celsius.
		temperature = ((temperature - 32)*5)/9;
		
		return temperature;
	}
}