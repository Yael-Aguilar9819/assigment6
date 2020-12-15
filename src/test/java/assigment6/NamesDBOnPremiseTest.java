package assigment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays; 

import org.junit.jupiter.api.Test;


class NamesDBOnPremiseTest {
    
    @Test
    void findNameThatExistsOnPremise() {
        NamesFromTextOnPremise news = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        assertEquals(news.nameExists("Abigale"), true);
    }

    @Test
    void findNameThatDoesntExistsOnPremise() {
        NamesFromTextOnPremise news = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        assertEquals(news.nameExists("djhddfdfsf"), false);
    }


    @Test
    void getPopularityOfNameThatExistsInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 380, 215);
        
        assertEquals(onPremiseNameDB.getPopularityOfName("Aaliyah"), comparedList);
    }

    @Test
    void getPopularityOfNameThatExistsBadCapitalizationInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedListAth = Arrays.asList(0, 0, 0, 0, 0, 0, 783, 623, 659,730,532);
        
        assertEquals(onPremiseNameDB.getPopularityOfName("atHena"), comparedListAth);
    }

    @Test
    void getPopularityOfNameThatDoesntExistsInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(onPremiseNameDB.getPopularityOfName("dfsf"), comparedList);
    }

    @Test
    void getPopularityOfBlankNameInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(onPremiseNameDB.getPopularityOfName(""), comparedList);
    }


    @Test
    void getPopularityOfSpaceInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(onPremiseNameDB.getPopularityOfName(" "), comparedList);
    }

    @Test
    void getPopularityOfManyNames1Exist2DoesntInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
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
        
        assertEquals(onPremiseNameDB.getPopularityOfManyNames(listOfNames), testing);
    }

    @Test
    void getPopularityOfManyNamesBlankDoesntInMemory() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> dsd = new ArrayList<>();
        dsd.add(comparedList1);

        NamesSeparator injector = new SeparateNamesByComma();
        List<String> listOfNames = injector.separateNames("");

        Map<String, List<Integer>> testing = helperMethodToGetHashMapOfPop(listOfNames, dsd);
        
        assertEquals(onPremiseNameDB.getPopularityOfManyNames(listOfNames), testing);
    }



}
