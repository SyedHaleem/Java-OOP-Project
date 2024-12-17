/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbankform;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.EventListener;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;
/**
 *
 * @author syedh
 */
public class Admin extends JFrame
{
    JRadioButton Donner,Acceptor;
    JButton delete,search,read,main,histroy;
    ButtonGroup grp=new ButtonGroup();
    JFrame frame=new JFrame();
    public void intialize()
    {
        frame.setVisible(true );
               frame.setSize(850, 800);
               frame.setTitle("Blood Bank System");
               frame.setLayout(null);
               frame.setLocation(300,0);
               frame.getContentPane().setBackground(Color.red);
        Font f=new Font("Osward",Font.BOLD,30);
        Border b=BorderFactory.createLineBorder(Color.white, 2);
        JLabel text1=new JLabel("Admin Block");
        text1.setBounds(275,85,600,60);
        text1.setFont(new Font("Osward",Font.BOLD,50));
        frame.add(text1);    
        
        JLabel text3=new JLabel("Manage Data");
        text3.setBounds(275,250,600,60);
        text3.setFont(new Font("Osward",Font.BOLD,40));
       frame.add(text3);
          ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("pics/imgg.png"));
          Image ic1=ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
          JLabel lb=new JLabel(ic);
          lb.setBounds(50, 5, 200, 200);
          frame.add(lb);
          
          Donner=new JRadioButton();
          Donner.setText("Donner");
          Donner.setFont(f);
          Donner.setBorder(b);
          Donner.setBackground(Color.red);
          Donner.setForeground(Color.black);
          Donner.setSelected(true);
          Donner.setBounds(250, 320, 170, 50);
          frame.add(Donner);
          
          Acceptor=new JRadioButton();
          Acceptor.setText("Acceptor");
          Acceptor.setFont(f);
          Acceptor.setBorder(b);
          Acceptor.setBackground(Color.red);
          Acceptor.setForeground(Color.black);
          Acceptor.setBounds(430, 320, 170, 50);
          frame.add(Acceptor);
          
          grp.add(Donner);
          grp.add(Acceptor);
          
          main=new JButton("Main Menu");
          main.setBackground(Color.black);
          main.setForeground(Color.white);
          main.setBounds(360, 400, 100, 40);
          main.addActionListener(new btn_eventHandler());
          frame.add(main);
          
          read=new JButton("View");
          read.setBackground(Color.black);
          read.setForeground(Color.white);
          read.setBounds(275, 470, 100, 40);
          read.addActionListener(new btn_eventHandler());
          frame.add(read);
          
          delete=new JButton("Delete");
          delete.setBackground(Color.black);
          delete.setForeground(Color.white);
          delete.setBounds(450, 470, 100, 40);
          delete.addActionListener(new btn_eventHandler());
          frame.add(delete);
          
          search=new JButton("Search");
          search.setBackground(Color.black);
          search.setForeground(Color.white);
          search.setBounds(360, 540, 100, 40);
          search.addActionListener(new btn_eventHandler());
          frame.add(search);
          
          histroy=new JButton("Blood Donated Histroy");
          histroy.setBackground(Color.black);
          histroy.setForeground(Color.white);
          histroy.setBounds(310, 610, 200, 40);
          histroy.addActionListener(new btn_eventHandler());
          frame.add(histroy);
          
          
    }
    
    public class btn_eventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
       {
           if(e.getSource()==read)
           {
            String sel=(Donner.isSelected()?"Donner":"Acceptor");
            if(sel.compareTo("Donner")==0)
            {
                
              try
                {
                File fd=new File("Donner.txt");
                Scanner input=new Scanner(fd);
                int flag=1;
                boolean hasData = false;
                
                while(input.hasNext())
                {
                    String  str=input.nextLine();
                    
                    System.out.println(str);
                      String [] data=str.split(",");
//                      st=data[0];
                      JOptionPane.showMessageDialog(read, " Record "+flag,"",JOptionPane.INFORMATION_MESSAGE);
                      System.out.println(str);
                      JOptionPane.showMessageDialog(read,"Name: "+data[0]+"\n"+"ID: "+data[1]+"\n"+"Blood Group: "+data[6]+"\n"+"\n","Donner Data",JOptionPane.INFORMATION_MESSAGE);
                      
                      flag++;
                      hasData=true;
                      
                }
                input.close();
                if(!hasData)
                {
                    JOptionPane.showMessageDialog(read, "Donner are not Available","",JOptionPane.WARNING_MESSAGE);
                }
                        
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else if(sel.compareTo("Acceptor")==0)
            {
              try
                {
                File fa=new File("Acceptor.txt");
                Scanner input=new Scanner(fa);
                int flag=1;
                boolean hasData = false;
                while(input.hasNext())
                {
                    String  str=input.nextLine();
                    System.out.println(str);
                      String [] data=str.split(",");
                      JOptionPane.showMessageDialog(read, " Record "+flag,"",JOptionPane.INFORMATION_MESSAGE);
                      JOptionPane.showMessageDialog(read,"Name: "+data[0]+"\n"+"ID: "+data[1]+"\n"+"Blood Group: "+data[6]+"\n"+"\n","Acceptor Data",JOptionPane.INFORMATION_MESSAGE);
                      flag++;
                      hasData=true;
                }
                input.close();
                 if(!hasData)
                {
                    JOptionPane.showMessageDialog(read, "Acceptor are not Available","",JOptionPane.WARNING_MESSAGE);
                }
                  
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
              
            }
            }
           
           
           else if(e.getSource()==delete)
           {
               String sel=(Donner.isSelected()?"Donner":"Acceptor");
            if(sel.compareTo("Donner")==0)
            {
              try
                {
                int flg=0;
                boolean chk=false;
                String var1=JOptionPane.showInputDialog(delete, "Enter ID NO: ");
                FileWriter fr=new FileWriter("temp.txt");
                File f=new File("Donner.txt");
                Scanner input=new Scanner(f);
                while(input.hasNext())
                {
                    String str=input.nextLine();
                    String[] data=str.split(",");
                    if(var1.compareTo(data[1])==0)
                    {
                        flg++;
                        //System.out.println(str);
                        chk=true;
                    }
                    else
                    {
                       fr.write(str+"\n");
                    }
                }
                fr.close();
                input.close();
                f.delete();
                File ft=new File("temp.txt");
                ft.renameTo(new File("Donner.txt"));
                
                if(chk==true)
                {
                    JOptionPane.showMessageDialog(delete," Donner Data Deleted");
//                JOptionPane.showMessageDialog(delete,"Donner Record Deleted");
                
                }
                if(chk==false)
                 {
                     JOptionPane.showMessageDialog(search, "Donner Data Not Deleted","",JOptionPane.WARNING_MESSAGE);
                 }
                        
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            
            
            else if(sel.compareTo("Acceptor")==0)
            {
              try
                {
                    boolean chk=false;
                int flg=0;
                String var1=JOptionPane.showInputDialog(delete, "Enter ID NO: ");
                FileWriter fr=new FileWriter("temp.txt");
                File f=new File("Acceptor.txt");
                Scanner input=new Scanner(f);
                while(input.hasNext())
                {
                    String str=input.nextLine();
                    String[] data=str.split(",");
                    if(var1.compareTo(data[1])==0)
                    {
                        chk=true;
                        flg++;
                        //System.out.println(str);
                    }
                    else
                    {
                       fr.write(str+"\n");
                    }
                }
                fr.close();
                input.close();
                f.delete();
                File ft=new File("temp.txt");
                ft.renameTo(new File("Acceptor.txt"));
                if(chk==true)
                {
                JOptionPane.showMessageDialog(delete,"Acceptor Record Deleted");
                }
                if(chk==false)
                 {
                     JOptionPane.showMessageDialog(search, "Acceptor Data Not Deleted","",JOptionPane.WARNING_MESSAGE);
                 }
                        
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
               
           }
           else if(e.getSource()==search)
           {
            String sel=(Donner.isSelected()?"Donner":"Acceptor");
            if(sel.compareTo("Donner")==0)
            {
                
             try
             {
                 int flag=0;
                 boolean chk=false;
                 File fr = new File("Donner.txt");
                 Scanner input=new Scanner(fr);
                 String var1=JOptionPane.showInputDialog(search,"Enter ID No:");
                 while(input.hasNext())
                 {
                     
                  String  str=input.nextLine();
                  String [] data=str.split(",");
                  if(var1.compareTo(data[1])==0)
                  {
                      flag++;
                      System.out.println(str);
                      JOptionPane.showMessageDialog(search,"Name: "+data[0]+"\n"+"ID: "+data[1]+"\n"+"Address: "+data[2]+"\n"+"Contact No: "+data[3]+"\n"+"Age: "+data[4]+"\n"+"Blood Group: "+data[6]+"\n"+"Blood Quantity: "+data[7]+"\n","Donner Full Data",JOptionPane.INFORMATION_MESSAGE);
                      chk=true;
                  }
                    
                 }
                 if(chk==false)
                 {
                     JOptionPane.showMessageDialog(search, "Not Found with this ID No:  ","",JOptionPane.WARNING_MESSAGE);
                 }
                     

                 input.close();
             }   
             catch(Exception ex)
             {
                 System.out.println(ex.getMessage());
             }
            }   
            
            else if(sel.compareTo("Acceptor")==0)
            {
                
             try
             {
                 int flag=0;
                 boolean chk=false;
                 File fr = new File("Acceptor.txt");
                 Scanner input=new Scanner(fr);
                 String var1=JOptionPane.showInputDialog(search,"Enter ID No:");
                 while(input.hasNext())
                 {
                  
                  String  str=input.nextLine();
                  String [] data=str.split(",");
                  if(var1.compareTo(data[1])==0)
                  {
                      flag++;
                      
                      System.out.println(str);
                      JOptionPane.showMessageDialog(search,"Name: "+data[0]+"\n"+"ID: "+data[1]+"\n"+"Address: "+data[2]+"\n"+"Contact No: "+data[3]+"\n"+"Age: "+data[4]+"\n"+"Blood Group: "+data[6]+"\n"+"Date: "+data[7]+"\n","Acceptor Full Data",JOptionPane.INFORMATION_MESSAGE);
                      chk=true;
                  }
                    
                 }
                 if(chk==false)
                 {
                     JOptionPane.showMessageDialog(search, "Not Found with this ID No:  ","",JOptionPane.WARNING_MESSAGE);
                 }
                     

                 input.close();
             }   
             catch(Exception ex)
             {
                 System.out.println(ex.getMessage());
             }
            }   
            
            
           }
           else if(e.getSource()==main)
           {
            Selection sel=new Selection();
            sel.intialize();   
            frame.setVisible(false);
               
           }
           else if (e.getSource() == histroy) {
          try {
            File file = new File("Acceptance.txt");
        Scanner input = new Scanner(file);
        DefaultListModel<String> listModel = new DefaultListModel<>();

        while (input.hasNext()) {
            String str = input.nextLine();
            
            listModel.addElement(str);
        }

        input.close();
        JList<String> historyList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(historyList);
        
        historyList.setPreferredSize(new Dimension(400, 300)); // Adjust the width and height as desired

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(400, 320));
        if (listModel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No entry available.", "History", JOptionPane.INFORMATION_MESSAGE);
        } 
              else {

         
        JOptionPane.showMessageDialog(null, scrollPane, "Blood Donated History", JOptionPane.PLAIN_MESSAGE);

            int selectedIndex = historyList.getSelectedIndex();

            if (selectedIndex != -1) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this entry?",
                        "Delete Entry", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    listModel.remove(selectedIndex);

                    // Update the file with the modified data
                    FileWriter writer = new FileWriter(file);
                    for (int i = 0; i < listModel.size(); i++) {
                        writer.write(listModel.get(i)+System.lineSeparator());
                    }
                    writer.close();

                    // Show the updated list after deletion
                    JOptionPane.showMessageDialog(null, scrollPane, "Blood Donated History", JOptionPane.PLAIN_MESSAGE);
                }
            } }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}
           }
           
       }
        
    }
        

