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
		Scanner scan = new Scanner(System.in);;
		double temperature;

		try{
			FahrenheitToCelsius temperatureObject = locatorObject.getFahrenheitToCelsius();
			System.out.println("Enter temperature in Fahrenheit: ");
			temperature = scan.nextDouble();
			System.out.println("Temperature in celsius is: " + temperatureObject.convertFahrenheitToCelsius(temperature));
			System.out.println("Check another temperature (y/n): ");
			// Calling repeat function to check if user wish to continue.
			repeat(scan);
		}
		catch (Exception exception) {
			System.out.println("Please enter correct value!!!");
			main(args);
		}
		finally {
			scan.close();
		}
	}

	/**
	 * Check if user wants to convert another temperature from fahrenheit to celsius.
	 *
	 * @param scan    Scanner class object.
	 */
	public static void repeat(Scanner scan) {
		String ans = scan.next();
		switch (ans) {
			case "y":
			case "Y":
				WebServiceClient.main(null);				
				break;
			case "n":
			case "N":
				System.out.println("Thank You.");
				System.exit(0);				
				break;
			default:
				System.out.println("Please enter correct choice (y/n): ");
				repeat(scan);
				break;
		}
	}
}
