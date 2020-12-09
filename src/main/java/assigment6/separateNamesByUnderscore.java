package assigment6;

import java.util.Arrays;
import java.util.List;

public class SeparateNamesByUnderscore implements NamesSeparator {

        public List<String> separateNames(String namesCloseToEachOther) {
       String[] arrayOfNames =  namesCloseToEachOther.split("_");
       return Arrays.asList(arrayOfNames);
    }
    
}
