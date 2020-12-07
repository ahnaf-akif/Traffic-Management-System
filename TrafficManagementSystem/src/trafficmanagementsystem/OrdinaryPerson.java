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
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
public class OrdinaryPerson {
    
    JFrame frame=new JFrame("Ordinary Person");
    Label Tlabel=new Label("Ordinary Person");
    JTextArea complain=new JTextArea(5,20);
    Label lable1=new Label("Complain: ");
    JButton submit=new JButton("Submit");
    JButton logout=new JButton("LogOut");
    JButton IMview=new JButton("View Information Table");
    OrdinaryPerson(){
        
        frame.setLayout(null);
        frame.setSize(500,320);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new Window());
        frame.getContentPane().setBackground(new Color(179, 199, 201));
        Tlabel.setLocation(125,10);
        Tlabel.setSize(260,50);
        Tlabel.setFont(new Font("verdana",Font.BOLD,30));
        lable1.setSize(70, 30);
        lable1.setLocation(30, 80);
        lable1.setFont(new Font("verdana",Font.BOLD,13));
        
        submit.setSize(100,35);
        submit.setLocation(355, 85);
        submit.addActionListener(new submitL(this));
        logout.setSize(100,35);
        logout.setLocation(185, 220);
        logout.addActionListener(new Logout2L(this));
        complain.setLocation(100, 85);
        complain.setSize(250, 70);
        complain.setFont(new Font("verdana",Font.BOLD,11));
        IMview.setLocation(150, 175);
        IMview.setSize(170,35);
        IMview.addActionListener(new IMview(this));
        frame.add(lable1);
        frame.add(complain);
        frame.add(Tlabel);
        frame.add(submit);
        frame.add(logout);
        frame.add(IMview);
        frame.setVisible(true);
        
    }
    class Window extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.exit(0);
	}
}
}
class submitL implements ActionListener{
    OrdinaryPerson p;
    String s,sql;
    int count=1;
    submitL(OrdinaryPerson p)
    {
        this.p=p;
        s=p.complain.getText();
    }
    public void actionPerformed(ActionEvent ae){
        if(p.complain.getText().equals(s))
            JOptionPane.showMessageDialog(null,"Complain required to be filled!!!");
        else 
        {
            sql="INSERT INTO `complain` ( `complain`) VALUES ('"+p.complain.getText().toString()+"')";
            new DB().theQuery(sql);
           JOptionPane.showMessageDialog(null,"Complain submitted!!!");
 }
            
            
            p.complain.setText("");
            
        }
       
    }

class IMview implements ActionListener{
    OrdinaryPerson p;
    ResultSet rs;
    String sql="SELECT * FROM information";
    IMview(OrdinaryPerson p){
        this.p=p;
    }
    public void actionPerformed(ActionEvent ae){
       
           
        new DB().getInfoTableData(sql);
        
       
    }
}
class Logout2L implements ActionListener{
    OrdinaryPerson op;
    int dialogButton = JOptionPane.YES_NO_OPTION;
                

    Logout2L(OrdinaryPerson op){
        this.op=op;
    }
    public void actionPerformed(ActionEvent ae){
                JOptionPane.showConfirmDialog (null, "Do you want to Logout?","Warning",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){
                    op.frame.dispose();
                    new FrontWindow();
                }
    }
}
class imvL implements ActionListener{
    OrdinaryPerson p;
    imvL(OrdinaryPerson p){
        this.p=p;
    }
    public void actionPerformed(ActionEvent ae){
        p.frame.dispose();
        //new InformationTable();
    }
}
class PCBMain{
    public static void main(String []args)
    {
        OrdinaryPerson pcb=new OrdinaryPerson();
    }
}
