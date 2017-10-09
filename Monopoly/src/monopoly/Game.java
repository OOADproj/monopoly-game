package monopoly;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Game extends JFrame 
{
    private Container c;
    private JTextArea Info = new JTextArea();
    private JTextArea P1Owned = new JTextArea();
    private JTextArea P2Owned = new JTextArea();
    private JTextArea P3Owned = new JTextArea();
    private JTextArea P4Owned = new JTextArea();
    
    private Board Board; 
    private JPanel Data = new JPanel(); 
    private JButton Buy = new JButton("Buy"); 
    private JButton Roll = new JButton("Roll"); 
    private JButton InfoButton = new JButton("View Tile Information");
    private JButton EndTurn = new JButton("End Turn");
    
    private JLabel InfoLbl = new JLabel("Tile Information");
    private JLabel P1Lbl;
    private JLabel P2Lbl;
    private JLabel P3Lbl;
    private JLabel P4Lbl;
     
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private Player currPlayer;
    private int current = 0;
    private int numberOfPlayers;
    
    private ArrayList<Player> Players = new ArrayList();
    private ArrayList<Location> Countries = new ArrayList();
    
    private Dice Dice = new Dice();
    int DiceRoll;
    int DiceConst = 10;
    
    private javax.swing.Timer motionTimer = new javax.swing.Timer(400,new motionListener());
    private javax.swing.Timer DiceTimer = new javax.swing.Timer(300,new DiceListener());
    
    public Game(int n,String[] names)
    {
        numberOfPlayers = n;
        initializePlayers(n,names);
        initializeCountries(); 
        initializeComponents(); 
        startGame();
    } 
    
    public void initializeComponents() 
    {
        TitledBorder InfoTitle = BorderFactory.createTitledBorder("Tile Info");
        c = getContentPane(); 
        setSize(1000,730);
        setTitle("Monopoly");
        setLocation(150,0);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Data.setPreferredSize(new Dimension(293,700));
        Data.setBackground(new Color(85,107,47));
        
        Buy.setPreferredSize(new Dimension(80,40));
        Buy.setBounds(270,295,80,40);
        Buy.setEnabled(false);
        InfoButton.setBounds(270,250,180,40);
        Roll.setBounds(370,295,80,40);
        Info.setBounds(270,390,180,200);
        EndTurn.setBounds(300,340,120,40);
        EndTurn.setEnabled(false);
        Info.setEditable(false);
        Info.setBorder(InfoTitle);
        
        Board = new Board(Players,numberOfPlayers);
        Board.repaint();
        Board.add(Buy);
        Board.add(Roll);
        Board.add(InfoButton);
        Board.add(EndTurn);
        Board.add(Info);
        Board.add(Dice);
        
        c.add(Board);
        c.add(Data , BorderLayout.WEST) ; 

        InfoButton.addActionListener(new InfoButtonListener());  
        Roll.addActionListener(new RollButtonListener());
        Buy.addActionListener(new BuyButtonListener());
        EndTurn.addActionListener(new EndButtonListener());
        setVisible(true); 
    }
    
    void startGame()
    {
        //motionTimer.start();
    }
    
    void initializePlayers(int n, String[] names)
    {
        if(n == 2)
        {
            p1 = new Player(names[0],"p1.png",640,640);
            p2 = new Player(names[1],"p2.png",667,640);
            
            P1Lbl = new JLabel(p1.getName()+" : $"+p1.getMoney());
            P2Lbl = new JLabel(p2.getName()+" : $"+p2.getMoney());
            
            TitledBorder P1Title = BorderFactory.createTitledBorder(p1.getName()+" Properties");
            TitledBorder P2Title = BorderFactory.createTitledBorder(p2.getName()+" Properties");
            
            Data.add(P1Lbl); 
            Data.add(P1Owned);
            Data.add(P2Lbl); 
            Data.add(P2Owned);
            
            P1Lbl.setPreferredSize(new Dimension(293,15));
            P1Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P1Lbl.setForeground(Color.white);
            
            P2Lbl.setPreferredSize(new Dimension(293,15));
            P2Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P2Lbl.setForeground(Color.white);
            
            P1Owned.setEditable(false);
            P1Owned.setBorder(P1Title);
            P1Owned.setPreferredSize(new Dimension(293,300));
            P1Owned.setFont(new Font("Arial",Font.PLAIN,12));
        
            P2Owned.setEditable(false);
            P2Owned.setBorder(P2Title);
            P2Owned.setPreferredSize(new Dimension(293,300));
            P2Owned.setFont(new Font("Arial",Font.PLAIN,12));
            
            Players.add(p1);
            Players.add(p2);
        }
        
        else if(n == 3)
        {
            p1 = new Player(names[0],"p1.png",640,640);
            p2 = new Player(names[1],"p2.png",667,640);
            p3 = new Player(names[2],"p3.png",640,670);
            
            P1Lbl = new JLabel(p1.getName()+" : $"+p1.getMoney());
            P2Lbl = new JLabel(p2.getName()+" : $"+p2.getMoney());
            P3Lbl = new JLabel(p3.getName()+" : $"+p3.getMoney());
            
            TitledBorder P1Title = BorderFactory.createTitledBorder(p1.getName()+" Properties");
            TitledBorder P2Title = BorderFactory.createTitledBorder(p2.getName()+" Properties");
            TitledBorder P3Title = BorderFactory.createTitledBorder(p3.getName()+" Properties");
            
            Data.add(P1Lbl); 
            Data.add(P1Owned);
            Data.add(P2Lbl); 
            Data.add(P2Owned);
            Data.add(P3Lbl); 
            Data.add(P3Owned);
            
            P1Lbl.setPreferredSize(new Dimension(293,15));
            P1Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P1Lbl.setForeground(Color.white);
            
            P2Lbl.setPreferredSize(new Dimension(293,15));
            P2Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P2Lbl.setForeground(Color.white);
            
            P3Lbl.setPreferredSize(new Dimension(293,15));
            P3Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P3Lbl.setForeground(Color.white);
            
            P1Owned.setEditable(false);
            P1Owned.setBorder(P1Title);
            P1Owned.setPreferredSize(new Dimension(293,200));
            P1Owned.setFont(new Font("Arial",Font.PLAIN,12));
        
            P2Owned.setEditable(false);
            P2Owned.setBorder(P2Title);
            P2Owned.setPreferredSize(new Dimension(293,200));
            P2Owned.setFont(new Font("Arial",Font.PLAIN,12));
            
            P3Owned.setEditable(false);
            P3Owned.setBorder(P3Title);
            P3Owned.setPreferredSize(new Dimension(293,200));
            P3Owned.setFont(new Font("Arial",Font.PLAIN,12));
            
            Players.add(p1);
            Players.add(p2);
            Players.add(p3);
        }
        
        else if(n == 4)
        {
            p1 = new Player(names[0],"p1.png",640,640);
            p2 = new Player(names[1],"p2.png",667,640);
            p3 = new Player(names[2],"p3.png",640,670);
            p4 = new Player(names[3],"p4.png",667,670);
            
            P1Lbl = new JLabel(p1.getName()+" : $"+p1.getMoney());
            P2Lbl = new JLabel(p2.getName()+" : $"+p2.getMoney());
            P3Lbl = new JLabel(p3.getName()+" : $"+p3.getMoney());
            P4Lbl = new JLabel(p4.getName()+" : $"+p4.getMoney());
            
            TitledBorder P1Title = BorderFactory.createTitledBorder(p1.getName()+" Properties");
            TitledBorder P2Title = BorderFactory.createTitledBorder(p2.getName()+" Properties");
            TitledBorder P3Title = BorderFactory.createTitledBorder(p3.getName()+" Properties");
            TitledBorder P4Title = BorderFactory.createTitledBorder(p4.getName()+" Properites");
            
            Data.add(P1Lbl); 
            Data.add(P1Owned);
            Data.add(P2Lbl); 
            Data.add(P2Owned);
            Data.add(P3Lbl); 
            Data.add(P3Owned);
            Data.add(P4Lbl); 
            Data.add(P4Owned);
        
            P1Lbl.setPreferredSize(new Dimension(293,15));
            P1Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P1Lbl.setForeground(Color.white);
           
            P2Lbl.setPreferredSize(new Dimension(293,15));
            P2Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P2Lbl.setForeground(Color.white);
            
            P3Lbl.setPreferredSize(new Dimension(293,15));
            P3Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P3Lbl.setForeground(Color.white);
            
            P4Lbl.setPreferredSize(new Dimension(293,15));
            P4Lbl.setFont((new Font("Arial",Font.BOLD,15)));
            P4Lbl.setForeground(Color.white);
            
            P1Owned.setEditable(false);
            P1Owned.setBorder(P1Title);
            P1Owned.setPreferredSize(new Dimension(293,150));
            P1Owned.setFont(new Font("Arial",Font.PLAIN,12));
        
            P2Owned.setEditable(false);
            P2Owned.setBorder(P2Title);
            P2Owned.setPreferredSize(new Dimension(293,150));
            P2Owned.setFont(new Font("Arial",Font.PLAIN,12));
            
            P3Owned.setEditable(false);
            P3Owned.setBorder(P3Title);
            P3Owned.setPreferredSize(new Dimension(293,150));
            P3Owned.setFont(new Font("Arial",Font.PLAIN,12));
            
            P4Owned.setEditable(false);
            P4Owned.setBorder(P4Title);
            P4Owned.setPreferredSize(new Dimension(293,150));
            P4Owned.setFont(new Font("Arial",Font.PLAIN,12));
            
            Players.add(p1);
            Players.add(p2);
            Players.add(p3);
            Players.add(p4);
        }
        currPlayer = Players.get(current);
    }
    
    void initializeCountries()
    {
        Countries.add(new Location("GO"));
        
        Countries.add(new Country("Times Square",60,2));
        Countries.add(new Chance("Community Chest"));
        Countries.add(new Country("Baltic Avenue",60,4));
        Countries.add(new Location ("Income Tax"));
        Countries.add(new RailRoad("Reading Railroad"));
        Countries.add(new Country("Oriental Avenue",100,6));
        Countries.add(new Chance("Chance"));
        Countries.add(new Country("Vermont Avenue",100,6));
        Countries.add(new Country("Ellis Island",120,8));
        
        Countries.add(new Jail());
        
        Countries.add(new Country("East Village",140,10));
        Countries.add(new waterelec("Electric Company"));
        Countries.add(new Country("States Avenue",140,10));
        Countries.add(new Country("Virginia Avenue",160,12));
        Countries.add(new RailRoad("Pennsylvania Railroad"));
        Countries.add(new Country("St James Place",160,14));
        Countries.add(new Chance("Community Chest"));
        Countries.add(new Country("Tennesee Avenue",180,14));
        Countries.add(new Country("New York Avenue",200,16));
        
        Countries.add(new Location("Free Parking"));
        
        Countries.add(new Country("Kentucky Avenue",220,18));
        Countries.add(new Chance("Chance"));
        Countries.add(new Country("Indiana Avenue",220,18));
        Countries.add(new Country("Illinois Avenue",240,20));
        Countries.add(new RailRoad("B&O Railroad"));
        Countries.add(new Country("Atlantic Avenue",260,22));
        Countries.add(new Country("Ventor Avenue",260,22));
        Countries.add(new waterelec("Water Works"));        
        Countries.add(new Country("Marvin Gardens",280,24));
        
        Countries.add(new Location ("Go to Jail"));
        
        Countries.add(new Country("Pacific Avenue",300,26));      
        Countries.add(new Country("Central Park",300,26));
        Countries.add(new Chance("Community Chest"));
        Countries.add(new Country("Penn Avenue",320,28));
        Countries.add(new RailRoad("Short Line"));
        Countries.add(new Chance("Chance"));
        Countries.add(new Country("Park Place",350,35));
        Countries.add(new Location ("Luxury Tax"));
        Countries.add(new Country("Wall Street",400,50));
    }
    
    void startRound()
    {
        //int n = Dice.Roll();
        
        for(int i = 0; i < Countries.size(); i++)
        {
            //Country cc = (Country) Countries.get(i);
            //(cc.getName().equals(currPlayer.getCurrentLocation().getName()))
                ;
        }    
    }
 
    void updateLabels()
    {
        P1Lbl.setText(p1.getName()+" : $"+p1.getMoney());
        P2Lbl.setText(p2.getName()+" : $"+p2.getMoney());
        P3Lbl.setText(p3.getName()+" : $"+p3.getMoney());
        P4Lbl.setText(p4.getName()+" : $"+p4.getMoney());
    }
    
    class InfoButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Location l = Countries.get(currPlayer.getIndex());
            Info.setText(l.viewInformation());
            Info.setFont(new Font("Arial",Font.BOLD,14));
        }
    }
    
    class RollButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DiceTimer.start();         
            Roll.setEnabled(false);    
            EndTurn.setEnabled(false);
        }
    }
    
    class EndButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            current = (current+1)%numberOfPlayers;
            currPlayer = Players.get(current);
            Roll.setEnabled(true);
            Buy.setEnabled(false);
        }
    }
    
    class BuyButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean Success = currPlayer.Buy();
            updateLabels();
            if(currPlayer.getName().equals(p1.getName()) && Success)
                P1Owned.setText(p1.getCurrentLocation().getName()+"\n");

            else if(currPlayer.getName().equals(p2.getName()) && Success)
                P2Owned.setText(p2.getCurrentLocation().getName()+"\n");

            else if(!(p3 == null) && currPlayer.getName().equals(p3.getName()) && Success)
                P3Owned.setText(p3.getCurrentLocation().getName()+"\n");

            else if(!(p4 == null) && currPlayer.getName().equals(p4.getName()) && Success)
                P4Owned.setText(p4.getCurrentLocation().getName()+"\n");
        }
    }
    
    class motionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           if(DiceRoll > 0)
           {
                currPlayer.Move();
                DiceRoll--;
                Board.repaint();
           }
           
           else
           {
               Location l = Countries.get(currPlayer.getIndex());
               currPlayer.setCurr(l);
               motionTimer.stop();
               Buy.setEnabled(true);
               EndTurn.setEnabled(true);
               currPlayer.checkRent(Players);
           }
        }
    }
    
    class DiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(Dice.getCount() < DiceConst)
            {
                Dice.Roll();
                Board.repaint();
            }
            
            else
            {
                DiceRoll = Dice.getDiceRoll();
                System.out.println(DiceRoll);
                Dice.setCount(0);
                motionTimer.start();
                DiceTimer.stop();
            }
        }   
    }
}
 

