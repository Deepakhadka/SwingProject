import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Register extends JFrame implements ActionListener{
	JLabel name,password,address,contact,email,gender;
	JTextField tfname,tfgender,tfaddress,tfcontact,tfemail;
	JPasswordField tfpass;
	JButton Submit;
	JRadioButton r1,r2,r3;
	String radio(){
		if(r1.isSelected()){
			return "Male";
		}
		else if(r2.isSelected()){
			return "Female";
		}
		else{
			return "Others";
		}
	}

public Register(){
	name=new JLabel("Name");
	password=new JLabel("Password");
	gender=new JLabel("gender");
	address=new JLabel("address");
	contact=new JLabel("contact");
	email=new JLabel("email");
	tfname=new JTextField(60);
	tfpass=new JPasswordField(60);
	tfaddress=new JTextField(60);
	tfcontact=new JTextField(60);
	tfemail=new JTextField(60);
	r1=new JRadioButton("Male");
	r2=new JRadioButton("Female");
	r3=new JRadioButton("Others");
	ButtonGroup bg=new ButtonGroup();
	bg.add(r1);
	bg.add(r2);
	bg.add(r3);
	add(r1);
	add(r2);
	add(r3);
	Submit=new JButton("Submit");
	add(name);
	add(password);
	add(gender);
	add(contact);
	add(email);
	add(address);
	add(Submit);
	add(tfname);
	add(tfpass);
	add(tfaddress);
	add(tfcontact);
	add(tfemail);
	setSize(1000,1000);
    setLayout(null);
    setVisible(true);
    name.setBounds(20,30,80,30);
    tfname.setBounds(120,30,80,30);
    password.setBounds(20,70,80,30);
    tfpass.setBounds(120,70,80,30);
    gender.setBounds(20,130,80,30);
    r1.setBounds(120,130,80,30);
    r2.setBounds(200,130,80,30);
    r3.setBounds(280,130,80,30);
    address.setBounds(20,170,80,30);
    tfaddress.setBounds(120,170,80,30);
    contact.setBounds(20,220,80,30);
    tfcontact.setBounds(120,220,80,30);
    email.setBounds(20,260,80,30);
    tfemail.setBounds(120,260,80,30);
    Submit.setBounds(20,300,80,30);
    Submit.addActionListener(this);

}
		 public void actionPerformed(ActionEvent fg)
    {
        String name=tfname.getText();
        String pass=tfpass.getText();
        String address=tfaddress.getText();
        String contact=tfcontact.getText();
        String email=tfemail.getText();


            
             if (name.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter Username");
            
            }else if(pass.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter password");
                
            }
            else if(address.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"enter your address"); 
            }
            else
            {
                try {
                	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
						System.out.println("connected");
                    String q="insert into register(Name,Password,Gender,Address,Contact,Email) values(?,?,?,?,?,?)";
                    PreparedStatement ps=con.prepareStatement(q);
                    ps.setString(1,name);
                    ps.setString(2,pass);
                    ps.setString(3,radio());
                    ps.setString(4,address);
                    ps.setString(5,contact);
                    ps.setString(6,email);
                    int a = ps.executeUpdate();
                    if(a > 0){
                        JOptionPane.showMessageDialog(this,"recorded successfully"); 
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(this,"not recorded"); 
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
}

}
public static void main(String args[])
    {
        new Register();
    }
}


