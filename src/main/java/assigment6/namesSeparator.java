package assigment6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface NamesSeparator{
    public List<String> separateNames(String namesCloseToEachOther);

    default List<String> nameSeparatorByGivenCharacter(String separator, String namesNotSeparated) {
        String[] arrayOfNames =  namesNotSeparated.split(separator);
        
        List<String> listOfNames = new ArrayList<String>();

        //If the string it's blank, it's going to be removed
        for (String name : arrayOfNames) {
            if (name.isEmpty()) {
                continue;
            }
            listOfNames.add(name);
        }

        //We process everything in a single line that capitalizes it and trims the white space
        List<String> result = listOfNames.stream()
                                .map(name -> name.trim())
                                .map(name -> Character.toUpperCase(name.charAt(0)) + name.substring(1))
                                .collect(Collectors.toList());

        
        return result;

    } 
}
