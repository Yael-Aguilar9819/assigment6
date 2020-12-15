package assigment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.commons.text.WordUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NamesFromTextOnPremise implements NamesDB {
    private File originFile;
    private String separator;
    private Map<String, List<Integer>> namesSeenWithPopularity = new HashMap<>();


    public NamesFromTextOnPremise(String pathToFile, String separator) {
        originFile = new File(pathToFile);
        this.separator = separator;
    }

    public void updateDB() {
        //It's not necesary to update it because it's on premise
    }

    public boolean nameExists(String name) {
        String capitalizedName = WordUtils.capitalizeFully(name);

        try {
            Scanner lineReader = new Scanner(originFile);

            //The lsit that is going to be added to the hashmap
            List<Integer> partialPopularityList = new ArrayList<>();
            
            while (lineReader.hasNextLine()) {
                String[] data = lineReader.nextLine().split(separator);
                
                addNamesAndPopularityToHashMap(data, capitalizedName, partialPopularityList, namesSeenWithPopularity);
            }
            lineReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");    
            e.printStackTrace();
        }

        if (namesSeenWithPopularity.containsKey(capitalizedName)) {
            return true;
        }
        return false;
    }

    public List<Integer> getPopularityOfName(String name) {
        String capitalizedName = WordUtils.capitalizeFully(name);

        //If it's already "cached"it's going to simply get it form that map
        if (namesSeenWithPopularity.containsKey(capitalizedName)) {
            return namesSeenWithPopularity.get(capitalizedName);
        }

        try (Scanner lineReader = new Scanner(originFile)){
            //The list that is going to be added to the hashmap
            List<Integer> partialPopularityList = new ArrayList<>();
            
            while (lineReader.hasNextLine()) {
                String[] data = lineReader.nextLine().split(separator);
                // addNamesAndPopularityToHashMap(data, capitalizedName, partialPopularityList, );
            }

        } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");    
            e.printStackTrace();
        }
    }
    public Map<String, List<Integer>> getPopularityOfManyNames(List<String> names) {
        
    }

    //This method uses whatever maps you give to it
    private void addNamesAndPopularityToHashMap(String[] data, String name, List<Integer>popularityList, Map<String, List<Integer>> agreggatedPopularityMap) {
        for (int i=0; i < data.length; i++) {
            //If the name it's the same as the first word, it's going to count 
            if (data[0].equals(name)) {
                if (i == 0) { //So we can ignore the first word, because its the name
                    continue;
                }
                popularityList.add(Integer.parseInt(data[i]));
                agreggatedPopularityMap.put(name, popularityList);
            }
            else {
                break;
            }
        }
    }

    private Map<String, List<Integer>> scannerToBringPopularityOfNames(Scanner scan, )

    public static void main(String[] args) {
        NamesFromTextOnPremise news = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        System.out.println(news.nameExists("dsdh"));
    }
}
