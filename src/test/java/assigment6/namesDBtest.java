package assigment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays; 

import org.junit.jupiter.api.Test;


class namesDBTest {

    



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
    void findNameThatExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        assertEquals(inMemoryNameDB.nameExists("Abe"), true);
    }

    @Test
    void findNameThatDoesntExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        assertEquals(inMemoryNameDB.nameExists("dsfjh"), false);
    }

    @Test
    void getPopularityOfNameThatExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 380, 215);
        
        assertEquals(inMemoryNameDB.getPopularityOfName("Aaliyah"), comparedList);
    }

    @Test
    void getPopularityOfNameThatExistsBadCapitalizationInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 380, 215);
        
        assertEquals(inMemoryNameDB.getPopularityOfName("atHena"), comparedList);
    }

    @Test
    void getPopularityOfNameThatDoesntExistsInMemory() {
        NamesDB inMemoryNameDB = new NamesFromTextfileInMemory("C:\\Users\\spart\\Downloads\\Assignment6\\Assignment6\\names-data.txt", " ");
        List<Integer> comparedList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        assertEquals(inMemoryNameDB.getPopularityOfName("dfsf"), comparedList);
    }
} 
