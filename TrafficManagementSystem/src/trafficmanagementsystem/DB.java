/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sabbir
 */
package trafficmanagementsystem;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author Sabbir
 */
public class DB {

    /**
     * @param args the command line arguments
     */
    JTable Infotable=new JTable();
    JTable Complaintable=new JTable();
    JFrame frame=new JFrame("Data Table");
    Connection conn=null;
    Statement st=null;
    DB(){
        try{
        
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ahnaf","Ahnaf","ahnaf");
            st = (Statement) conn.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public ResultSet getInfoTableData(String sql){
        ResultSet rs=null;
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        
        try{
            rs = st.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel(new String[]{"Sl_no", "Information"}, 0);
        while(rs.next())
        {
            String col1 = rs.getString("Sl_no");
                String col2 = rs.getString("information"); 
                model.addRow(new Object[]{col1, col2});
        }
        Infotable.setModel(model);
        frame.add(Infotable);
        frame.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         return rs;
    }
    public ResultSet getComplainTableData(String sql){
        ResultSet rs=null;
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        try{
            rs = st.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel(new String[]{"Sl_no", "Complain"}, 0);
        while(rs.next())
        {
            String col1 = rs.getString("Sl_no");
                String col2 = rs.getString("complain"); 
                model.addRow(new Object[]{col1, col2});
        }
        Complaintable.setModel(model);
        
        frame.add(Complaintable);
        frame.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         return rs;
    }
    public ResultSet getSignUp(Login l)
    {
        Login L=l;
        String str="";
        int count=0;
        int i=-1;
        ResultSet rs=null;
        if(L.f.CBox1.getSelectedIndex()==0)
        {
            str="SELECT * FROM `admin` WHERE username = '"+L.text1.getText().toString()+"' AND password = '"+L.text2.getText().toString()+"'";
            i=0;
        }
        else if(L.f.CBox1.getSelectedIndex()==1)
        {
            str="SELECT * FROM `trafficpolice` WHERE username = '"+L.text1.getText().toString()+"' AND password = '"+L.text2.getText().toString()+"'";
            i=1;
        }
        else if(L.f.CBox1.getSelectedIndex()==2)
        {
            str="SELECT * FROM `ordinaryperson` WHERE username = '"+L.text1.getText().toString()+"' AND password = '"+L.text2.getText().toString()+"'";
            i=2;
        }
        try{
            rs = st.executeQuery(str);
            while(rs.next())
            {
                count++;
            }
                
            if(count==0)
                throw new Exception();
            else if(i==0)
            {
                JOptionPane.showMessageDialog(null,"Login Successful!!!");
                L.frame.dispose();
                new Admin();
            }
             else if(i==1)
            {
                JOptionPane.showMessageDialog(null,"Login Successful!!!");
                L.frame.dispose();
                new TrafficControllBox();
            }
            else if(i==2)
            {
                JOptionPane.showMessageDialog(null,"Login Successful!!!");
                L.frame.dispose();
                new OrdinaryPerson();
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Wrong Username or PassWord!!!");
        }
         return rs;
    }
    public int theQuery(String sql){
        int i=0;
        try{
            st = (Statement) conn.createStatement();
            st.executeUpdate(sql);
            i=1;
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            i=2;
        }
        return i;
    }
    
    
}