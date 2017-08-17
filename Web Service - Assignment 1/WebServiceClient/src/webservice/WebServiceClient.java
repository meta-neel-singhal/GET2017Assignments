package webservice;

import java.util.Scanner;

/**
 * Class for web service client.
 * 
 * @author Neel Singhal
 */
public class WebServiceClient {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		FahrenheitToCelsiusServiceLocator locatorObject = new FahrenheitToCelsiusServiceLocator();
		locatorObject.setFahrenheitToCelsiusEndpointAddress("http://localhost:8080/Web_Service_Assignment_1/services/FahrenheitToCelsius");
		boolean flag;
		Scanner scan = new Scanner(System.in);;
		double temperature;
		String repeat;
		// Run until user wants to convert temperature from fahrenheit to celsius.
		do {
			flag = false;
			try {
				FahrenheitToCelsius temperatureObject = locatorObject.getFahrenheitToCelsius();
				System.out.println("Enter temperature in Fahrenheit: ");
				temperature = scan.nextDouble();
				System.out.println("Temperature in celsius is: " + temperatureObject.convertFahrenheitToCelsius(temperature));
				System.out.println("Check another temperature: (y/n)");
				repeat = scan.next();
				// Check if user wants to convert another temperature from fahrenheit to celsius.
				switch (repeat) {
				case "y":
				case "Y":
					main(args);				
					break;
				default:
					System.out.println("Thank You.");
					System.exit(0);
					break;
				}
			}
			catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
			finally {
				scan.close();
			}
		} while (flag);
	}
}
