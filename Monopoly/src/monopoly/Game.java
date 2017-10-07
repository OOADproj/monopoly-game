package monopoly;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Mohammed
 */
public class Game extends JFrame {
     Container c;
    private JPanel Data = new JPanel() ; 
    private JButton Buy = new JButton("Buy") ; 
    private JButton Roll = new JButton("Roll") ; 
    private JLabel player1 = new JLabel("player 1 : 1500") ;
    private JLabel player2 = new JLabel("player 2 : 1500") ;
    private JLabel player3 = new JLabel("player 3 : 1500") ;
    private JLabel player4 = new JLabel("player 4 : 1500") ;
    private JLabel lbldie1 = new JLabel() ;  
    private JLabel lbldie2 = new JLabel() ;  
    private Dice Dice = new Dice() ; 
    Timer timer = new Timer();

//    String[] dice = new String[]{"dice1.png","dice2.png","dice3.png","dice4.png","dice5.png","dice6.png" }; 
//    int index1 ;
//    int index2 ;

//    private ImageIcon die1 = die1 = new ImageIcon(dice[0]) ;  ;
//    Image redie1 =  die1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
//  
//    private ImageIcon die2 = new ImageIcon(dice[0]) ;
// 
//    Image redie2 =die2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
//  
    private Board backgroungpic = new Board() ; 


    

    public Game() { init(); } 
    
//    public void setDie1(ImageIcon x )
//    {
//        die1 = x ; 
//    }
//    public void setDie2(ImageIcon x )
//    {
//        die2 = x ; 
//    }
    
    
    
    
    public void init() 
    {
        c = getContentPane() ; 
        
       
        Data.add(Buy) ; 
        Data.add(Roll) ; 
        Data.add(player1) ;
        Data.add(player2) ;
        Data.add(player3) ;
        Data.add(player4) ;
        backgroungpic.setLayout(null);

        Buy.setPreferredSize(new Dimension(80,40));
        
        Roll.setPreferredSize(new Dimension(80,40));
        
        c.add(Data , BorderLayout.WEST) ; 
        Data.setPreferredSize(new Dimension(150,200));
        
        
       
        
         Roll.addActionListener(new ActionListener() 
         {

            @Override
            public void actionPerformed(ActionEvent e) 
            { 
           Dice.Roll();
            }
          }); 
         
           
//     redie1 =  die1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
//  
//     die2 = new ImageIcon(dice[index2]) ;
// 
//     redie2 =die2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT) ;
//
//        lbldie1.setIcon(new ImageIcon(redie1));
//                lbldie2.setIcon(new ImageIcon(redie2));

//        lbldie1.setBounds(500, 130, 80, 80);
//                lbldie2.setBounds(590, 130, 80, 80);
//
//        backgroungpic.add(lbldie1);
//                backgroungpic.add(lbldie2);


        
        
               
                
       
                
               Dice.setBounds(590, 130, 170, 80);
        
       

       

 c.add(Dice) ;
        c.add(backgroungpic) ;
       
        setSize(1300,1000);
        setTitle("Monopoly");
        setLocation(20,20);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
        
    }
    
    
    
    
    class Roll extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            
        }
        
        
    }
    
    
    
    
}
 