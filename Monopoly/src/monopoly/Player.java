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
    private boolean doubleRent = false;
    private boolean isPrisoned = false;
    private boolean freePass = false;
    private boolean cannotCollect = false;
    private boolean hasLost = false;

    
    
    public Player(String name,String ImgPath, int x , int y){this.Name = name; this.Img = new ImageIcon(ImgPath); this.x = x ; this.y = y;}

    public boolean isDoubleRent(){return doubleRent;}
    
    public boolean isPrisoned(){return isPrisoned;}
    
    public boolean hasFreePass(){return freePass;}
    
    public void setFreePass(boolean b){freePass = b;}
    
    public boolean CannotCollect() {return cannotCollect;}
       
    public void setCannotCollect(boolean cannotCollect) {this.cannotCollect = cannotCollect;}
        
    public void setPrisoned(boolean b){isPrisoned = b;}
    
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
    
    public boolean hasLost(){ return hasLost; }
    
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
                        JOptionPane.showMessageDialog(null,"You already own this property");
    
                        return false;
                    }
                }
                
               JOptionPane.showMessageDialog(null,"Country is already owned by "+c.getOwner());
                return false;
            }
            
            else
            {
                if(CanBuy(c.getCost()))
                {
                    c.setOwner(this.Name);
                    c.setBought(true);
                    this.deductMoney(c.getCost());
                    this.OwnedCountries.add(c);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You don't have enough money ");
                     return false;
                }
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
                        JOptionPane.showMessageDialog(null,"You already own this property.");
                        return false;
                    }
                }
                
                JOptionPane.showMessageDialog(null,"RailRoad is already owned by "+r.getOwner());
                return false;
            }
            
            else
            {
                if(CanBuy(r.getCost()))
                {
                    r.setOwner(this.Name);
                    r.setBought(true);
                    this.deductMoney(r.getCost());
                    this.OwnedCountries.add(r);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You don't have enough money ");
                    return false;
                }
            }
        }
        
        else if(currentLocation instanceof waterelec)
        {
            waterelec w = (waterelec) currentLocation;
                
            if(w.isBought())
            {
                for(int i=0 ; i < OwnedCountries.size() ; i++)
                {
                    if(OwnedCountries.get(i).getName().equals(w.getName()))
                    {
                       JOptionPane.showMessageDialog(null,"You already own this property.");
                        return false;
                    }
                }
                
                JOptionPane.showMessageDialog(null,"WaterElec is already owned by "+w.getOwner());
                return false;
            }
            
            else
            {
                if(CanBuy(w.getCost()))
                {
                    w.setOwner(this.Name);
                    w.setBought(true);
                    this.deductMoney(w.getCost());
                    this.OwnedCountries.add(w);
                    return true;
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null,"You don't have enough money ");
                    return false;
                }
                    
            }
        }
       
        else
        {
            JOptionPane.showMessageDialog(null,"This tile cannot be bought");
            return false;
        }
    }
    
    public void draw(Graphics g , Board b)
    {
        if(!hasLost())
            g.drawImage(Img.getImage(),x,y,Img.getIconWidth(),Img.getIconHeight(),b);
        
        else
            Img = null;
        
    }
    
    public boolean Sell()
    {
        if(currentLocation instanceof Country)
        {
            Country c =  (Country) currentLocation;
            if(c.isBought())
            {
               if(c.getOwner().equals(this.Name))
               {
                    c.removeOwner();
                    this.OwnedCountries.remove(c) ; 
                    this.addMoney(c.getCost());
                    c.setBought(false);
                    JOptionPane.showMessageDialog(null, "You sold "+c.getName());
                    return true; 
               }
               
               else
               {
                   JOptionPane.showMessageDialog(null, "You do not own "+c.getName());
                   return false;
               }
                   
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "You do not own "+c.getName());
                return false;
            }
        }
        
        else if(currentLocation instanceof RailRoad)
        {
            RailRoad r = (RailRoad) currentLocation;
            
            if(r.isBought())
            {
                if(r.getOwner().equals(this.Name))
                {
                    r.removeOwner();
                    this.OwnedCountries.remove(r) ; 
                    this.addMoney(r.getCost());
                    r.setBought(false);
                    JOptionPane.showMessageDialog(null, "You sold "+r.getName());
                    return true ; 
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "You do not own "+r.getName());
                    return false;
                }
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "You do not own "+r.getName());
                return false;
            }    
        }
        
        else if(currentLocation instanceof waterelec)
        {
            waterelec w = (waterelec) currentLocation;
                
            if(w.isBought())
            {
                if(w.getOwner().equals(this.Name))
                {
                    w.removeOwner();
                    this.OwnedCountries.remove(w) ; 
                    this.addMoney(w.getCost());
                    w.setBought(false);
                    JOptionPane.showMessageDialog(null, "You sold "+w.getName());
                    return true ; 
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "You do not own "+w.getName());
                    return false;
                }          
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "You do not own "+w.getName());
                return false;
            }
        } 
        
        else
        {
            JOptionPane.showMessageDialog(null, "You cannot sell this tile");
            return false ; 
        }
        
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
            if(Index == 0 && !cannotCollect)
            {
                this.Money += 200;
                cannotCollect = false;
            }
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
            if(Index == 0 && !cannotCollect)
            {
                this.Money += 200;
                cannotCollect = false;
            }      
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
                    if(this.getName().equals(name))
                        return;
                      
                    else if (ps.get(i).getName().equals(name))
                    {   
                        if(CanBuy(c.getRent()))
                        {   this.Money -= c.getRent();
                            ps.get(i).addMoney(c.getRent());
                            JOptionPane.showMessageDialog(null,"You paid rent of $"+c.getRent()+" to "+c.getOwner());
                        }
                        else 
                        
                            hasLost = true;
                           
                        return;
                    }
                    
                }
            }
                
        }
       
       else if(currentLocation instanceof waterelec)
       {
           waterelec w = (waterelec) currentLocation;
           
           if(w.isBought())
           {
               String name = w.getOwner();
               
                if(this.Name == name)
                    return;
               
                for(int i=0; i< ps.size();i++)
                {
                    if (ps.get(i).getName().equals(name))
                    {   
                        ArrayList <Location> l = ps.get(i).getOwnedCountries();
                        String tileName = w.getName();

                        for(int j=0; j<l.size();j++)
                        {
                            if(tileName.equals("Water Works"))
                            {
                                if(l.get(i).getName().equals("Electric Company"))
                                {
                                    if(CanBuy(10*d.getDiceRoll()))
                                    {  
                                        this.Money -= 10*d.getDiceRoll();
                                        ps.get(i).addMoney(10*d.getDiceRoll()); 
                                        JOptionPane.showMessageDialog(null,"You paid $"+10*d.getDiceRoll()+" to "+w.getOwner());
                                    }
                                    else
                                        hasLost = true;
                                }
                                else
                                {
                                    if(CanBuy(4*d.getDiceRoll()))
                                    {  
                                        this.Money -= 4*d.getDiceRoll();
                                        ps.get(i).addMoney(4*d.getDiceRoll());
                                        JOptionPane.showMessageDialog(null,"You paid $"+4*d.getDiceRoll()+" to "+w.getOwner());
                                    }
                                    else
                                        hasLost = true;
                                }
                                return;
                            }

                            else if (tileName.equals("Electric Company"))
                            {
                                if(l.get(i).getName().equals("Water Works") )
                                {
                                    if(CanBuy(10*d.getDiceRoll()))
                                    {  
                                        this.Money -= 10*d.getDiceRoll();
                                        ps.get(i).addMoney(10*d.getDiceRoll());
                                        JOptionPane.showMessageDialog(null,"You paid $"+10*d.getDiceRoll()+" to "+w.getOwner());
                                    }
                                    else
                                        hasLost = true;
                                }
                                else
                                {
                                    if(CanBuy(4*d.getDiceRoll()))
                                    { 
                                        this.Money -= 4*d.getDiceRoll();
                                        ps.get(i).addMoney(4*d.getDiceRoll());
                                        JOptionPane.showMessageDialog(null,"You paid $"+4*d.getDiceRoll()+" to "+w.getOwner());
                                    }
                                    else
                                    
                                        hasLost = true;
                                        
                                    
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
               
               if(this.getName().equals (name))
                    return;
               
               for(int i=0; i< ps.size();i++)
                {
                    if(ps.get(i).getName().equals(name))
                    {   
                        ArrayList <Location> l = ps.get(i).getOwnedCountries();
                        int rent = 25;
                        
                        for(int j=0; j<l.size();j++)
                        {
                            if(l.get(j).getName().equals(r.getName()))
                                continue;
                            
                            else if(l.get(j) instanceof RailRoad)
                                rent*=2;
                        }
                        
                        if(CanBuy(rent))
                        { 
                            this.Money -= rent;
                            ps.get(i).addMoney(rent);
                            JOptionPane.showMessageDialog(null,"You paid $"+rent+" to "+r.getOwner());
                            
                        }
                        
                        else
                            hasLost = true;
                        
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
            c.assignChance(this, moveTimer, DiceTimer, Dice, Game);
        }
    }

    public void checkCommunityChest(javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        if(currentLocation instanceof communityChest )
        {
           communityChest  cc = (communityChest) currentLocation;
           cc.assignCommunityChest(this, moveTimer, DiceTimer, Dice, Game);
        }
    }
    
    public void checkTaxes()
    {
        if(currentLocation.getName().equals("Luxury Tax"))
        {
            if(CanBuy(7500))
            {
                this.Money -= 7500;
                JOptionPane.showMessageDialog(null,"You paid $7500 luxury taxes","Luxury Tax",JOptionPane.PLAIN_MESSAGE);
            }
            
            //else
                //hasLost = true;
        }
        
        else if(currentLocation.getName().equals("Income Tax"))
        {
            this.Money -= 0.1*this.Money;
            JOptionPane.showMessageDialog(null,"You paid $"+0.1*this.Money+" income taxes","Income Tax",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void checkCommunity(javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        if(currentLocation instanceof communityChest)
        {
            communityChest c = (communityChest) currentLocation;
            c.assignCommunityChest(this, moveTimer, DiceTimer, Dice, Game);
        }
    }
    
    public void CheckJail(javax.swing.Timer moveTimer,Game Game)
    {
        if (this.currentLocation.getName().equals( "Go to Jail"))
        {
            JOptionPane.showMessageDialog(null, "You have been imprisoned" , "GO TO JAIL" , JOptionPane.PLAIN_MESSAGE);
            Game.setDiceRoll(20);
            moveTimer.start();
            isPrisoned = true;
        }
    }
    
    
    public boolean CanBuy (int c)
    {
        if ((this.Money - c) < 0)
            return false;
        else 
            return true;
    }
    
    public void Kick()
    {
        for(int i=0; i<OwnedCountries.size(); i++)
        {
            Country c = (Country) OwnedCountries.get(i);
            c.setOwner("None");
            c.setBought(false);
        }
    }
}