/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbankform;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;
/**
 *
 * @author syedh
 */
public class Selection extends JFrame
{
    JCheckBox chkD,chkA,chkAd,exit;
    ButtonGroup grp=new ButtonGroup();
    JFrame sel = new JFrame();
    public void intialize()
    {
        sel.setSize(900, 800);
        sel.setVisible(true);
        
        sel.setLayout(null);
        sel.setLocation(300, 0);
        sel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sel.setTitle("Blood Bank Management Sytsem");
        sel.getContentPane().setBackground(Color.red);

        Font f=new Font("Osward",Font.BOLD,30);
        Border b1=BorderFactory.createLineBorder(Color.BLACK, 2);
        JLabel text1=new JLabel("WelCome To AL-SYED");
        text1.setBounds(220,70,650,60);
        text1.setFont(new Font("Snap ITC",Font.BOLD,50));
   
        sel.add(text1);    
        JLabel text2=new JLabel("Blood Bank System");
        text2.setBounds(370,130,330,40);
//        text2.setBorder(b2);
        text2.setFont(new Font("ALGERIAN",Font.BOLD,30));
        sel.add(text2);
        JLabel text3=new JLabel("Select Your Interface");
        text3.setForeground(Color.blue);
        text3.setBounds(275,250,410,60);
        text3.setBorder(b1);
        text3.setFont(new Font("Osward",Font.BOLD,40));
        sel.add(text3);
          ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("pics/imgg.png"));
//          Image ic1=ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
          JLabel lb=new JLabel(ic);
          lb.setBounds(50, 5, 200, 200);
          sel.add(lb);
          
          chkD=new JCheckBox();
          chkD.setText("Donner");
          chkD.setFont(f);
          chkD.setBorder(b1);
          chkD.setBackground(Color.red);
          chkD.setForeground(Color.black);
          chkD.setBounds(360, 320, 200, 50);
          chkD.addItemListener(new CheckHandler());
          sel.add(chkD);
          chkA=new JCheckBox();
          chkA.setText("Acceptor");
          chkA.setFont(f);
          chkA.setBorder(b1);
          chkA.setBackground(Color.red);
          chkA.setForeground(Color.black);
          chkA.setBounds(360, 390, 200, 50);
          chkA.addItemListener(new CheckHandler());
          sel.add(chkA);
          
          
          chkAd=new JCheckBox();
          chkAd.setText(" Admin");
          chkAd.setFont(f);
          chkAd.setBorder(b1);
          chkAd.setBackground(Color.red);
          chkAd.setForeground(Color.black);
          chkAd.setBounds(360, 460, 200, 50);
          chkAd.addItemListener(new CheckHandler());
          sel.add(chkAd);
       
          
          exit=new JCheckBox();
          exit.setText(" Exit");
          exit.setFont(f);
          exit.setBorder(b1);
          exit.setBackground(Color.red);
          exit.setForeground(Color.black);
          exit.setBounds(360, 530, 200, 50);
          exit.addItemListener(new CheckHandler());
          sel.add(exit);
          grp.add(chkD);
          grp.add(chkA);
          grp.add(chkAd);
          grp.add(exit);
    }
    
    public class CheckHandler implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) {
            
            if(chkD.isSelected())
            {
               Registration frame=new Registration();
               frame.initialize();
               frame.type.setText("Donner");
               sel.setVisible(false);
            }
            else if (chkA.isSelected())
            {
               Registration fram=new Registration();
               fram.initialize();
               fram.type.setText("Acceptor");
               sel.setVisible(false);
            }
            else if (chkAd.isSelected())
            {
               ALogin log=new ALogin();
               log.intiaize();
               sel.setVisible(false);
                        
            }
            else if(exit.isSelected())
            {
                sel.setVisible(false);
                
            }
            
        }        
    }    
}
