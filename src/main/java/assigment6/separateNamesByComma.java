package assigment6;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class separateNamesByComma implements namesSeparator {

    public List<String> separateNames(String namesCloseToEachOther) {
    String[] arrayOfNames =  namesCloseToEachOther.split(",");

    List<String> result = Stream.of(arrayOfNames).map(x -> x.trim()).collect(Collectors.toList());
    return result;
    }

    public static void main(String[] args) {
        namesSeparator trh = new separateNamesByComma();
        List<String> avr = trh.separateNames("wrer, sds"); 
        System.out.println(avr.get(1));
    }
}
