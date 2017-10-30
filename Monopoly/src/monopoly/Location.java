package monopoly;

import java.io.*;

public class Location implements Serializable
{
    private String Name;

    public String getName(){return Name;}

    public void setName(String Name){this.Name = Name;}

    public Location(String Name){this.Name = Name;}
    
    public String viewInformation()
    {
       return "";
    }
    
    public String toString()
    {
        return
                Name+"\n";
    }
}
