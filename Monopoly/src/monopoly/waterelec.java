package monopoly;
public class waterelec extends Location 
{
    private int Cost = 150;
    private boolean Bought = false;
    private String Owner = "None";
    
    public waterelec(String Name)  {super(Name);}
    
    public boolean isBought(){return Bought;}
    
    public int getCost(){return Cost;}
    
    public void setBought(boolean Bought){this.Bought = Bought;}

    public String getOwner(){return Owner;}
    
    public void setOwner(String Owner){this.Owner = Owner;}
    
    public String viewInformation()
    {
        return
        "Name: "+getName()+"\n"+
        "Cost: "+"$"+Cost+"\n"+        
        "Owner: "+Owner;  
    }
}
