package monopoly;
public class RailRoad extends Location
{  
    private int Cost = 200;
    private int Rent;
    private String Owner;
   
    
    public RailRoad(String Name) 
    {
        super(Name);
    }
   
    public void setRent(int Rent){this.Rent = Rent;}

    private boolean Bought =false;

    public int getCost(){return Cost;}

    public int getRent(){return Rent;}
    
    public boolean isBought(){return Bought;}
    
    public void setBought(boolean b){ this.Bought = b;}
    
    public String getOwner(){return Owner;}
    
    public void setOwner(String Owner){this.Owner = Owner;}
    public void removeOwner(){this.Owner= "None" ;} 
    
    public String viewInformation()
    {
        return
        "Name: "+getName()+"\n"+
        "Cost: "+"$"+Cost+"\n"+        
        "Owner: "+Owner;  
    }
}
