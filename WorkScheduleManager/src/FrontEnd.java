import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FrontEnd {
	static BackEnd backEnd = new BackEnd();
	public static final String FILENAME = "data";
	public static final String EXTENSION = ".ser";
	
	public static void main(String[] args) {
		
		backEnd.startApplication();
		/*try {
			Scanner fileScanner = new Scanner(new File(FILENAME + EXTENSION));
			String fileLine = "";
			FileOutputStream fileOut = new FileOutputStream(FILENAME+EXTENSION);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			fileScanner.close();
			if(business.getName().equals(""))
				business = backEnd.initializeStore();
		}
		catch (Exception e) {
			business = backEnd.initializeStore();
		}*/
		
	}
}