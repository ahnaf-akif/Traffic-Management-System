package trafficmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

public class SignUp {
    FrontWindow fw;
    JFrame frame=new JFrame("SignUp");
    JButton SignUp=new JButton("SignUp");
    JButton back=new JButton("Back");
    Label Tlable=new Label("Sign Up",Label.CENTER);
        Label lable1=new Label("Name      : ");
        Label lable2=new Label("Age         : ");
        Label lable3=new Label("Gender    : ");
        Label lable4=new Label("Phone     : ");
        Label lable5=new Label("Address   : ");
        Label lable6=new Label("Date of Birth : ");
        Label lable7=new Label("Email ID  : ");
        Label lable8=new Label("Username: ");
        Label lable9=new Label("Password: ");
        JTextField text1=new JTextField(60);
        JTextField text2=new JTextField(60);
        JTextField text3=new JTextField(60);
        JTextField text4=new JTextField(60);
        JTextField text5=new JTextField(60);
        JTextField text6=new JTextField(60);
        JTextField text7=new JTextField(60);
        JTextField text8=new JTextField(60);
        JPasswordField text9=new JPasswordField(10);
   SignUp(FrontWindow fw){
        this.fw=fw;
        frame.setLayout(null);
        frame.setSize(500,550);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new Window());
        frame.getContentPane().setBackground(new Color(179, 199, 201));
        SignUp.setSize(100,35);
        SignUp.setLocation(250, 450);
        SignUp.addActionListener(new SignUpL(this));
        back.setSize(100,35);
        back.setLocation(150, 450);
        back.addActionListener(new Back3L(this));
        
        
        Tlable.setLocation(130,10);
        Tlable.setSize(220,50);
        
        Tlable.setFont(new Font("verdana",Font.BOLD,30));
        lable1.setLocation(110, 80);
        lable1.setSize(70, 30);
        
        lable1.setFont(new Font("verdana",Font.BOLD,13));
        lable2.setLocation(110,120);
        lable2.setSize(70,30);
        
        lable2.setFont(new Font("verdana",Font.BOLD,13));
        lable3.setLocation(110,160);
        lable3.setSize(70,30);
        
        lable3.setFont(new Font("verdana",Font.BOLD,13));
        lable4.setLocation(110,200);
        lable4.setSize(70,30);
        
        lable4.setFont(new Font("verdana",Font.BOLD,13));
        lable5.setLocation(110,240);
        lable5.setSize(70,30);
        
        lable5.setFont(new Font("verdana",Font.BOLD,13));
        text1.setLocation(200, 80);
        text1.setSize(150, 30);
        text1.setFont(new Font("verdana",Font.BOLD,11));
        text2.setLocation(200, 120);
        text2.setSize(150, 30);
        text2.setFont(new Font("verdana",Font.BOLD,11));
        text3.setLocation(200, 160);
        text3.setSize(150, 30);
        text3.setFont(new Font("verdana",Font.BOLD,11));
        text4.setLocation(200, 200);
        text4.setSize(150, 30);
        text4.setFont(new Font("verdana",Font.BOLD,11));
        text5.setLocation(200, 240);
        text5.setSize(150, 30);
        text5.setFont(new Font("verdana",Font.BOLD,11));
        text6.setLocation(200, 280);
        text6.setSize(150, 30);
        text6.setFont(new Font("verdana",Font.BOLD,11));
        text7.setLocation(200, 320);
        text7.setSize(150, 30);
        text7.setFont(new Font("verdana",Font.BOLD,11));
        text8.setLocation(200, 360);
        text8.setSize(150, 30);
        text8.setFont(new Font("verdana",Font.BOLD,11));
        text9.setLocation(200, 400);
        text9.setSize(150, 30);
        text9.setFont(new Font("verdana",Font.BOLD,11));
        lable6.setLocation(90, 280);
        lable6.setSize(90,30);
        lable6.setFont(new Font("verdana",Font.BOLD,13));
        
        lable7.setLocation(110, 320);
        lable7.setSize(70, 30);
        
        lable7.setFont(new Font("verdana",Font.BOLD,13));
        lable8.setLocation(110, 360);
        lable8.setSize(75, 30);
       
        lable8.setFont(new Font("verdana",Font.BOLD,13));
        lable9.setLocation(110, 400);
        lable9.setSize(75, 30);
        
        lable9.setFont(new Font("verdana",Font.BOLD,13));
        frame.add(lable1);
        frame.add(lable2);
        frame.add(lable3);
        frame.add(lable4);
        frame.add(lable5);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(text5);
        frame.add(text6);
        frame.add(text7);
        frame.add(text8);
        frame.add(text9);
        frame.add(lable6);
        frame.add(lable7);
        frame.add(lable8);
        frame.add(lable9);
        frame.add(Tlable);
        frame.add(SignUp);
        frame.add(back);
        frame.setVisible(true);
    }
   class Window extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.exit(0);
	}
}
   class Back3L implements ActionListener{
    SignUp s;
    Back3L(SignUp s){
        this.s=s;
    }
    public void actionPerformed(ActionEvent ae){
        s.frame.dispose();
        new FrontWindow();
    }
}
   class SignUpL implements ActionListener{
       SignUp s;
       String sql,str;
       int i;
       SignUpL(SignUp s){
        this.s=s;
    }
       public void actionPerformed(ActionEvent ae){
           str=s.text7.getText();
           if(s.text1.getText().equals("")||s.text2.getText().equals("")||s.text3.getText().equals("")||s.text4.getText().equals("")||s.text5.getText().equals("")||s.text6.getText().equals("")||s.text7.getText().equals("")||s.text8.getText().equals("")||s.text9.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Please fill all the required field!!!");
           else if(str.contains("@gmail.com")||str.contains("@yahoo.com")||str.contains("@protonmail.com"))
           {
               
        if(s.fw.CBox2.getSelectedIndex()==0){
            sql="INSERT INTO `admin` (`name`, `age`, `gender`,`phone`,`DOB`,`email`,`username`,`password`,`address`) VALUES ('"+s.text1.getText().toString()+"','"+s.text2.getText().toString()+"','"+s.text3.getText().toString()+"','"+s.text4.getText().toString()+"','"+s.text6.getText().toString()+"','"+s.text7.getText().toString()+"','"+s.text8.getText().toString()+"','"+s.text9.getText().toString()+"','"+s.text5.getText().toString()+"')";
            i=new DB().theQuery(sql);
            if(i==1){
                JOptionPane.showMessageDialog(null,"SignUp Successful!!!");
            s.frame.dispose();
            new FrontWindow();
            }
            
        }
          else if(s.fw.CBox2.getSelectedIndex()==1){
            sql="INSERT INTO `trafficpolice` (`name`, `age`, `gender`,`phone`,`DOB`,`email`,`username`,`password`,`address`) VALUES ('"+s.text1.getText().toString()+"','"+s.text2.getText().toString()+"','"+s.text3.getText().toString()+"','"+s.text4.getText().toString()+"','"+s.text6.getText().toString()+"','"+s.text7.getText().toString()+"','"+s.text8.getText().toString()+"','"+s.text9.getText().toString()+"','"+s.text5.getText().toString()+"')";
            i=new DB().theQuery(sql);
            if(i==1){
                JOptionPane.showMessageDialog(null,"SignUp Successful!!!");
            s.frame.dispose();
            new FrontWindow();
            }
            
        }
           else if(s.fw.CBox2.getSelectedIndex()==2){
            sql="INSERT INTO `ordinaryperson` (`name`, `age`, `gender`,`phone`,`DOB`,`email`,`username`,`password`,`address`) VALUES ('"+s.text1.getText().toString()+"','"+s.text2.getText().toString()+"','"+s.text3.getText().toString()+"','"+s.text4.getText().toString()+"','"+s.text6.getText().toString()+"','"+s.text7.getText().toString()+"','"+s.text8.getText().toString()+"','"+s.text9.getText().toString()+"','"+s.text5.getText().toString()+"')";
            i=new DB().theQuery(sql);
            if(i==1){
                JOptionPane.showMessageDialog(null,"SignUp Successful!!!");
            s.frame.dispose();
            new FrontWindow();
            }
            
        }
      }
           else {
               JOptionPane.showMessageDialog(null,"Invalid Email!!!");
           }
           }
          
           
    }
   }

    
