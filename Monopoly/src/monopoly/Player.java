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
                        JOptionPane.showMessageDialog(null,"You already own this property.");
                        return false;
                    }
                }
                
                JOptionPane.showMessageDialog(null,"RailRoad is already owned by "+r.getOwner());
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
            JOptionPane.showMessageDialog(null,"This tile cannot be bought");
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
            if(Index == 0 && !cannotCollect)
            {
                this.Money += 200;
                cannotCollect = false;
            }
        }
        /////////
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
                        this.Money -= c.getRent();
                        ps.get(i).addMoney(c.getRent());
                        JOptionPane.showMessageDialog(null,"You paid rent of $"+c.getRent()+" to "+c.getOwner());
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
                                    this.Money -= 10*d.getDiceRoll();
                                    ps.get(i).addMoney(10*d.getDiceRoll()); 
                                    JOptionPane.showMessageDialog(null,"You paid $"+10*d.getDiceRoll()+" to "+l.get(i).getName());
                                }
                                else
                                {
                                    this.Money -= 4*d.getDiceRoll();
                                    ps.get(i).addMoney(4*d.getDiceRoll());
                                    JOptionPane.showMessageDialog(null,"You paid $"+4*d.getDiceRoll()+" to "+l.get(i).getName());
                                }
                                return;
                            }

                            else if (tileName.equals("Electric Company"))
                            {
                                if(l.get(i).getName().equals("Water Works") )
                                {
                                    this.Money -= 10*d.getDiceRoll();
                                    ps.get(i).addMoney(10*d.getDiceRoll());
                                     JOptionPane.showMessageDialog(null,"You paid $"+10*d.getDiceRoll()+" to "+w.getName());
                                }
                                else
                                {
                                    this.Money -= 4*d.getDiceRoll();
                                    ps.get(i).addMoney(4*d.getDiceRoll());
                                    JOptionPane.showMessageDialog(null,"You paid $"+4*d.getDiceRoll()+" to "+w.getName());
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
                        int rent = 0;
                        
                        for(int j=0; j<l.size();j++)
                            if(l.get(i) instanceof RailRoad)
                                rent+=25;

                        this.Money -= rent;
                        ps.get(i).addMoney(rent);
                        JOptionPane.showMessageDialog(null,"You paid $"+rent+" to "+r.getName());
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
<<<<<<< HEAD
    public void checkCommunityChest(javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        if(currentLocation instanceof communityChest )
        {
           communityChest  cc = (Chance) currentLocation;
           cc.assignCommunityChest(this, moveTimer, DiceTimer, Dice, Game);
        }
=======
    
    public void checkTaxes()
    {
        if(currentLocation.getName().equals("Luxury Tax"))
        {
            this.Money -= 7500;
            JOptionPane.showMessageDialog(null,"You paid $7500 luxury taxes","Luxury Tax",JOptionPane.PLAIN_MESSAGE);
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
        
        else
            isPrisoned = false;
    }
    
    public boolean hasLost()
    {
        if(this.getMoney()<=0)
            return true;
        else 
            return false;
<<<<<<< HEAD
    }   
=======
>>>>>>> cf6b64413c415fc83fd6fa06c69fbc3d34dcc587
    }
   
    public void checkCommunity(javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        if(currentLocation instanceof communityChest)
        {
            communityChest c = (communityChest) currentLocation;
            c.assignCommunityChest(this, moveTimer, DiceTimer, Dice, Game);
        }
    }
>>>>>>> 73498558b7a08f9a6daf49a233ac1b29aead00c4
}