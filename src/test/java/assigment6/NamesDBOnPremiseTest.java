package assigment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Arrays;

import org.apache.commons.text.WordUtils;
import org.junit.jupiter.api.Test;


class NamesDBOnPremiseTest {
    
    @Test
    void findNameThatExistsOnPremise() {
        NamesFromTextOnPremise news = new NamesFromTextOnPremise("names-data.txt", " ");
        assertEquals(news.nameExists("Abigale"), true);
    }

    @Test
    void findNameThatDoesntExistsOnPremise() {
        NamesFromTextOnPremise news = new NamesFromTextOnPremise("names-data.txt", " ");
        assertEquals(news.nameExists("djhddfdfsf"), false);
    }


    @Test
    void getPopularityOfNameThatExistsOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 380, 215);
        
        assertEquals(onPremiseNameDB.getPopularityOfName("Aaliyah"), comparedList);
    }

    @Test
    void getPopularityOfNameThatExistsBadCapitalizationOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedListAth = Arrays.asList(0, 0, 0, 0, 0, 0, 783, 623, 659,730,532);
        onPremiseNameDB.getPopularityOfName("Hamilton");
        onPremiseNameDB.getPopularityOfName("Richard");
        onPremiseNameDB.getPopularityOfName("atHena");
        
        assertEquals(onPremiseNameDB.getPopularityOfName("atHena"), comparedListAth);
    }

    @Test
    void getPopularityOfNameThatDoesntExistsOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(onPremiseNameDB.getPopularityOfName("dfsf"), comparedList);
    }

    @Test
    void getPopularityOfBlankNameOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(onPremiseNameDB.getPopularityOfName(""), comparedList);
    }


    @Test
    void getPopularityOfSpaceOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(onPremiseNameDB.getPopularityOfName(" "), comparedList);
    }

    @Test
    void getPopularityOfManyNames1Exist2DoesntOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
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
    void getPopularityOfManyNames1ExistInMiddle2DoesntOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> comparedList2 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 959);
        List<Integer> comparedList3 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> dsd = new ArrayList<>();
        dsd.add(comparedList1);
        dsd.add(comparedList2);
        dsd.add(comparedList3);

        NamesSeparator injector = new SeparateNamesByComma();
        List<String> listOfNames = injector.separateNames("jsds, Abigale, sjdj");

        Map<String, List<Integer>> testing = helperMethodToGetHashMapOfPop(listOfNames, dsd);
        
        assertEquals(onPremiseNameDB.getPopularityOfManyNames(listOfNames), testing);
    }


    @Test
    void getPopularityOfManyNames2ExistBadlyWrittenInMiddle2DoesntOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList1 = Arrays.asList(0, 0, 0, 0, 900, 789, 906, 0, 0, 0, 0);
        List<Integer> comparedList2 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> comparedList3 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 959);
        List<Integer> comparedList4 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> dsd = new ArrayList<>();
        dsd.add(comparedList1);
        dsd.add(comparedList2);
        dsd.add(comparedList3);
        dsd.add(comparedList4);


        NamesSeparator injector = new SeparateNamesBySpace();
        List<String> listOfNames = injector.separateNames("Mel jsds abiGale sjdj");

        Map<String, List<Integer>> testing = helperMethodToGetHashMapOfPop(listOfNames, dsd);
        
        assertEquals(onPremiseNameDB.getPopularityOfManyNames(listOfNames), testing);
    }

    @Test
    void getPopularityOfManyNamesBlankDoesntOnPremise() {
        NamesDB onPremiseNameDB = new NamesFromTextOnPremise("names-data.txt", " ");
        List<Integer> comparedList1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<List<Integer>> dsd = new ArrayList<>();
        dsd.add(comparedList1);

        NamesSeparator injector = new SeparateNamesByComma();
        List<String> listOfNames = injector.separateNames("");

        Map<String, List<Integer>> testing = helperMethodToGetHashMapOfPop(listOfNames, dsd);
        
        assertEquals(onPremiseNameDB.getPopularityOfManyNames(listOfNames), testing);
    }

    Map<String, List<Integer>> helperMethodToGetHashMapOfPop(List<String> listOfNames, List<List<Integer>> listOfLists) {
        Map<String, List<Integer>> trydf = new HashMap<>();
        for (int i=0; i < listOfNames.size(); i++) {
            trydf.put(WordUtils.capitalizeFully(listOfNames.get(i)), listOfLists.get(i));
        }
        return trydf;
    }


}
