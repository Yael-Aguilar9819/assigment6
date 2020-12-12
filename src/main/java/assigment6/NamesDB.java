package assigment6;
//The DB should be the interface that connects with the rest of the world
//with the methods that give the name and popularity
//Like fetch popularity name
//Existance of name

import java.util.List;

public interface NamesDB {
    public boolean nameExists(String name);
    public List<Integer> popularityOfName(String name);
    public void updateDB();
} 
