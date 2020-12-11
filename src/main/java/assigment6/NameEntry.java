package assigment6;

import java.util.List;

//This should be an inmutable class
public class NameEntry {
    private final String name;
    private List<String> namePopularity;

    public NameEntry(String name) {
        this.name = name;
    }
}
