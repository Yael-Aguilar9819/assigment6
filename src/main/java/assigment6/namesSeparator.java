package assigment6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface NamesSeparator{
    public List<String> separateNames(String namesCloseToEachOther);

    default List<String> nameSeparatorByGivenCharacter(String separator, String namesNotSeparated) {
        String[] arrayOfNames =  namesNotSeparated.split(separator);
        

        //We process everything in a single line that capitalizes it and trims the white space
        // List<String> result = listOfNames.stream()
        List<String> result = Arrays.stream(arrayOfNames)
                                .filter(name -> !name.isEmpty()) //This eliminates the empty spaces
                                .map(name -> name.trim())
                                .map(name -> Character.toUpperCase(name.charAt(0)) + name.substring(1))
                                .collect(Collectors.toList());

        
        return result;

    } 
}
