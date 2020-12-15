package assigment6;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.text.WordUtils;
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
        if (inMemoryMap.containsKey(WordUtils.capitalizeFully(name))) {
            return true;
        }
        return false;
    }

    public List<Integer> getPopularityOfName(String name) {
        if (inMemoryMap.containsKey(WordUtils.capitalizeFully(name))) {
            return inMemoryMap.get(WordUtils.capitalizeFully(name));
        }

        List<Integer> popularityFilledWithZeros = new ArrayList<Integer>();

        for (List<Integer> value : inMemoryMap.values()) {
            //It's going to return a list of the number of integers of popularity, but filled with 0
            popularityFilledWithZeros = new ArrayList<Integer>(Collections.nCopies(value.size(), 0));
            break;
        }
        return popularityFilledWithZeros;

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

    public Map<String, List<Integer>> getPopularityOfManyNames(List<String> names) {
        Map<String, List<Integer>> popularityOfManyNames = new HashMap<>();

        for (String name : names) {
            popularityOfManyNames.put(WordUtils.capitalizeFully(name), getPopularityOfName(name));
        }
        return popularityOfManyNames;
    }
}
