package monopoly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiceFrame extends JFrame
{
    private int numberOfPlayers;
    private String[] names;
    private int[] results;
    private int count = 0;
    private int DiceConst = 10;
    private Dice Dice = new Dice();
    
    private JButton Roll = new JButton("Roll");
    private JButton Play = new JButton("Play");
    
    private JLabel P1NameLbl;
    private JLabel P2NameLbl;
    private JLabel P3NameLbl;
    private JLabel P4NameLbl;
    
    private JTextField[] PNums;
    private JTextField P1Num;
    private JTextField P2Num;
    private JTextField P3Num;
    private JTextField P4Num;
    
    private javax.swing.Timer DiceTimer = new javax.swing.Timer(50,new DiceListener());
    
    public DiceFrame(int n, String[] names)
    {
        this.numberOfPlayers = n;
        this.names = names;
        results = new int[numberOfPlayers];
        PNums = new JTextField[numberOfPlayers];
        Container c = getContentPane();
        setContentPane(new JLabel(new ImageIcon("Resources/Background2.jpg")));
        setSize(1000,730);
        setTitle("Monopoly");
        setLocation(150,0);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(null);
            
        InitializePlayerComponents();
        
        add(Play);
        add(Dice);
        add(Roll);
        
        Play.setBounds(465,530,80,30);
        Roll.setBounds(465,220,80,30);
        Dice.setBounds(430,130,170,85);
        
        Play.setEnabled(false);
        Play.addActionListener(null);
        Roll.addActionListener(new RollButtonListener());
    }
    
    public void InitializePlayerComponents()
    {
        if(numberOfPlayers==2)
        {
            P1NameLbl = new JLabel(names[0]+" (Token 1)");
            P1NameLbl.setForeground(Color.red);
            P1NameLbl.setBounds(500,320,300,40);
            
            P2NameLbl = new JLabel(names[1]+" (Token 2)");
            P2NameLbl.setForeground(Color.red);
            P2NameLbl.setBounds(500,360,300,40);
            
            PNums[0] = new JTextField();
            PNums[0].setEditable(false);
            PNums[0].setBounds(430,320,30,30);
            
            PNums[1] = new JTextField();
            PNums[1].setEditable(false);
            PNums[1].setBounds(430,360,30,30);
            
            add(P1NameLbl);
            add(P2NameLbl);
            add(PNums[0]);
            add(PNums[1]);
        }
        
        else if(numberOfPlayers==3)
        {
            P1NameLbl = new JLabel(names[0]+" (Token 1)");
            P1NameLbl.setForeground(Color.red);
            P1NameLbl.setBounds(500,320,300,40);
            
            P2NameLbl = new JLabel(names[1]+" (Token 2)");
            P2NameLbl.setForeground(Color.red);
            P2NameLbl.setBounds(500,360,300,40);
            
            P3NameLbl = new JLabel(names[2]+" (Token 3)");
            P3NameLbl.setForeground(Color.red);
            P3NameLbl.setBounds(500,400,300,40);
            
            PNums[0] = new JTextField();
            PNums[0].setEditable(false);
            PNums[0].setBounds(430,320,30,30);
            
            PNums[1] = new JTextField();
            PNums[1].setEditable(false);
            PNums[1].setBounds(430,360,30,30);
            
            PNums[2] = new JTextField();
            PNums[2].setEditable(false);
            PNums[2].setBounds(430,400,30,30);
            
            add(P1NameLbl);
            add(P2NameLbl);
            add(P3NameLbl);
            add(PNums[0]);
            add(PNums[1]);
            add(PNums[2]);
        }
        
        else if(numberOfPlayers==4)
        {
            P1NameLbl = new JLabel(names[0]+" (Token 1)");
            P1NameLbl.setForeground(Color.red);
            P1NameLbl.setBounds(500,320,300,40);
            
            P2NameLbl = new JLabel(names[1]+" (Token 2)");
            P2NameLbl.setForeground(Color.red);
            P2NameLbl.setBounds(500,360,300,40);
            
            P3NameLbl = new JLabel(names[2]+" (Token 3)");
            P3NameLbl.setForeground(Color.red);
            P3NameLbl.setBounds(500,400,300,40);
            
            P4NameLbl = new JLabel(names[3]+" (Token 4)");
            P4NameLbl.setForeground(Color.red);
            P4NameLbl.setBounds(500,440,300,40);
            
            PNums[0] = new JTextField();
            PNums[0].setEditable(false);
            PNums[0].setBounds(430,320,30,30);
            
            PNums[1] = new JTextField();
            PNums[1].setEditable(false);
            PNums[1].setBounds(430,360,30,30);
            
            PNums[2] = new JTextField();
            PNums[2].setEditable(false);
            PNums[2].setBounds(430,400,30,30);
            
            PNums[3] = new JTextField();
            PNums[3].setEditable(false);
            PNums[3].setBounds(430,440,30,30);
            
            add(P1NameLbl);
            add(P2NameLbl);
            add(P3NameLbl);
            add(P4NameLbl);
            add(PNums[0]);
            add(PNums[1]);
            add(PNums[2]);
            add(PNums[3]);
        }
    }
    
//    public boolean checkSameNumbers()
//    {
//        
//    }
    
    class RollButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DiceTimer.start();         
            Roll.setEnabled(false);    
        }
    }
    
    class DiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(Dice.getCount() < DiceConst)
            {
                Dice.Roll();
                repaint();
            }
            
            else
            {               
                count++;
                if(count == numberOfPlayers)
                    Roll.setEnabled(false);
                
                else
                    Roll.setEnabled(true);
                
                results[count-1] = Dice.getDiceRoll();
                PNums[count-1].setText(results[count-1]+"");
                Dice.setCount(0);
                DiceTimer.stop();
            }
        }   
    }
}
