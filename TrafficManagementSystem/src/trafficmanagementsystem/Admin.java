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
public class Admin {
    JFrame frame=new JFrame("Admin");
    Label Tlabel=new Label("Admin");
    JTextArea information=new JTextArea(5,20);
    Label lable1=new Label("Information: ");
    JButton update=new JButton("Update");
    JButton logout=new JButton("LogOut");
    JButton CMview=new JButton("View Complain Table");
    Admin() {
        frame.setLayout(null);
        frame.setSize(500,320);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new Window());
        frame.getContentPane().setBackground(new Color(179, 199, 201));
        Tlabel.setLocation(180,10);
        Tlabel.setSize(200,50);
        Tlabel.setFont(new Font("verdana",Font.BOLD,30));
        lable1.setSize(80, 30);
        lable1.setLocation(15, 80);
        lable1.setFont(new Font("verdana",Font.BOLD,13));
        
        update.setSize(100,35);
        update.setLocation(355, 85);
        update.addActionListener(new updateL(this));
        logout.setSize(100,35);
        logout.setLocation(185, 220);
        logout.addActionListener(new LogoutL(this));
        information.setLocation(100, 85);
        information.setSize(250, 70);
        information.setFont(new Font("verdana",Font.BOLD,11));
        CMview.setLocation(150, 175);
        CMview.setSize(170,35);
        CMview.addActionListener(new CMview(this));
        frame.add(lable1);
        frame.add(information);
        frame.add(Tlabel);
        frame.add(update);
        frame.add(logout);
        frame.add(CMview);
        frame.setVisible(true);
    }
    class Window extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.exit(0);
	}
    }
}
class CMview implements ActionListener{
    Admin a;
    String sql="SELECT * FROM complain";
    CMview(Admin a){
        this.a=a;
    }
    public void actionPerformed(ActionEvent ae){
        new DB().getComplainTableData(sql);
    }
}
class updateL implements ActionListener{
    Admin a;
    String s,sql;
    updateL(Admin a)
    {
        this.a=a;
        s=a.information.getText();
    }
    public void actionPerformed(ActionEvent ae){
        if(a.information.getText().equals(s))
            JOptionPane.showMessageDialog(null,"Information required to be filled!!!");
        else 
        { 
            sql="INSERT INTO `information` ( `information`) VALUES ('"+a.information.getText().toString()+"')";
            new DB().theQuery(sql);
            JOptionPane.showMessageDialog(null,"Information submitted!!!");
            a.information.setText("");
        }
       
    }
}
class LogoutL implements ActionListener{
    Admin a;
    int dialogButton = JOptionPane.YES_NO_OPTION;
                

    LogoutL(Admin a){
        this.a=a;
    }
    public void actionPerformed(ActionEvent ae){
                JOptionPane.showConfirmDialog (null, "Do you want to Logout?","Warning",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){
                    a.frame.dispose();
                    new FrontWindow();
                }
    }
}
class adminBMain{
    public static void main(String []args)
    {
        Admin adm=new Admin();
    }
}