package helper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Handles the file read, write and count lines operations.
 * 
 * @author Neel Singhal
 */
public class FileManager {
	/**
	 * Read file
	 * 
	 * @param filePath   Location of file from which we have to read data.
	 * @return the 2D array of strings which contains the content of the file
	 * 
	 */
	public String[][] read(String filePath) {
		int count = countLines(filePath);
		String[][] questions = new String[count][];
		int index = 0;
		try {
			FileInputStream fStream = new FileInputStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fStream));
			String line = "";
			while ((line = reader.readLine()) != null) {
				questions[index++] = line.split("\\,");
			}
			reader.close();
			return questions;
		} 
		catch (Exception exception) {
			System.out.println(exception);
			
			return questions;
		}
	}

	/**
	 * Write File on its location
	 * 
	 * @param surveyDetails    is the content that need to be printed in file
	 * @param filePath         is the location of file which we need to add content
	 * 
	 */
	public void write(String surveyDetails, String filePath) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), true));
			if (surveyDetails.equals("-1")) {
				writer.newLine();
			} else {
				writer.write(surveyDetails);
			}
			writer.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Counts the number of lines from the file.
	 * 
	 * @param filePath    has the location of file.
	 * @return count has total number of lines.
	 */
	public int countLines(String filePath) {
		LineNumberReader reader;
		try {
			reader = new LineNumberReader(new FileReader(filePath));
			int count = 0;
			while ((reader.readLine()) != null) {
			}
			count = reader.getLineNumber();
			reader.close();
			
			return count;
		} 
		catch (Exception exception) {
			System.out.println(exception);
		
			return 0;
		}
	}
}
