package assigment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.text.WordUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NamesFromTextOnPremise implements NamesDB {
    private File originFile;
    private String separator;
    private Integer numberOfIntegerInEachLine;
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

        Map<String, List<Integer>> popularityOfNameToMerge = getMapFromPopularityOfOneNameUpdated(originFile, capitalizedName);

        namesSeenWithPopularity.putAll(popularityOfNameToMerge);

        //After this process, if it's not in the map, it's just not there
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

        //We merge the main map with the one we got
        Map<String, List<Integer>> mapToMerge = getMapFromPopularityOfOneNameUpdated(originFile, capitalizedName);
        namesSeenWithPopularity.putAll(mapToMerge);
        
        List<Integer>popularityOfName = namesSeenWithPopularity.get(capitalizedName);

        if (popularityOfName == null) {
            //Thsi gets the size of the items in one line to get it the number of items
            popularityOfName = getListFullOfZeros(numberOfItemsInLine(originFile));
        }        

        return popularityOfName;
    }


    public Map<String, List<Integer>> getPopularityOfManyNames(List<String> names) {
        List<String> capitalizedNames = names.stream().map(name -> WordUtils.capitalizeFully(name)).collect(Collectors.toList());

        Map<String, List<Integer>> mapOfNames = getMapFromPopularityOfListOfNamesUpdated(originFile, capitalizedNames);
        int numberOfItemsInLine = numberOfItemsInLine(originFile); 

        //If the map doesn't have the name as key, it's going to get one added full of zeroes and the same length as
        //The others had
        for (String namesToCheck : capitalizedNames) {
            if (mapOfNames.containsKey(namesToCheck)) {
                continue;
            }
            mapOfNames.put(namesToCheck, getListFullOfZeros(numberOfItemsInLine));
        }

        return mapOfNames;
    }

    //This method uses whatever maps you give to it
    private boolean addNamesAndPopularityToMapAndReturnBoolIfSo(String[] data, String name, Map<String, List<Integer>> agreggatedPopularityMap) {
        
        List<Integer> popularityList = new ArrayList<>();
        // List<Integer> copyOfPopularityList
        for (int i=0; i < data.length; i++) {
            //If the name it's the same as the first word, it's going to count 
            if (data[0].equals(name)) {
                if (i == 0) { //So we can ignore the first word, because its the name
                    continue;
                }
                popularityList.add(Integer.parseInt(data[i]));
            }
            else {
                break;
            }
        }
        if (popularityList.size() > 0) {
            agreggatedPopularityMap.put(name, popularityList);
            return true;
        }
            
        return false;
    }

    private Map<String, List<Integer>> getMapFromPopularityOfOneNameUpdated(File fileToScan, String capitalizedName) {

        //It shoudl be 
        Map<String,List<Integer>> mapOfPopularity = new HashMap<>();

        // List<Integer> partialPopularityList = new ArrayList<>();

        try (Scanner lineReader = new Scanner(fileToScan)){
            //The list that is going to be added to the hashmap
            
            while (lineReader.hasNextLine()) {
                String[] data = lineReader.nextLine().split(separator);
                addNamesAndPopularityToMapAndReturnBoolIfSo(data, capitalizedName, mapOfPopularity);
            }


        } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");    
            e.printStackTrace();
        }

        return mapOfPopularity;

    }

    private Map<String, List<Integer>> getMapFromPopularityOfListOfNamesUpdated(File fileToScan, List<String> listOfCapitalizedNames) {

        Map<String, List<Integer>> mapOfPopularity = new HashMap<>();
        
        Map<String, Boolean> knowIfTheNameItsFound = new HashMap<>();

        //After its found, its going to change to true
        for (String name : listOfCapitalizedNames) {
            knowIfTheNameItsFound.put(name, false);
        }
        

        try (Scanner lineReader = new Scanner(fileToScan)){
            //The list that is going to be added to the hashmap

            while (lineReader.hasNextLine()) {
                String[] data = lineReader.nextLine().split(separator);
                for (String name : knowIfTheNameItsFound.keySet()) {

                    //If that name got added to the map this iteration of line, it's removed from the list so it's
                    //Not asked again and again
                    if (knowIfTheNameItsFound.get(name)) {
                        continue;
                    }

                    boolean gotAdded = addNamesAndPopularityToMapAndReturnBoolIfSo(data, name, mapOfPopularity);

                    if (gotAdded) {
                        knowIfTheNameItsFound.put(name, true);
                    }
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");    
            e.printStackTrace();
        }

        return mapOfPopularity;

    }

    private Integer numberOfItemsInLine(File fileToScan) {
        //If the number it's different than the default null, it's returning that
        if (numberOfIntegerInEachLine != null) {
            return numberOfIntegerInEachLine;
        }

        int lengthOfFile = 0;

        try (Scanner lineReader = new Scanner(fileToScan)){
            //The list that is going to be added to the hashmap
            String[] dataToCount = lineReader.nextLine().split(separator);
            //It's minis because the first item it's the name
            lengthOfFile = dataToCount.length - 1;
            numberOfIntegerInEachLine = lengthOfFile;
            return lengthOfFile;

        } catch (FileNotFoundException e) {
            System.out.println("This is not a path to a file.");    
            e.printStackTrace();
        }
        numberOfIntegerInEachLine = lengthOfFile;
        return lengthOfFile;
    }

    private List<Integer> getListFullOfZeros(int sizeOfListWanted) {
        List<Integer> popularityOfName = new ArrayList<Integer>(Collections.nCopies(numberOfItemsInLine(originFile), 0));
        return popularityOfName;
    }

    public static void main(String[] args) {
        NamesFromTextOnPremise news = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        
        NamesSeparator injector = new SeparateNamesByComma();
        List<String> listOfNames = injector.separateNames("jsds, jsdsd, Hamilton");
        System.out.println(news.getPopularityOfManyNames(listOfNames));

    }
}
