/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbankform;
import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
/**
 *
 * @author syedh
 */
public class Login extends JFrame {
    private String Id;
    private char [] Pass;
    private String add;
    private String name;
    private String ph;
    private int age;
    private String Utype;
    
    public Login(String id, char [] pas,String na,String ad, String ph,int a,String t)
    {
     this.Id=id;   
     this.Pass=pas;
     this.add=ad;
     this.age=a;
     this.ph=ph;
     this.name=na;
     this.Utype=t;
    }
    public Login()
    {
     
    }

    public String getId() {
        return Id;
    }

    public char[] getPass() {
        return Pass;
    }

    public String getAdd() {
        return add;
    }

    public String getName() {
        return name;
    }

    public String getPh() {
        return ph;
    }

    public int getAge() {
        return age;
    }
    
    JButton login,clear,register;
    JTextField idtf;
    JPasswordField pintf;
    JFrame Login=new JFrame();
    public void intiaize()
    {
        Login.setLayout(null);
                
                Login.setSize(850, 800);
                Login.setVisible(true);
                Login.setLocation(300, 0);
                Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.setTitle("Blood Bank Management Sytsem");
                Login.getContentPane().setBackground(Color.red);
        JLabel text=new JLabel("Login Here");
        text.setBounds(320,90,600,60);
        text.setFont(new Font("Osward",Font.BOLD,50));
        Login.add(text);     
          ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("pics/imgg.png"));
          Image ic1=ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
          JLabel lb=new JLabel(ic);
          lb.setBounds(50, 5, 200, 200);
          Login.add(lb);
          JLabel id = new JLabel("ID Number: ");
          id.setFont(new Font("Raleway",Font.BOLD,28));
          id.setBounds(100, 250, 200, 40);
          Login.add(id);
          
          idtf=new JTextField();
          idtf.setBounds(350, 250, 250, 40);
          idtf.setFont(new Font("Arial",Font.BOLD,20));
          Login.add(idtf);
          
          JLabel pass=new JLabel("Password: ");
          pass.setFont(new Font("Raleway",Font.BOLD,28));
          pass.setBounds(100, 350, 200, 40);
          Login.add(pass);
          
          pintf=new JPasswordField();
          pintf.setFont(new Font("Arial",Font.BOLD,20));
          pintf.setBounds(350, 350, 250, 40);
          Login.add(pintf);
          
          register=new JButton("Main Menu");
          register.setBounds(360,450,100,40);
          register.setBackground(Color.black);
          register.setForeground(Color.white);
          register.addActionListener(new eventHandler());
          Login.add(register);
          
          clear=new JButton("Clear");
          clear.setBounds(490,450,100,40);
          clear.setBackground(Color.black);
          clear.setForeground(Color.white);
          clear.addActionListener(new eventHandler());
          Login.add(clear);
          
          login=new JButton("Login");
          login.setBounds(360, 510, 230, 40);
          login.setBackground(Color.black);
          login.setForeground(Color.white);
          login.addActionListener(new eventHandler());
          Login.add(login);

    }
    public class eventHandler implements ActionListener
    {
        

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()==clear)
            {
                idtf.setText("");
                pintf.setText("");
            }
            else if(e.getSource()==register)
            {
               Registration frame=new Registration();
               Selection sel=new Selection();
                sel.intialize();
               Login.setVisible(false);
               
            }
            else if(e.getSource()==login)
            {
                System.out.printf("Name: %s\nPhone:%s\nID: %s\nAge: %d\nAddress: %s\nUser_Type: %s\n",name,ph,Id,age,add,Utype);
                String id=idtf.getText();
                char[] pass=pintf.getPassword();
                
                if(Id.compareTo(id)==0 && Arrays.equals(Pass, pass))
                {
                    
                if(Utype.compareTo("Donner")==0)
                {
                 String pas= new String(Pass);
                 Donnerdata frame=new Donnerdata(name,Id,age,pas,add,ph);
                 frame.initialize();
                 Login.setVisible(false);
                 
                }
                
                else if(Utype.compareTo("Acceptor")==0)
                {
                 String pas= new String(Pass);
                 AcceptorData frame=new AcceptorData(name,Id,age,pas,add,ph);
                 frame.initialize(); 
                 Login.setVisible(false);
                }
                }
                 
                else if(Id.compareTo(id)!=0 || Arrays.equals(Pass, pass)==false)
                {
                 JOptionPane.showMessageDialog(login, "Please Enter Correct Info:", "", JOptionPane.ERROR_MESSAGE);   
                }
                
            }
        }
    }
}
