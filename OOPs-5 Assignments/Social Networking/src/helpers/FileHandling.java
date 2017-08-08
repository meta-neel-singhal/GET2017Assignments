package helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the file read & Write Operations.
 * 
 * @author Neel Singhal
 */
public class FileHandling {

	/**
	 * Read file from its location.
	 * 
	 * @param filePath    Has the location of file from which we have to read data.
	 * @return the List of strings which contains the content of the file.
	 * 
	 */
	public List<String> read(String filePath) {
		List<String> data = new ArrayList<String>();
		try {
			data = Files.readAllLines(Paths.get(filePath));
		} 
		catch (IOException e) {
			System.out.println("File Not Found!!!");
		}
		return data;

	}

	/**
	 * Write File on its location.
	 * 
	 * @param details     Bill that need to be printed in file.
	 * @param filePath    Location of file which we need to add content.
	 * 
	 */
	public void write(String details, String filePath) {
		try {
			clearRecord(filePath);
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true));
			bw.write(details);
			bw.close();
		} 
		catch (IOException e) {
			System.out.println("File Not Found!!!");
		}
	}

	/**
	 * Clears the text file.
	 * 
	 * @param filePath    Location of file which we need to add content.
	 */
	public void clearRecord(String filePath) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filePath);
			writer.print("");
			writer.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		}
	}
}
