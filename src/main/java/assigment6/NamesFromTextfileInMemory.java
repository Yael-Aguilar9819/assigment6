package assigment6;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

// implements NamesDB
public class NamesFromTextfileInMemory {
    private File originFile;

    public NamesFromTextfileInMemory(String pathToFile) {

        //To read from the file
        try {
            originFile = new File(pathToFile);
            Scanner lineReader = new Scanner(originFile);
            while (lineReader.hasNextLine()) {
                String data = lineReader.nextLine();
                
                

            }
            lineReader.close();

          } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");
            e.printStackTrace();
          }
    }
    public static void main(String[] args) {
      NamesFromTextfileInMemory injector = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\"
                                                             + "Assignment6\\Assignment6\\names-data.txt"); 
        
    }
}
