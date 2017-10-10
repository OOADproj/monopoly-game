
import monopoly.Location;
import java.util.Random;
import javax.swing.JOptionPane;
import monopoly.Dice;
import monopoly.Game;
import monopoly.Player;
 
public class communityChest extends Location
{
    String[] cccard = { 
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
    };
    
    public communityChest (String s) 
    {
        super(s);
    }
    public void assignCommunityChest (Player p,javax.swing.Timer moveTimer,javax.swing.Timer DiceTimer, Dice Dice , Game Game)
    {
    Random r = new Random();
    int index = 0;
        if(index ==0 )
        {
            JOptionPane.showMessageDialog(null,"Community Chest"+cccard[0]);
            Game.setDiceRoll(40-p.getIndex());
            moveTimer.start();
        }
        if(index==1 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[1]);
             p.addMoney(200);
        }
        if(index==2 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[2]);
             p.deductMoney(50);
        }
        if(index==3 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[3]);
             p.addMoney(50);
        }
        if(index==4 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[4]);
             //TODO MARY
        }
        if(index==5 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[5]);
             //TODO MARY
        }
        if(index==6 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[6]);
             p.addMoney(50*Game.getPlayers().size());
             for (int i = 0; i < Game.getPlayers().size(); i++) {
                Game.getPlayers().get(i).deductMoney(50);    
        }
        }
        if(index==7 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[7]);
             p.addMoney(100);
        }
        if(index==8 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[8]);
             p.addMoney(20);
        }
        if(index==9 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[9]);
             p.addMoney(10);
        }
        if(index==10 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[10]);
             p.addMoney(100);
        }
        if(index==11 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[11]);
             p.deductMoney(100);
        }
        if(index==12 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[12]);
            Game.setDiceRoll(39-p.getIndex());
            moveTimer.start();
        }
        if(index==13 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[13]);
            p.deductMoney(150);
        }
        if(index==14 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[14]);
            p.addMoney(25);
        }
              if(index==15 )
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[15]);
            p.addMoney(10);
        }
        if(index==16)
        {
             JOptionPane.showMessageDialog(null,"Community Chest"+cccard[16]);
            p.addMoney(100);
        }
    }
}
        
     
    
 
    
 

