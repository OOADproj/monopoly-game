
package monopoly;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Timer;


/**
 *
 * @author Mohammed
 */
public class Board extends JPanel {
            

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
         ImageIcon Background = new ImageIcon("back.jpg");
        g.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this); 
         ImageIcon car1 = new ImageIcon("car1.png");
        g.drawImage(car1.getImage(), 590, 400, 60, 60, this); 
         ImageIcon car2 = new ImageIcon("car2.png");
        g.drawImage(car2.getImage(), 590,490, 60, 60, this); 
         ImageIcon car3= new ImageIcon("car3.png");
        g.drawImage(car3.getImage(), 590, 440, 60, 60, this); 
//       ImageIcon die = new ImageIcon(dice[index]);
//       
//        g.drawImage(die.getImage(), 100, 100, 100, 100, this); 
        
       
        
    }    
    
    
    
    
}
