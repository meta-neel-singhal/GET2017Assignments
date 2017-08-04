package helper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the file read and write operations.
 * 
 * @author Neel Singhal
 */
public class FileManager {

	/**
	 * Handles read file operation.
	 * 
	 * @param filePath    has the location of file from which we have to read data.
	 * @return the list of items which contains the content of the file.
	 */
	public List<String> read(String filePath) {
		List<String> items = new ArrayList<String>();
		try {
			items = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
		} 
		catch (IOException exception) {
			System.out.println("File cannot be read.\nTry again!!!");
		}

		return items;
	}

	/**
	 * Handles file write operation.
	 * 
	 * @param billDetails    contains the details needed to be printed in file.
	 * @param filePath       location of file in which we need to add content.
	 */
	public void write(String billDetails, String filePath) {
		try {
			clearRecord(filePath + "'s Bill.csv");
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					filePath + "'s Bill.csv"), true));
			writer.write(billDetails);
			writer.close();
		} 
		catch (IOException exception) {
			System.out.println("File cannot be write.\nTry again!!!");
		}
	}

	/**
	 * Clears the content of file if already present.
	 * 
	 * @param filePath    location to be checked for duplicate file entry.
	 */
	public void clearRecord(String filePath) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filePath);
			writer.print("");
			writer.close();
		} 
		catch (FileNotFoundException exception) {
			System.out.println("File cannot be found.\nTry again!!!");
		}
	}
}
