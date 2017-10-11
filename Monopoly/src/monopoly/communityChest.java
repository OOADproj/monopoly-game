<<<<<<< HEAD
=======
package monopoly;
>>>>>>> cf6b64413c415fc83fd6fa06c69fbc3d34dcc587

import monopoly.Location;
import java.util.Random;
import javax.swing.JOptionPane;
import monopoly.Dice;
import monopoly.Game;
import monopoly.Player;
////////////////////////////////////////////////////////////// 
public class communityChest extends Location
{
<<<<<<< HEAD
    String[] cccard =new String[]
    { 
        "Advance to Go (Collect $200)",
        "Bank error in your favor—Collect $200",
        "Doctor's fee—Pay $50",
        "From sale of stock you get $50",
        "Get Out of Jail Free",
        "Go to Jail–Go directly to jail–Do not pass Go–Do not collect $200",
        "Grand Opera Night—Collect $50 from every player for opening night seats",
        "Holiday Fund matures—Receive $100",
        "Income tax refund–Collect $20",
        "It is your birthday—Collect $10",
        "life insurance matures–Collect $100",
        "Pay hospital fees of $100",
        "Pay school fees of $150",
        "Receive $25 consultancy fee",
        "You have won second prize in a beauty contest–Collect $10",
        "You inherit $100"
=======
<<<<<<< HEAD
    String[] cccard = { 
=======
    String[] cccard =new String[] { 
>>>>>>> cf6b64413c415fc83fd6fa06c69fbc3d34dcc587
"Advance to Go (Collect $200)",
"Bank error in your favor—Collect $200",
"Doctor's fee—Pay $50",
"From sale of stock you get $50",
"Get Out of Jail Free",
"Go to Jail–Go directly to jail–Do not pass Go–Do not collect $200",
"Grand Opera Night—Collect $50 from every player for opening night seats",
"Holiday Fund matures—Receive $100",
"Income tax refund–Collect $20",
"It is your birthday—Collect $10",
"life insurance matures–Collect $100",
"Pay hospital fees of $100",
"Pay school fees of $150",
"Receive $25 consultancy fee",
"You have won second prize in a beauty contest–Collect $10",
"You inherit $100"
>>>>>>> 73498558b7a08f9a6daf49a233ac1b29aead00c4
    };
    
    public communityChest (String s) 
    {
        super(s);
    }
    public void assignCommunityChest (Player p,javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
        Random r = new Random();
        int index = r.nextInt(17);
        if(index ==0 )
        {
            JOptionPane.showMessageDialog(null,cccard[0],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            Game.setDiceRoll(40-p.getIndex());
            moveTimer.start();
        }
        
        if(index==1 )
        {
            JOptionPane.showMessageDialog(null,cccard[1],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(200);
        }
        
        if(index==2 )
        {
            JOptionPane.showMessageDialog(null,cccard[2],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.deductMoney(50);
        }
        
        if(index==3 )
        {
            JOptionPane.showMessageDialog(null,cccard[3],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(50);
        }
        
        if(index==4 )
        {
            JOptionPane.showMessageDialog(null,cccard[4],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.setFreePass(true);
        }
        
        if(index==5 )
        {
            JOptionPane.showMessageDialog(null,cccard[5],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.setPrisoned(true);
            p.CannotCollect();
            if(p.getIndex() == 2)
                Game.setDiceRoll(8);
            
            if(p.getIndex() == 17)
                Game.setDiceRoll(33);
            
            if(p.getIndex() == 33)
                Game.setDiceRoll(17);
            
            moveTimer.start();
        }
        
        if(index==6 )
        {
            JOptionPane.showMessageDialog(null,cccard[6],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(50*Game.getPlayers().size());
            for (int i = 0; i < Game.getPlayers().size(); i++)
                Game.getPlayers().get(i).deductMoney(50);    
        }
        
        if(index==7 )
        {
            JOptionPane.showMessageDialog(null,cccard[7],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(100);
        }
        
        if(index==8 )
        {
            JOptionPane.showMessageDialog(null,cccard[8],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(20);
        }
        
        if(index==9 )
        {
            JOptionPane.showMessageDialog(null,cccard[9],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(10);
        }
        
        if(index==10 )
        {
            JOptionPane.showMessageDialog(null,cccard[10],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(100);
        }
        
        if(index==11 )
        {
            JOptionPane.showMessageDialog(null,cccard[11],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.deductMoney(100);
        }
        
        if(index==12 )
        {
            JOptionPane.showMessageDialog(null,cccard[12],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            Game.setDiceRoll(39-p.getIndex());
            moveTimer.start();
        }
        
        if(index==13 )
        {
            JOptionPane.showMessageDialog(null,cccard[13],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.deductMoney(150);
        }
        
        if(index==14 )
        {
            JOptionPane.showMessageDialog(null,cccard[14],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(25);
        }
        
        if(index==15 )
        {
            JOptionPane.showMessageDialog(null,cccard[15],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(10);
        }
        
        if(index==16)
        {
            JOptionPane.showMessageDialog(null,cccard[16],"Coummnity Chest",JOptionPane.PLAIN_MESSAGE);
            p.addMoney(100);
        }
    }
}
        
     
    
 
    
 

