package assigment6;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files

// implements NamesDB
public class NamesFromTextfileInMemory implements NamesDB{
    private File originFile;
    private Map<String, List<Integer>> inMemoryMap = new HashMap<>();

    public NamesFromTextfileInMemory(String pathToFile, String separator) {
        originFile = new File(pathToFile);

        //This function does the heavy lifting so the DB it's easily updatable
        addingNamesToTheHashmap(separator);
    }

    public boolean nameExists(String name) {
        if (inMemoryMap.containsKey(name)) {
            return true;
        }
        return false;
    }

    public List<Integer> popularityOfName(String name) {
        return inMemoryMap.get(name);
    }

    public void updateDB() {
        addingNamesToTheHashmap(" ");
    }

    private void addingNamesToTheHashmap(String separator) {

        try {
            Scanner lineReader = new Scanner(originFile);
            while (lineReader.hasNextLine()) {
                String[] data = lineReader.nextLine().split(separator);
                // System.out.println(data.toString());    
                
                List<Integer> listOfPopularity = new ArrayList<>();
                String name = "";

                //The first word of the line is the name, the rest it's his popularity 
                for (int i=0; i < data.length; i++) {
                    if (i == 0) {
                        name = data[i];
                        continue;
                    }
                    listOfPopularity.add(Integer.parseInt(data[i]));
                }
                inMemoryMap.put(name, listOfPopularity);

            }   
            lineReader.close();

          } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");
            e.printStackTrace();
          }
    }


    public static void main(String[] args) {
      NamesFromTextfileInMemory DataDB = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\"
                                                             + "Assignment6\\Assignment6\\names-data.txt", " "); 
        System.out.println(DataDB.nameExists("Abigale"));
    }
}
