package assigment6;

import java.util.Arrays;
import java.util.List;

public class separateNamesBySpace implements namesSeparator {

    public List<String> separateNames(String namesCloseToEachOther) {
       String[] arrayOfNames =  namesCloseToEachOther.split(" ");
       return Arrays.asList(arrayOfNames);
    }


}
