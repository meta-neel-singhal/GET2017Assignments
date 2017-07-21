import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * 
 * @author Neel Singhal Singhal
 */
public class Question implements Comparable<Question>{
    String question;
	
    public Question(String question) {
		this.question = question;
	}
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	Scanner scanItem = new Scanner(System.in);

	/**
	 * 
	 * 
	 * @param filePath
	 * @return
	 */
	public String[][] readFile(String filePath) {
		int index = 0;
		String question[][] = new String[5][];
		try {
			FileInputStream stream = new FileInputStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String data = "";
			data = reader.readLine();
			while (data != null) {
				question[index++] = data.split(",");
			}
			reader.close();
		} catch (Exception exception) {}
		return question;
	}

	/**
	 * 
	 * @param data
	 * @param filePath
	 */
	public void writeFile(String data, String filePath){
		try {
			FileWriter fileWrite = new FileWriter(new File(filePath));
			BufferedWriter writer = new BufferedWriter(fileWrite);

			if(data.equals("-1")) {
				writer.newLine();
			}
			else {
				writer.write(data);
			}
			writer.close();
		} catch (Exception exception) {}
	}

	public void takeInputFromUser(int participant, String questions[][]) {
		for (int rowIndex = 0; rowIndex < questions.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex <  questions[rowIndex].length; columnIndex++) {
				System.out.println(questions[rowIndex][columnIndex]);
			}
			if("(Type) Single Select".equals( questions[rowIndex][1] ) )
			{
				int answer = scanItem.nextInt();
				while( (answer < 0) || (answer > 5))
				{
					System.out.print("Enter correct option from 1 to 5");
					answer = scanItem.nextInt();
				}
				writeFile("Participant" + " " + participant + "," + answer,"C:/Users/Neel Singhal/Desktop/Report-B.txt");
			}
			else if("(Type) Multi Select".equals( questions[rowIndex][1] ) )
			{
				String answer = scanItem.next();
				writeFile("," + answer, "C:/Users/Neel Singhal/Desktop/Report-B.txt");
			}
			else if("(Type)Text".equals( questions[rowIndex][1] ))
			{
				String answer = scanItem.next();
				writeFile("," + answer, "C:/Users/Neel Singhal/Desktop/Report-B.txt");
			}
			else if("(Type) Number".equals( questions[rowIndex][1] ))
			{
				long answer = scanItem.nextLong();
				while( String.valueOf(answer).length() != 10 )
				{
					System.out.print("Enter 10 digit number");
					answer = scanItem.nextLong();
				}
				writeFile("," + answer , "C:/Users/Neel Singhal/Desktop/Report-B.txt");
			}
		}
		writeFile("-1", "C:/Users/Neel Singhal/Desktop/Report-B.txt");
	}

	@Override
	public int compareTo(Question comparedQuestion) {
        String nextQuestion = comparedQuestion.question;
		
		return question.compareTo(nextQuestion);
	}
}