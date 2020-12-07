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
import java.awt.event.*;
import java.awt.color.*;
public class FrontWindow {
    JFrame frame=new JFrame("Main Frame");
    Label Tlabel=new Label("Choose Your Option");
    String l="Login";
    String s="Sign Up";
    String[] LStrings = { "Admin", "Traffic Police", "Ordinary Person" };
    String[] SString = {"Admin", "Traffic Police", "Ordinary Person"};
    JRadioButton rbutton1=new JRadioButton(s);
    JRadioButton rbutton2=new JRadioButton(l);
    JPanel panel=new JPanel(new BorderLayout());
    JComboBox CBox1=new JComboBox(LStrings);
    JComboBox CBox2=new JComboBox(SString);
    Label lable1=new Label("LogIn As : ");
    Label lable2=new Label("Sign Up As : ");
    JButton next=new JButton("Next");
    FrontWindow(){
        
        frame.setLayout(null);
        frame.setSize(500,320);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new Window1());
        frame.getContentPane().setBackground(new Color(179, 199, 201));
        next.setSize(100,35);
        next.setLocation(190, 230);
        next.addActionListener(new Next(rbutton2,rbutton1,this));
        Tlabel.setLocation(95,10);
        Tlabel.setSize(290,50);
        Tlabel.setFont(new Font("verdana",Font.BOLD,30));
        frame.add(Tlabel);
        rbutton2.setBackground(new Color(179, 199, 201));
        rbutton1.setBackground(new Color(179, 199, 201));
        rbutton1.addActionListener(new rbutton1L(CBox2,CBox1,lable2,lable1));
        rbutton2.addActionListener(new rbutton2L(CBox2,CBox1,lable2,lable1));
        ButtonGroup group=new ButtonGroup();
        group.add(rbutton1);
        group.add(rbutton2);
        
        panel.setLocation(90, 70);
        panel.setSize(300,30);
        panel.setBackground(new Color(179, 199, 201));
        panel.add(rbutton1,BorderLayout.EAST);
        panel.add(rbutton2,BorderLayout.WEST);
        
        CBox1.setSelectedIndex(-1);
        CBox1.setSize(120, 30);
        CBox1.setLocation(110,110);
        CBox1.setEnabled(false);
        CBox2.setSize(120, 30);
        CBox2.setLocation(335,110);
        CBox2.setSelectedIndex(-1);
        CBox2.setEnabled(false);
        
        lable1.setLocation(40, 110);
        lable1.setSize(70, 30);
        lable1.setFont(new Font("verdana",Font.BOLD,13));
        lable1.setEnabled(false);
        lable2.setLocation(250,110);
        lable2.setSize(80, 30);
        lable2.setFont(new Font("verdana",Font.BOLD,13));
        lable2.setEnabled(false);
        frame.add(panel);
        frame.add(lable1);
        frame.add(lable2);
        frame.add(CBox1);
        frame.add(CBox2);
        frame.add(next);
        
        frame.setVisible(true);
        
    }
        
}
class Window1 extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.exit(0);
	}
}
class Next implements ActionListener{
    JRadioButton rb1;
    JRadioButton rb2;
    FrontWindow f;
    Next(JRadioButton rb1,JRadioButton rb2,FrontWindow f){
        this.rb1=rb1;
        this.rb2=rb2;
        this.f=f;
    }
    public void actionPerformed(ActionEvent ae){
        if (rb1.isSelected()==true&&f.CBox1.getSelectedIndex()!=-1)
        {
            new Login(f);
            f.frame.dispose();
        }
        else if (rb2.isSelected()==true&&f.CBox2.getSelectedIndex()!=-1)
        {
            new SignUp(f);
            f.frame.dispose();
        }
            
        else if (f.CBox1.getSelectedIndex()==-1||f.CBox2.getSelectedIndex()==-1)
            JOptionPane.showMessageDialog(null,"How you want to Login or Signup is required!!!");
    }
}
class rbutton1L implements ActionListener{
    JComboBox cb1;
    JComboBox cb2;
    Label l1;
    Label l2;
    rbutton1L(JComboBox cb1,JComboBox cb2,Label l2,Label l1){
        this.cb1=cb1;
        this.cb2=cb2;
        this.l1=l1;
        this.l2=l2;
    }
    public void actionPerformed(ActionEvent ae)
        {
                l1.setEnabled(false);
                l2.setEnabled(true);
                cb2.setEnabled(false);
                cb1.setEnabled(true);
                
        }
}
class rbutton2L implements ActionListener{
    JComboBox cb1;
    JComboBox cb2;
    Label l1;
    Label l2;
    rbutton2L(JComboBox cb1,JComboBox cb2,Label l2,Label l1){
        this.cb1=cb1;
        this.cb2=cb2;
        this.l1=l1;
        this.l2=l2;
    }
    public void actionPerformed(ActionEvent ae)
        {
                l2.setEnabled(false);
                l1.setEnabled(true);
                cb1.setEnabled(false);
                cb2.setEnabled(true);
        }
}
class FMain{
    public static void main(String []args)
    {
        FrontWindow FW=new FrontWindow();
    }
}