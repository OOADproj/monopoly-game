
package monopoly;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Dice extends JPanel {
    String[] dice = new String[]{"dice1.png","dice2.png","dice3.png","dice4.png","dice5.png","dice6.png" }; 
   protected int index1 ;
   protected int  index2 ;
   private JLabel lbldie1 = new JLabel() ;  
   private JLabel lbldie2 = new JLabel() ; 
   private ImageIcon die1 = die1 = new ImageIcon(dice[index1]) ;  ;
   Image redie1 =  die1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
   private ImageIcon die2 = new ImageIcon(dice[3]) ;
   Image redie2 =die2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
   int count = 0 ; 
   
   public  Dice() { init() ; }
   
   public void init() {
   
   lbldie1.setIcon(new ImageIcon(redie1));
   lbldie2.setIcon(new ImageIcon(redie2));
   this.setLayout(null);

   lbldie1.setBounds(0, 0, 80, 80);
   lbldie2.setBounds(90, 0, 80, 80);

   this.add(lbldie1);
   this.add(lbldie2);
   }
                
    public int Roll()
    {
        
        
 
        
        Timer timer = new Timer(500,new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
        index1 = (int) (Math.random() * (dice.length - 1));
        index2 =  (int) (Math.random() * (dice.length - 1)) ;
        ImageIcon die1 = die1 = new ImageIcon(dice[index1]) ;  ;
        Image redie1 =  die1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
        ImageIcon die2 = new ImageIcon(dice[index2]) ;
        Image redie2 =die2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
        Image[] redie = new Image[]{redie1,redie2 }; 
        lbldie1.setIcon(new ImageIcon(redie1));
       lbldie2.setIcon(new ImageIcon(redie2));      
           count ++ ; 
       }
   }) ;  
        timer.start();
if(count== 10)
{
    timer.stop();
}
    
    this.repaint();
    return index1+index2 ; 
    }
}
