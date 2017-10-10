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
    private boolean Forward = true;
    
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
    
    public void setDirection(boolean f){Forward = f;}
    
    public boolean isForward(){return Forward;}
    
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
    
    public void Move(boolean Forward)
    {       
        if(Forward)
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
            if(Index == 0)
                this.Money += 200;
        }
        
        else
        {
            if(Index >= 0 && Index <= 9)
            {
                if(Index == 0 || Index == 9)
                    x += 83;

                else
                    x += 58;
            }

            else if(Index >= 10 && Index <= 19)
            {
                if(Index == 10 || Index == 19)
                    y += 83;

                else
                    y += 58;
            }

            else if(Index >= 20 && Index <= 29)
            {
                if(Index == 20 || Index  == 29)
                    x -= 83;

                else
                    x -= 58;
            }

            else if(Index  >= 30 && Index <= 39)
            {
                if(Index  == 30 || Index == 39)
                    y-= 83;

                else
                    y -= 58;                
            }

            Index = (Index-1)%40;  
            if(Index == 0)
                this.Money += 200;
        }
<<<<<<< HEAD
                  
        Index = (Index+1)%40;  
        if(Index == 0)
            this.Money += 200;
=======
>>>>>>> 457b8c73a9b484935722a3c1f04fe6f5f81a5860
    }
    
    public void checkRent(ArrayList <Player> ps)
    {
       if(currentLocation instanceof Country)
        {
            Country c = (Country) currentLocation;
            if(c.isBought())
            {
               String name = c.getOwner();
               
               
               
                for(int i=0; i< ps.size();i++)
<<<<<<< HEAD
                {   
                    if(this.Name == name)
                    {
                        System.out.println("5alas"); 
                        return;
                    }
=======
                {
                    if(this.getName() == name)
                    {System.out.println("5alas"); return;}
>>>>>>> 457b8c73a9b484935722a3c1f04fe6f5f81a5860
                      
                    else if (ps.get(i).getName()== name)

                    {   
                        this.Money -= c.getRent();
                        ps.get(i).addMoney(c.getRent());
<<<<<<< HEAD

                        System.out.println("The rent have been paid");

=======
                        System.out.println("hi");
>>>>>>> 457b8c73a9b484935722a3c1f04fe6f5f81a5860
                        return;
                    }    
                }
            }
        }
    }

    public void checkChance(javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        if(currentLocation instanceof Chance)
        {
            Chance c = (Chance) currentLocation;
            c.assChance(this, moveTimer, DiceTimer, Dice, Game);
        }
    }
   
}