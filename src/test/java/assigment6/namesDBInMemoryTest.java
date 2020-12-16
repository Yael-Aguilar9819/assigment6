package assigment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays; 

import org.junit.jupiter.api.Test;


class namesDBInMemoryTest {

    
    @Test
    void findNameThatExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        assertEquals(inMemoryNameDB.nameExists("Abe"), true);
    }

    @Test
    void findNameThatDoesntExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        assertEquals(inMemoryNameDB.nameExists("dsfjh"), false);
    }

    @Test
    void getPopularityOfNameThatExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 380, 215);
        
        assertEquals(inMemoryNameDB.getPopularityOfName("Aaliyah"), comparedList);
    }

    @Test
    void getPopularityOfNameThatExistsBadCapitalizationInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedListAth = Arrays.asList(0, 0, 0, 0, 0, 0, 783, 623, 659,730,532);
        
        assertEquals(inMemoryNameDB.getPopularityOfName("atHena"), comparedListAth);
    }

    @Test
    void getPopularityOfNameThatDoesntExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(inMemoryNameDB.getPopularityOfName("dfsf"), comparedList);
    }

    @Test
    void getPopularityOfBlankNameInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(inMemoryNameDB.getPopularityOfName(""), comparedList);
    }


    @Test
    void getPopularityOfSpaceInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(inMemoryNameDB.getPopularityOfName(" "), comparedList);
    }

    @Test
    void getPopularityOfManyNames1Exist2DoesntInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedList1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> comparedList2 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> comparedList3 = Arrays.asList(801, 683, 784, 0, 0, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> dsd = new ArrayList<>();
        dsd.add(comparedList1);
        dsd.add(comparedList2);
        dsd.add(comparedList3);

        NamesSeparator injector = new SeparateNamesByComma();
        List<String> listOfNames = injector.separateNames("jsds, jsdsd, Hamilton");

        Map<String, List<Integer>> testing = helperMethodToGetHashMapOfPop(listOfNames, dsd);
        
        assertEquals(inMemoryNameDB.getPopularityOfManyNames(listOfNames), testing);
    }

    @Test
    void getPopularityOfManyNamesBlankDoesntInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("names-data.txt", " ");
        List<Integer> comparedList1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> dsd = new ArrayList<>();
        dsd.add(comparedList1);

        NamesSeparator injector = new SeparateNamesByComma();
        List<String> listOfNames = injector.separateNames("");

        Map<String, List<Integer>> testing = helperMethodToGetHashMapOfPop(listOfNames, dsd);
        
        assertEquals(inMemoryNameDB.getPopularityOfManyNames(listOfNames), testing);
    }


    Map<String, List<Integer>> helperMethodToGetHashMapOfPop(List<String> listOfNames, List<List<Integer>> listOfLists) {
        Map<String, List<Integer>> trydf = new HashMap<>();
        for (int i=0; i < listOfNames.size(); i++) {
            trydf.put(listOfNames.get(i), listOfLists.get(i));
        }
        return trydf;
    }
    
} 
