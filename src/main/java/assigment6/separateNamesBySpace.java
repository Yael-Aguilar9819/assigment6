package assigment6;

import java.util.Arrays;
import java.util.List;

public class SeparateNamesBySpace implements NamesSeparator {

    public List<String> separateNames(String namesCloseToEachOther) {
        String separator = " ";
        
        //The separation is given to a default method in the interface, here we only specify the
        //separator
        List<String> result = nameSeparatorByGivenCharacter(separator, namesCloseToEachOther);
        return result;
    }

    public static void main(String[] args) {
        NamesSeparator sd =  new SeparateNamesBySpace();
        List<String> nombrecitos =  sd.separateNames("Josh   Kennan  rikix");
        System.out.println(nombrecitos.toString());
    }
}
