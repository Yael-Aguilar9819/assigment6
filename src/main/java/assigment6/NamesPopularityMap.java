package assigment6;

import java.util.List;
import java.util.Map;

public class NamesPopularityMap {
    String name;
    Map<String, Integer> namePopularity;


    //The constructor gives the names to it's 
    public NamesPopularityMap(List<String> namesToSearch) {
        for (String name : namesToSearch) {
            namePopularity.put(name, 0);
        }
    }

}
