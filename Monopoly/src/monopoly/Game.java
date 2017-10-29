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
    private JTextArea InfoLog = new JTextArea();
    
    private Board Board; 
    private JPanel Data = new JPanel(); 
    private JButton Buy = new JButton("Buy"); 
    private JButton Sell = new JButton("Sell"); 
    private JButton Roll = new JButton("Roll"); 
    private JButton InfoButton = new JButton("View Tile Information");
    private JButton EndTurn = new JButton("End Turn");
    private JButton BuildHouse = new JButton("Build House");
    private JLabel InfoLbl = new JLabel("Tile Information");
    private JLabel P1Lbl;
    private JLabel P2Lbl;
    private JLabel P3Lbl;
    private JLabel P4Lbl;
     
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    Player currPlayer;
    private int current = 0;
    private int numberOfPlayers;
    
    private ArrayList<Player> Players = new ArrayList();

    ArrayList<Location> Countries = new ArrayList();
    
    private Dice Dice = new Dice();
    int DiceRoll;
    int DiceConst = 10;
            
    private javax.swing.Timer motionTimer = new javax.swing.Timer(50,new motionListener());
    private javax.swing.Timer DiceTimer = new javax.swing.Timer(50,new DiceListener());
    
    
    
    public Game(int n,String[] names)
    {
        numberOfPlayers = n;
        initializePlayers(n,names);
        initializeCountries(); 
        initializeComponents(); 
    } 
    
    public void initializeComponents() 
    {
        TitledBorder InfoLogName = BorderFactory.createTitledBorder("News Log");
        TitledBorder InfoTitle = BorderFactory.createTitledBorder("Tile Info");
        c = getContentPane(); 
        setSize(1000,730);
        setTitle("Monopoly");
        setLocation(150,0);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Data.setPreferredSize(new Dimension(293,700));
        Data.setBackground(new Color(85,107,47));
        
        InfoLog.setBounds(100, 390, 165 ,200);
        
        InfoLog.setEditable(false);
        InfoLog.setBorder(InfoLogName);
       
        
        
        
        Buy.setPreferredSize(new Dimension(80,40));
        Buy.setBounds(220,295,80,40);
        Buy.setEnabled(false);
        InfoButton.setBounds(270,250,180,40);
        Roll.setBounds(420,295,80,40);
        Info.setBounds(270,390,180,200);
        EndTurn.setBounds(300,340,120,40);
        EndTurn.setEnabled(false);
        Info.setEditable(false);
        Info.setBorder(InfoTitle);
        Sell.setPreferredSize(new Dimension(80,40));
        Sell.setBounds(320,295,80,40);
        BuildHouse.setPreferredSize(new Dimension(120,40));
        BuildHouse.setBounds(460,390,120,40);
        BuildHouse.setEnabled(false);
        
        
        Board = new Board(Players,numberOfPlayers);
        Board.repaint();
        Board.add(Buy);
        Board.add(Roll);
        Board.add(InfoButton);
        Board.add(EndTurn);
        Board.add(Info);
        Board.add(Dice);
        Board.add(Sell);
        Board.add(BuildHouse);
        Board.add(InfoLog);
        
        c.add(Board);
        c.add(Data , BorderLayout.WEST) ; 

        InfoButton.addActionListener(new InfoButtonListener());  
        Roll.addActionListener(new RollButtonListener());
        Buy.addActionListener(new BuyButtonListener());
        EndTurn.addActionListener(new EndButtonListener());
        Sell.addActionListener(new SellButtonListener());
        BuildHouse.addActionListener(new BtnBuildListener());
        setVisible(true); 
    }
    public class BtnBuildListener implements ActionListener
    {
    public void actionPerformed(ActionEvent e){
        if(currPlayer.CanBuy(200))
        {
            currPlayer.deductMoney(200);
            Country c = (Country) currPlayer.getCurrentLocation() ;
            c.setnHouses(c.getnHouses()+1);
            c.setRent(200*c.getnHouses());
            updateLabels();
        }
    }
    }
    
    public ArrayList<Player> getPlayers(){return Players;}
    
    public void setDiceRoll(int x) { this.DiceRoll=x;}
    
    public JButton getRollButton(){return Roll;}
    
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
        
        Countries.add(new Country("Times Square",60,2,1));
        Countries.add(new communityChest("Community Chest"));
        Countries.add(new Country("Baltic Avenue",60,4,3));
        Countries.add(new Location ("Income Tax"));
        Countries.add(new RailRoad("Reading Railroad"));
        Countries.add(new Country("Oriental Avenue",100,6,6));
        Countries.add(new Chance("Chance"));
        Countries.add(new Country("Vermont Avenue",100,6,8));
        Countries.add(new Country("Ellis Island",120,8,9));

        Countries.add(new Jail());

        Countries.add(new Country("East Village",140,10,11));
        Countries.add(new waterelec("Electric Company"));
        Countries.add(new Country("States Avenue",140,10,13));
        Countries.add(new Country("Virginia Avenue",160,12,14));
        Countries.add(new RailRoad("Pennsylvania Railroad"));
        Countries.add(new Country("St James Place",160,14,16));
        Countries.add(new communityChest("Community Chest"));
        Countries.add(new Country("Tennesee Avenue",180,14,18));
        Countries.add(new Country("New York Avenue",200,16,19));
        
        Countries.add(new Location("Free Parking"));
        
        Countries.add(new Country("Kentucky Avenue",220,18,21));
        Countries.add(new Chance("Chance"));
        Countries.add(new Country("Indiana Avenue",220,18,23));
        Countries.add(new Country("Illinois Avenue",240,20,24));
        Countries.add(new RailRoad("B&O Railroad"));
        Countries.add(new Country("Atlantic Avenue",260,22,26));
        Countries.add(new Country("Ventor Avenue",260,22,27));
        Countries.add(new waterelec("Water Works"));        
        Countries.add(new Country("Marvin Gardens",280,24,29));
        
        Countries.add(new Location ("Go to Jail"));
        
        Countries.add(new Country("Pacific Avenue",300,26,31));      
        Countries.add(new Country("Central Park",300,26,32));
        Countries.add(new communityChest("Community Chest"));
        Countries.add(new Country("Penn Avenue",320,28,34));
        Countries.add(new RailRoad("Short Line"));
        Countries.add(new Chance("Chance"));
        Countries.add(new Country("Park Place",350,35,37));
        Countries.add(new Location ("Luxury Tax"));
        Countries.add(new Country("Wall Street",400,50,39));
    }
    
    void updateLabels()
    {
        P1Lbl.setText(p1.getName()+" : $"+p1.getMoney());
        P2Lbl.setText(p2.getName()+" : $"+p2.getMoney());
        if(!(p3 == null))
            P3Lbl.setText(p3.getName()+" : $"+p3.getMoney());
        
        if(!(p4 == null))
            P4Lbl.setText(p4.getName()+" : $"+p4.getMoney());
    }
      
    void updateLists()
    {
        int gapIndex;
        char[] Text;
        String newText = "";
        if(currPlayer.equals(p1))
        {
            gapIndex = P1Owned.getText().indexOf("");
            newText = "";
            Text = P1Owned.getText().toCharArray();
            for(int i=0 ; i < gapIndex ; i++)
                newText += Text[i];
            
            for(int i=gapIndex+1 ; i < Text.length ; i++)
                newText += Text[i];
            
            P1Owned.setText(newText);
        }
        
        else if(currPlayer.equals(p2))
        {
            gapIndex = P2Owned.getText().indexOf("");
            newText = "";
            Text = P2Owned.getText().toCharArray();
            for(int i=0 ; i < gapIndex ; i++)
                newText += Text[i];
            
            for(int i=gapIndex+1 ; i < Text.length ; i++)
                newText += Text[i];
            
            P2Owned.setText(newText);
        }
        
        else if(currPlayer.equals(p3))
        {
            gapIndex = P3Owned.getText().indexOf("");
            newText = "";
            Text = P3Owned.getText().toCharArray();
            for(int i=0 ; i < gapIndex ; i++)
                newText += Text[i];
            
            for(int i=gapIndex+1 ; i < Text.length ; i++)
                newText += Text[i];
            
            P3Owned.setText(newText);
        }
        
        else if(currPlayer.equals(p4))
        {
            gapIndex = P4Owned.getText().indexOf("");
            newText = "";
            Text = P4Owned.getText().toCharArray();
            for(int i=0 ; i < gapIndex ; i++)
                newText += Text[i];
            
            for(int i=gapIndex+1 ; i < Text.length ; i++)
                newText += Text[i];
            
            P4Owned.setText(newText);
        }
    }
    
    public void checkIfLost()
    {
        if(currPlayer.hasLost())
           {
               JOptionPane.showMessageDialog(null, "YOU LOST :(");
               if(currPlayer.getName().equals(p1.getName()))
               {
                   P1Lbl.setText(p1.getName()+" : LOST");
                   P1Owned.setText("");
               }
               
               else if(currPlayer.getName().equals(p2.getName()))
               {
                   P2Lbl.setText(p1.getName()+" : LOST");
                   P2Owned.setText("");
               }
               
               else if(currPlayer.getName().equals(p3.getName()))
               {
                   P3Lbl.setText(p3.getName()+" : LOST");
                   P3Owned.setText("");
               }
               
               else if(currPlayer.getName().equals(p4.getName()))
               {
                   P4Lbl.setText(p4.getName()+" : LOST");
                   P4Owned.setText("");
               }
               
               numberOfPlayers--;
               Board.setNumberOfPlayers(numberOfPlayers);
               currPlayer.Kick();
               Players.remove(currPlayer); 
               Board.setPlayers(Players);
               Board.repaint();               
               currPlayer = Players.get(current);
               Roll.setEnabled(true);
               Buy.setEnabled(false);
               EndTurn.setEnabled(false);
           }
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
            while(currPlayer.isPrisoned() && !(currPlayer.hasFreePass()) && !(currPlayer.PaidForPrison))
            {
                currPlayer.setPrisoned(false);
                current = (current+1)%numberOfPlayers;
                currPlayer = Players.get(current);
            }
           
            currPlayer.setFreePass(false);
            currPlayer.PaidForPrison=false ;
            Roll.setEnabled(true);
            Buy.setEnabled(false);
            EndTurn.setEnabled(false);
        }
    }
    
    class BuyButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean Success = currPlayer.Buy();
            updateLabels();
            if(currPlayer.getName().equals(p1.getName()) && Success)
                P1Owned.setText(P1Owned.getText()+p1.getCurrentLocation().getName()+"\n");

            else if(currPlayer.getName().equals(p2.getName()) && Success)
                P2Owned.setText(P2Owned.getText()+p2.getCurrentLocation().getName()+"\n");

            else if(!(p3 == null) && currPlayer.getName().equals(p3.getName()) && Success)
                P3Owned.setText(P3Owned.getText()+p3.getCurrentLocation().getName()+"\n");

            else if(!(p4 == null) && currPlayer.getName().equals(p4.getName()) && Success)
                P4Owned.setText(P4Owned.getText()+p4.getCurrentLocation().getName()+"\n");
            if (currPlayer.getCurrentLocation() instanceof Country)
            {
                Country c = (Country) currPlayer.getCurrentLocation() ;
                   if(c.isSetComplete()&&Success)
                   {
                       BuildHouse.setEnabled(true);
                   }
            }
            
        }
    }
    class SellButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean Success = currPlayer.Sell();
            updateLabels();
            if(currPlayer.getName().equals(p1.getName()) && Success)
                P1Owned.setText(P1Owned.getText().replace(p1.getCurrentLocation().getName(),""));

            else if(currPlayer.getName().equals(p2.getName()) && Success)
                P2Owned.setText(P2Owned.getText().replace(p2.getCurrentLocation().getName(),""));

            else if(!(p3 == null) && currPlayer.getName().equals(p3.getName()) && Success)
                P3Owned.setText(P3Owned.getText().replace(p3.getCurrentLocation().getName(),""));

            else if(!(p4 == null) && currPlayer.getName().equals(p4.getName()) && Success)
                P4Owned.setText(P4Owned.getText().replace(p4.getCurrentLocation().getName(),""));
            
            updateLists();
        }
    }
    
    class motionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           if(DiceRoll >  0)
           {
                EndTurn.setEnabled(false);
                Buy.setEnabled(false);
                Sell.setEnabled(false);
                currPlayer.Move(currPlayer.isForward());
                updateLabels();
                DiceRoll--;
                Board.repaint();
                
           }
           
           else
           {
               currPlayer.setDirection(true);
               Location l = Countries.get(currPlayer.getIndex());
               currPlayer.setCurr(l);
               motionTimer.stop();
               Buy.setEnabled(true);
               Sell.setEnabled(true);
               
               if(l instanceof Country)
               {
                   Country c = (Country) l;
                   if(c.isSetComplete()&& c.getOwner().equals(currPlayer.getName()))
                   {
                       BuildHouse.setEnabled(true);
                   }
               }
               currPlayer.checkRent(Players,Dice);
               currPlayer.checkTaxes();
               currPlayer.checkChance(motionTimer, DiceTimer, Dice, Game.this);
               currPlayer.checkCommunityChest(motionTimer, DiceTimer, Dice, Game.this);
               currPlayer.CheckJail(motionTimer, Game.this);      
               updateLabels();        
               EndTurn.setEnabled(true);
               checkIfLost();
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
                Dice.setCount(0);
                DiceTimer.stop();
                motionTimer.start();
                DiceTimer.stop();
            }
        }   
    }
    
   
}
 

