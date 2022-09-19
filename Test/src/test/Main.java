package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException{	

		try {
			File myObj = new File("operation.txt");
			FileWriter myWriter = new FileWriter("output.txt");
			Scanner myReader = new Scanner(myObj);
			String data = "";
			while (myReader.hasNextLine()) {
				data += myReader.nextLine();
				//System.out.println(data);
				data += "\n";
			}

			myReader.close();

			myWriter.write("" + data);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");


		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		
		}
	}
}


