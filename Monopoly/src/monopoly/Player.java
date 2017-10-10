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
                r.setBought(true);
                this.deductMoney(r.getCost());
                this.OwnedCountries.add(r);
                return true;
            }
        }
        //
        else if(currentLocation instanceof WaterElec)
        {
            WaterElec w = (WaterElec) currentLocation;
                
            if(w.isBought())
            {
                for(int i=0 ; i < OwnedCountries.size() ; i++)
                {
                    if(OwnedCountries.get(i).getName().equals(w.getName()))
                    {
                        System.out.println("You already own this property.");
                        return false;
                    }
                }
                
                System.out.println("WaterElec is already owned by "+w.getOwner());
                return false;
            }
            
            else
            {
                w.setOwner(this.Name);
                w.setBought(true);
                this.deductMoney(w.getCost());
                this.OwnedCountries.add(w);
                return true;
            }
        }
        //
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
                    y += 83;

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
    }
    
    public void checkRent(ArrayList <Player> ps,Dice d)
    {
       if(currentLocation instanceof Country)
        {
            Country c = (Country) currentLocation;
            if(c.isBought())
            {
               String name = c.getOwner();
               
                for(int i=0; i< ps.size();i++)
                {
                    if(this.getName() == name)
                    {System.out.println("5alas"); return;}
                      
                    else if (ps.get(i).getName()== name)
                    {   
                        this.Money -= c.getRent();
                        ps.get(i).addMoney(c.getRent());
                        System.out.println("hi");
                        return;
                    }    
                }
            }
        }
       
       else if(currentLocation instanceof WaterElec)
       {
           WaterElec w = (WaterElec) currentLocation;
           
           if(w.isBought())
           {
               String name = w.getOwner();
               
               for(int i=0; i< ps.size();i++)
                {
                    if(this.getName() == name)
                    {
                        System.out.println("5alas");
                        return;
                    }
                
                      
                    else if (ps.get(i).getName() == name)
                    {   
                        ArrayList <Location> l = ps.get(i).getOwnedCountries();
                        String tileName = w.getName();
                        
                        for(int j=0; j<l.size();j++)
                        {
                            if(tileName == "Water Company")
                            {
                                if(l.get(i).getName().equals("Electric Company") )
                                {
                                    this.Money -= 10*d.getDiceRoll();
                                    ps.get(i).addMoney(10*d.getDiceRoll());          
                                }
                                else
                                {
                                    this.Money -= 4*d.getDiceRoll();
                                    ps.get(i).addMoney(4*d.getDiceRoll());
                                }
                                return;
                            }
                            else if (tileName == "Electric Company")
                            {
                                if(l.get(i).getName().equals("Water Works") )
                                {
                                    this.Money -= 10*d.getDiceRoll();
                                    ps.get(i).addMoney(10*d.getDiceRoll());
                                }
                                else
                                {
                                    this.Money -= 4*d.getDiceRoll();
                                    ps.get(i).addMoney(4*d.getDiceRoll());
                                } 
                                return;
                            }
                        }
                        return;
                    }    
                }
            }
        }
        else if(currentLocation instanceof RailRoad)
        {
           RailRoad r = (RailRoad) currentLocation;
           
           if(r.isBought())
           {
               String name = r.getOwner();
               
               for(int i=0; i< ps.size();i++)
                {
                    if(this.getName() == name)
                    {
                        System.out.println("5alas");
                        return;
                    }
                
                    else if (ps.get(i).getName() == name)
                    {   
                        ArrayList <Location> l = ps.get(i).getOwnedCountries();
                        int rent = 0;
                        
                           for(int j=0; j<l.size();j++)
                           {
                               if(l.get(i) instanceof RailRoad)
                               {
                                   rent+=25;
                               }
                           }                              
                            this.Money -= rent;
                            ps.get(i).addMoney(rent);
         
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
    
    public void checkTaxes()
    {
        if(currentLocation.getName().equals("Luxury Tax"))
        {
            this.Money -= 7500;
        }
        
        else if(currentLocation.getName().equals("Income Tax"))
        {
            this.Money -= 0.1*this.Money;
        }
    }
    
    
    public boolean isPrisoned()
    {
        if (this.currentLocation.getName().equals( "Go to Jail"))
    //        this.setCurr(Jail);
            return true ;
        
        else return false ;
    }
    
    public boolean hasLost()
    {
        if(this.getMoney()<=0)
            return true;
        else 
            return false;
    }
   
    public void checkCommunity(javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        if(currentLocation instanceof communityChest)
        {
            communityChest c = (communityChest) currentLocation;
            c.assignCommunityChest(this, moveTimer, DiceTimer, Dice, Game);
        }
    }
}