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
public class TrafficControllBox  {
    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JFrame TCMainFrame=new JFrame();
    JButton stop=new JButton("STOP");
        JButton go=new JButton("GO");
        JButton slow=new JButton("SLOW");
        JButton logout=new JButton("LogOut");
        JPanel ImPanel=new JPanel();
        Label Headlable=new Label("Traffic Control Box",Label.CENTER);
    TrafficControllBox(){
        
        TCMainFrame.setSize(500,420);
        TCMainFrame.setLocationRelativeTo(null);
        TCMainFrame.setLayout(null);
        TCMainFrame.addWindowListener(new Window());
        TCMainFrame.getContentPane().setBackground(new Color(179, 199, 201));
        image1=new ImageIcon(getClass().getResource("images/go.jpg"));
        l1=new JLabel(image1);
        image2=new ImageIcon(getClass().getResource("images/stop.png"));
        l2=new JLabel(image2);
        
        image3=new ImageIcon(getClass().getResource("images/slow.png"));
        l3=new JLabel(image3);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        
        ImPanel.setBackground(new Color(179, 199, 201));
        
        Headlable.setLocation(110,10);
        Headlable.setSize(270,50);
        Headlable.setFont(new Font("verdana",Font.BOLD,30));
        stop.setLocation(95,80);
        stop.setSize(100,35);
        stop.addActionListener(new stopL(l1,l2,l3));
        go.setLocation(195, 80);
        go.setSize(100,35);
        go.addActionListener(new goL(l1,l2,l3));
        slow.setLocation(295, 80);
        slow.setSize(100,35);
        slow.addActionListener(new slowL(l1,l2,l3));
        ImPanel.setLocation(145,150);
        ImPanel.setSize(200,158);
        ImPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        ImPanel.add(l1);
        ImPanel.add(l2);
        ImPanel.add(l3);
        logout.setLocation(195,320);
        logout.setSize(100,35);
        logout.addActionListener(new Logout3L(this));
        TCMainFrame.add(stop);
        TCMainFrame.add(go);
        TCMainFrame.add(slow);
        TCMainFrame.add(Headlable);
        TCMainFrame.add(ImPanel);
        TCMainFrame.add(logout);
        TCMainFrame.setVisible(true);
    }
    
   class Window extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.exit(0);
	}
} 
}
class stopL implements ActionListener{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    stopL(JLabel label1,JLabel label2,JLabel label3){
        this.label1=label1;
        this.label2=label2;
        this.label3=label3;
    }
     public void actionPerformed(ActionEvent ae){
         label1.setVisible(false);
         label2.setVisible(true);
         label3.setVisible(false);
     }
}
  class goL implements ActionListener{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    goL(JLabel label1,JLabel label2,JLabel label3){
        this.label1=label1;
        this.label2=label2;
        this.label3=label3;
    }
     public void actionPerformed(ActionEvent ae){
         label1.setVisible(true);
         label2.setVisible(false);
         label3.setVisible(false);
     }
}  
class slowL implements ActionListener{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    slowL(JLabel label1,JLabel label2,JLabel label3){
        this.label1=label1;
        this.label2=label2;
        this.label3=label3;
    }
     public void actionPerformed(ActionEvent ae){
         label1.setVisible(false);
         label2.setVisible(false);
         label3.setVisible(true);
     }
}
class Logout3L implements ActionListener{
    TrafficControllBox tc;
    int dialogButton = JOptionPane.YES_NO_OPTION;
                

    Logout3L(TrafficControllBox tc){
        this.tc=tc;
    }
    public void actionPerformed(ActionEvent ae){
                JOptionPane.showConfirmDialog (null, "Do you want to Logout?","Warning",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){
                    tc.TCMainFrame.dispose();
                    new FrontWindow();
                }
    }
}
class Main{
    public static void main(String []args){
        
        TrafficControllBox TC=new TrafficControllBox();
    }
}