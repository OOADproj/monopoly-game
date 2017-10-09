package monopoly;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Player
{
    private String Name;
    private Location currentLocation;
    private ArrayList<Location> OwnedCountries = new ArrayList();
    private int Money = 1500;
    private ImageIcon Img;
    private int x;
    private int y;
    private int Index = 0;
    
    public Player(String name,String ImgPath, int x , int y){this.Name = name; this.Img = new ImageIcon(ImgPath); this.x = x ; this.y = y;}

    public ImageIcon getImage(){return Img;};
    
    public String getName(){return Name;}
    
    public int getMoney(){return Money;}

    public void addMoney(int Money){this.Money += Money;}
               
    public void deductMoney(int Money){this.Money -= Money;}
    
    public Location getCurrentLocation(){return currentLocation;}

    public void setCurr(Location currentLocation){this.currentLocation = currentLocation;}

    public ArrayList<Location> getOwnedCountries(){return OwnedCountries;}
    
    public void addOwned(Country c){this.OwnedCountries.add(c);}
    
    public void setIndex(int i){Index = i;}
    
    public int getIndex(){return Index;}
    
    public boolean Buy()
    {
        if(currentLocation instanceof Country)
        {
            Country c = (Country) currentLocation;
            if(c.isBought())
            {
                for(int i=0 ; i < OwnedCountries.size() ; i++)
                {
                    if(OwnedCountries.get(i).getName().equals(c.getName()))
                    {
                        System.out.println("You already own this property.");
                        return false;
                    }
                }
                
                System.out.println("Country is already owned by "+c.getOwner());
                return false;
            }
            
            else
            {
                c.setOwner(this.Name);
                c.setBought(true);
                this.deductMoney(c.getCost());
                this.OwnedCountries.add(c);
                return true;
            }
        }
            
        else if(currentLocation instanceof RailRoad)
        {
            RailRoad r = (RailRoad) currentLocation;
            if(r.isBought())
            {
                for(int i=0 ; i < OwnedCountries.size() ; i++)
                {
                    if(OwnedCountries.get(i).getName().equals(r.getName()))
                    {
                        System.out.println("You already own this property.");
                        return false;
                    }
                }
                
                System.out.println("RailRoad is already owned by "+r.getOwner());
                return false;
            }
            
            else
            {
                r.setOwner(this.Name);
                this.deductMoney(r.getCost());
                this.OwnedCountries.add(r);
                return true;
            }
        }
        
        else
        {
            System.out.println("This tile cannot be bought");
            return false;
        }
    }
    
    public void draw(Graphics g , Board b)
    {
        g.drawImage(Img.getImage(),x,y,Img.getIconWidth(),Img.getIconHeight(),b);
    }
    
    public void Move()
    {            
        if(Index >= 0 && Index <= 9)
        {
            if(Index == 0 || Index == 9)
                x -= 83;
            
            else
                x -= 58;
        }
        
        else if(Index >= 10 && Index <= 19)
        {
            if(Index == 10 || Index == 19)
                y -= 83;
                
            else
                y -= 58;
        }
        
        else if(Index >= 20 && Index <= 29)
        {
            if(Index == 20 || Index  == 29)
                x += 83;
            
            else
                x += 58;
        }
        
        else if(Index  >= 30 && Index <= 39)
        {
            if(Index  == 30 || Index == 39)
                y+= 83;
            
            else
                y += 58;                
        }
                  
        Index = (Index+1)%40;  
    }
    
    public void checkRent(ArrayList <Player> ps)
    {
       if(currentLocation instanceof Country)
        {
            Country c = (Country) currentLocation;
            if(c.isBought())
            {
               String name = c.getOwner();
               
               if(this.Name == name)
                {
                    System.out.println("5alas");
                    return;
                }
               
                for(int i=0; i< ps.size();i++)
                { 
                    if (ps.get(i).getName() == name)
                    {   
                        this.deductMoney(c.getRent());
                        ps.get(i).addMoney(c.getRent());
                        return;
                    }    
                }
            }
        }
    }

}
