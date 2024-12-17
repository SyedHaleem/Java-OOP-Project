/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbankform;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author syedh
 */
public class Registration extends JFrame{
    public String identity;
    public char [] password;
    public String phone;
    public String address;
    public int age;
    public String name;
    public String Type;
    
    JButton register,clear;
    JTextField nam,add,ph,ag,Id,type;
    JPasswordField pass;
    JFrame frame=new JFrame();
    public void initialize()
   {
               frame.setVisible(true );
               frame.setSize(850, 800);
               frame.setTitle("Blood Bank System");
               frame.setLayout(null);
               frame.setLocation(300,0);
               frame.getContentPane().setBackground(Color.red);
       Random rd=new Random();
       int Iden=rd.nextInt(5000)+1;
    //Image
    ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("pics/imgg.png"));
    JLabel lb=new JLabel(i);
    lb.setBounds(50, 5, 200, 200);
    frame.add(lb);
    
    //Heading
    JLabel text=new JLabel("Register Here");
    text.setFont(new Font("Raleway",Font.BOLD,50));
    text.setBounds(300,75,400,60);
    frame.add(text);
    //Input Text Name
    type=new JTextField();
    type.setBounds(360, 150, 200, 30);
    type.setBackground(Color.BLUE);
    type.setEditable(false);
    type.setHorizontalAlignment(SwingConstants.CENTER);
    type.setForeground(Color.white);
//    type.setBackground(Color.white);
    type.setFont(new Font("Arial",Font.BOLD,20));
    frame.add(type);
    
    JLabel name= new JLabel("Name: ");
    name.setFont(new Font("Raleway",Font.BOLD,25));
    name.setBounds(100, 250, 150, 40);
    frame.add(name);
    nam=new JTextField();
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
    Id.setText(Integer.toString(Iden));
    Id.setEditable(false);
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
    ag.setBounds(200, 455, 200, 30);
    ag.setFont(new Font("Arial",Font.BOLD,20));
//    ag.addActionListener();
    frame.add(ag);
    
    //Input Text Password
    JLabel password= new JLabel("Password: ");
    password.setFont(new Font("Raleway",Font.BOLD,25));
    password.setBounds(420, 450, 150, 40);
    frame.add(password);
    pass=new JPasswordField();
    pass.setBounds(550, 455, 200, 30);
    pass.setFont(new Font("Arial",Font.BOLD,20));
//    pass.addActionListener();


    frame.add(pass);
    
    //Button Register
    register=new JButton("Register");
    register.setBackground(Color.black);
    register.setForeground(Color.white);
    register.setBounds(290, 600, 100, 40);
    register.addActionListener(new eventHandler());
    frame.add(register);
    
    //Button clear
    clear=new JButton("Clear");
    clear.setBackground(Color.black);
    clear.setForeground(Color.white);
    clear.setBounds(480, 600, 100, 40);
    clear.addActionListener(new eventHandler());
    frame.add(clear);
   }
    public class eventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            add.getText();
            ph.getText();
            ag.getText();
            Id.getText();
            pass.getPassword();
            if(e.getSource()==clear)
            {
                nam.setText("");
                add.setText("");
                ph.setText("");
                ag.setText("");
                Id.setText("");
                pass.setText("");
            }
            
            else if(e.getSource()==register)
            {
                identity=Id.getText();
                password=pass.getPassword();
                name=nam.getText();
                phone=ph.getText();
                address=add.getText();

                Type=type.getText();
                System.out.println(nam.getText());
                if(!"".equals(nam.getText()) && !"".equals(add.getText()) && !"".equals(ph.getText()) && !"".equals(ag.getText()) && !"".equals(Id.getText()) && pass.getPassword().length!=0)
                {    
                     String var=ag.getText();
                int ag1=Integer.parseInt(var);
                age=ag1;
                JOptionPane.showMessageDialog(register, "You have been Registered");
                Login login=new Login(identity, password,name,address,phone,age,Type);
                login.intiaize();
                frame.setVisible(false);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(register, "Please Enter the Complete Information","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    } 
    }
    