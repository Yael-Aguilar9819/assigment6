package assigment6;

import java.util.Arrays;
import java.util.List;

public class SeparateNamesBySpace implements NamesSeparator {

    public List<String> separateNames(String namesCloseToEachOther) {
       String[] arrayOfNames =  namesCloseToEachOther.split(" ");
       return Arrays.asList(arrayOfNames);
    }
}
