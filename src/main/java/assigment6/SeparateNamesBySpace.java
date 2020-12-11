package assigment6;

import java.util.List;

public class SeparateNamesBySpace implements NamesSeparator {

    public List<String> separateNames(String namesCloseToEachOther) {
        String separator = " ";
        
        //The separation is given to a default method in the interface, here we only specify the
        //separator
        List<String> result = nameSeparatorByGivenCharacter(separator, namesCloseToEachOther);
        return result;
    }

}
