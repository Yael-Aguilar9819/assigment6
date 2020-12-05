package assigment6;

import java.util.Arrays;
import java.util.List;

public class separateNamesByUnderscore implements namesSeparator {

        public List<String> separateNames(String namesCloseToEachOther) {
       String[] arrayOfNames =  namesCloseToEachOther.split("_");
       return Arrays.asList(arrayOfNames);
    }
    
}
