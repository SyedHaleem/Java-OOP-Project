/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbankform;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
/**
 *
 * @author syedh
 */
public class ALogin extends JFrame {
    private String Id="admin";
    private String Pass="haleem110";

    

    public String getId() {
        return Id;
    }

    public String getPass() {
        return Pass;
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
          JLabel id = new JLabel("User Name: ");
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
          
          register=new JButton("Back");
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
               Selection sel=new Selection();
               sel.intialize();
               Login.setVisible(false);
               
               
            }
            else if(e.getSource()==login)
            {
              String id=idtf.getText();
                char[] pass=pintf.getPassword();
                
                if(Id.compareTo(id)==0 && Pass.equals(new String(pass))==true)
                {
                 JOptionPane.showMessageDialog(login, "Admin has logged In", "", JOptionPane.INFORMATION_MESSAGE); 
                 Admin frame=new Admin();
                 frame.intialize(); 
                 Login.setVisible(false);
                }
                
                 
                else if(Id.compareTo(id)!=0 || Pass.equals(new String(pass))==false)
                {
                 JOptionPane.showMessageDialog(login, "Please Enter Correct Info:", "", JOptionPane.ERROR_MESSAGE);   
                }
                
                
            }
        }
    }
}

