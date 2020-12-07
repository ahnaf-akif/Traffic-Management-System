/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahnaf
 */
package trafficmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
public class Login {
    FrontWindow f;
    JFrame frame=new JFrame("Login");
    JButton login=new JButton("Login");
    JButton back=new JButton("Back");
    Label Tlable=new Label("Login",Label.CENTER);
    Label lable1=new Label("Username: ");
        Label lable2=new Label("Password: ");
        JTextField text1=new JTextField(60);
        JPasswordField text2=new JPasswordField(10);
    Login(FrontWindow f){
        this.f=f;
        
        frame.setLayout(null);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new Window());
        frame.getContentPane().setBackground(new Color(179, 199, 201));
        
        login.setLocation(250,180);
        login.setSize(100,35);
        login.addActionListener(new loginL(this));
        back.setLocation(150,180);
        back.setSize(100,35);
        back.addActionListener(new BackL(this));
        Tlable.setLocation(130,10);
        Tlable.setSize(220,50);
        Tlable.setFont(new Font("verdana",Font.BOLD,30));
        
        
        lable1.setLocation(110, 80);
        lable1.setSize(70, 30);
        lable1.setFont(new Font("verdana",Font.BOLD,13));
        lable2.setLocation(110,120);
        lable2.setSize(70,30);
        lable2.setFont(new Font("verdana",Font.BOLD,13));
        text1.setLocation(200, 80);
        text1.setSize(150, 30);
        text1.setFont(new Font("verdana",Font.BOLD,11));
        text2.setLocation(200, 120);
        text2.setSize(150, 30);
        text2.setFont(new Font("verdana",Font.BOLD,11));
        frame.add(lable1);
        frame.add(lable2);
        frame.add(text1);
        frame.add(text2);
        frame.add(Tlable);
        frame.add(login);
        frame.add(back);
        frame.setVisible(true);
    }
    class loginL implements ActionListener{
    Login l;
    String sql;
    public loginL(Login l)
        {
            this.l=l;
            
        }
    public void actionPerformed(ActionEvent ae)
        {
            if(l.text1.getText().equals("")||l.text2.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill all the required field!!!");
                new DB().getSignUp(l);
            }
            
            
        }
    }
class BackL implements ActionListener{
    Login l;
    BackL(Login l){
        this.l=l;
    }
    public void actionPerformed(ActionEvent ae){
        l.frame.dispose();
        new FrontWindow();
    }
}
    class Window extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.exit(0);
	}
}
    //public static void main(String []args)
    //{
      //  Login l=new Login();
    //}

