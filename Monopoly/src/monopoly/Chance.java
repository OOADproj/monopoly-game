package monopoly;

import java.util.Random;
import javax.swing.JOptionPane;

public class Chance extends Location
{
     String[] card = new String[]{
        "Advance to Go (Collect $200)" , 
       " Advance to Illinois Ave—If you pass Go, collect $200",
"Advance to East Village – If you pass Go, collect $200",
"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.",
"Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.",
"Bank pays you dividend of $50",
"Get Out of Jail Free",
"Go Back 3 Spaces",
"Go to Jail–Go directly to Jail–Do not pass Go, do not collect $200",
"Make general repairs on all your property–For each house pay $25–For each hotel $100",
"Pay poor tax of $15",
"Take a trip to Reading Railroad–If you pass Go, collect $200",
"Take a walk on Wall Street–Advance token to Wall Street",
"You have been elected Chairman of the Board–Pay each player $50",
"Your building and loan matures—Collect $150",
"You have won a crossword competition—Collect $100"
   
    };
     
    public Chance(String s) 
    {
        super(s);
    }
    
    public void assChance(Player p,javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        Random r = new Random();
       //int index =  r.nextInt(card.length);
       int index = 0;
        if(index==0 )
        {
        JOptionPane.showMessageDialog(null,"your chance is "+card[0]);

            Game.setDiceRoll(40-p.getIndex());
            moveTimer.start();
            
            
        }
        if(index==1 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[1]);
        }
        if(index==2 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[2]);
        }
        if(index==3 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[3]);
        }
        if(index==4 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[4]);
        }
        if(index==5 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[5]);
            p.addMoney(50);
        }
        if(index==6 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[6]);
        }
        if(index==7 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[7]);
        }
        if(index==8 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[8]);
        }
        if(index==9 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[9]);
        }
        if(index==10 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[10]);
            p.deductMoney(15);
        }
        if(index==11 )
        {
             JOptionPane.showMessageDialog(null,"your chance is"+card[11]);
        }
        if(index==12 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[12]);
            Game.setDiceRoll(39-p.getIndex());
            moveTimer.start();
        }
        if(index==13 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[13]);
            p.deductMoney(50*Game.getPlayers().size());
            for (int i = 0; i < Game.getPlayers().size(); i++) {
                Game.getPlayers().get(i).addMoney(50);
            }
            //lesa ma7dsh 5ad flosoo
        }
        if(index==14 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[14]);
            p.addMoney(150*Game.getPlayers().size());
        }
        if(index==15 )
        {
             JOptionPane.showMessageDialog(null,"your chance is "+card[15]);
            p.addMoney(100);
        }
        
    }
    
}
