/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbankform;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author syedh
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
public class Donnerdata extends JFrame {
     private String name;
    private String id;
    private String address;
    private String phone;
    private String  password;
    private int age;
    private String bg;
    private int bottle;
    
    public Donnerdata(String n, String id, int ag,String pass, String addr, String cn)
    {
        this.id=id;
        this.name=n;
        this.password=pass;
        this.phone=cn;
        this.age=ag;
        this.address=addr;

    }
    JButton submit,clear,main;
    JTextField nam,add,ph,ag,Id,bloodg,bloodb;
    JTextField pass;
    JFrame frame=new JFrame();
    public void initialize()
   {
     frame.setVisible(true);
                 frame.setSize(850, 800);
                 frame.setTitle("Blood Bank System");
                 frame.setLayout(null);
                 frame.setLocation(300,0);
                 frame.getContentPane().setBackground(Color.red);
    ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("pics/imgg.png"));
    JLabel lb=new JLabel(i);
    lb.setBounds(50, 5, 200, 200);
    frame.add(lb);
    
    //Heading
    JLabel text=new JLabel("Donner Data");
    text.setFont(new Font("Raleway",Font.BOLD,50));
    text.setBounds(300,75,400,60);
    frame.add(text);
    //Input Text Name
    JLabel name= new JLabel("Name: ");
    name.setFont(new Font("Raleway",Font.BOLD,25));
    name.setBounds(100, 250, 150, 40);
    frame.add(name);
    nam=new JTextField();
    nam.setText(this.name);
    nam.setEditable(false);
    nam.setHorizontalAlignment(SwingConstants.CENTER);
    nam.setBounds(200, 255, 200, 30);
    nam.setFont(new Font("Arial",Font.BOLD,20));
//    nam.addActionListener();
    frame.add(nam);
    
    //Input Text id
    JLabel id= new JLabel("ID No: ");
    id.setFont(new Font("Raleway",Font.BOLD,25));
    id.setBounds(450, 250, 150, 40);
    frame.add(id);
    
    Id=new JTextField();
    Id.setText(this.id);
    Id.setEditable(false);
    Id.setHorizontalAlignment(SwingConstants.CENTER);
    Id.setBounds(550, 255, 200, 30);
    Id.setFont(new Font("Arial",Font.BOLD,20));
//    Id.addActionListener();
    frame.add(Id);
    
    //Input Text phone
    JLabel phone= new JLabel("Phone: ");
    phone.setFont(new Font("Raleway",Font.BOLD,25));
    phone.setBounds(100, 350, 150, 40);
    frame.add(phone);
    ph=new JTextField();
    ph.setText(this.phone);
    ph.setEditable(false);
    ph.setHorizontalAlignment(SwingConstants.CENTER);
    ph.setBounds(200, 355, 200, 30);
    ph.setFont(new Font("Arial",Font.BOLD,20));
//    ph.addActionListener();
    frame.add(ph);
    
    //Input Text Address
    JLabel address= new JLabel("Address: ");
    address.setFont(new Font("Raleway",Font.BOLD,25));
    address.setBounds(420, 350, 150, 40);
    frame.add(address);
    add=new JTextField();
    add.setText(this.address);
    add.setEditable(false);
    add.setHorizontalAlignment(SwingConstants.CENTER);
    add.setBounds(550, 355, 200, 30);
    add.setFont(new Font("Arial",Font.BOLD,20));
//    add.addActionListener();
    frame.add(add);
    
    //Input Text Age
    JLabel age= new JLabel("Age: ");
    age.setFont(new Font("Raleway",Font.BOLD,25));
    age.setBounds(100, 450, 150, 40);
    frame.add(age);
    ag=new JTextField();
    ag.setText(Integer.toString(this.age));
    ag.setEditable(false);
    ag.setHorizontalAlignment(SwingConstants.CENTER);
    ag.setBounds(200, 455, 200, 30);
    ag.setFont(new Font("Arial",Font.BOLD,20));
//    ag.addActionListener();
    frame.add(ag);
    
    //Input Text Password
    JLabel password= new JLabel("Password: ");
    password.setFont(new Font("Raleway",Font.BOLD,25));
    password.setBounds(420, 450, 150, 40);
    frame.add(password);
    pass=new JTextField();
    pass.setText(this.password);
    pass.setEditable(false);
    pass.setHorizontalAlignment(SwingConstants.CENTER);
    pass.setBounds(550, 455, 200, 30);
    pass.setFont(new Font("Arial",Font.BOLD,20));
//    pass.addActionListener();
    frame.add(pass);
    
    JLabel bg= new JLabel("B:Group");
    bg.setFont(new Font("Raleway",Font.BOLD,25));
    bg.setBounds(100, 525, 110, 40);
    frame.add(bg);
    bloodg=new JTextField();
     bloodg.setHorizontalAlignment(SwingConstants.CENTER);
    bloodg.setBounds(200, 535, 200, 30);
    bloodg.setFont(new Font("Arial",Font.BOLD,20));
    frame.add(bloodg);
    
    JLabel bb= new JLabel("B:Bag: ");
    bb.setFont(new Font("Raleway",Font.BOLD,25));
    bb.setBounds(420, 525, 110, 40);
    frame.add(bb);
    bloodb=new JTextField();
     bloodb.setHorizontalAlignment(SwingConstants.CENTER);
    bloodb.setBounds(550, 535, 200, 30);
    bloodb.setFont(new Font("Arial",Font.BOLD,20));
    frame.add(bloodb);
    
    //Button Register
    submit=new JButton("Submit");
    submit.setBackground(Color.black);
    submit.setForeground(Color.white);
    submit.setBounds(290, 650, 100, 40);
    submit.addActionListener(new eventHandler());
    frame.add(submit);
    
    //Button clear
    clear=new JButton("Clear");
    clear.setBackground(Color.black);
    clear.setForeground(Color.white);
    clear.setBounds(480, 650, 100, 40);
    clear.addActionListener(new eventHandler());
    frame.add(clear);
    
    
    main=new JButton("Main Menu");
    main.setBackground(Color.black);
    main.setForeground(Color.white);
    main.setBounds(385, 710, 100, 40);
    main.addActionListener(new eventHandler());
    frame.add(main);
   }
    public class eventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()==clear)
            {
                nam.setText("");
                add.setText("");
                ph.setText("");
                ag.setText("");
                Id.setText("");
                pass.setText("");
                bloodg.setText("");
                bloodb.setText("");
            }
            
            else if(e.getSource()==submit)
            {
                if(!"".equals(nam.getText()) && !"".equals(add.getText()) && !"".equals(ph.getText()) && !"".equals(ag.getText()) && !"".equals(Id.getText()) && !"".equals(pass.getText()) && !"".equals(bloodg.getText()) &&!"".equals(bloodb.getText()))
                {   
                try
                {
                    
                 FileWriter fr=new FileWriter("Donner.txt",true);
                 fr.write(nam.getText()+","+Id.getText()+","+add.getText()+","+ph.getText()+","+ag.getText()+","+pass.getText()+","+bloodg.getText()+","+bloodb.getText()+"\n");
                 fr.close();
                 JOptionPane.showMessageDialog(submit, "Record Added", "", JOptionPane.INFORMATION_MESSAGE);
                 bloodg.setText("");
                 bloodb.setText("");
                
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());     
                }     
            }
                
                else
                {
                    JOptionPane.showMessageDialog(submit, "Please Enter the Complete Information","Error", JOptionPane.ERROR_MESSAGE);
                }
        }
            else if(e.getSource()==main)
            {
                Selection sel=new Selection();
                sel.intialize();
                frame.setVisible(false);
                        
            }
        
    }
    }
}