import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
	JLabel welcome;
	JButton Login,Signup;
	public Home(){
		welcome=new JLabel("Welcome!!");
		Login=new JButton("Login");
		Signup=new JButton("Signup");
		setLayout(null);
        welcome.setBounds(400,150,150,50);
        Login.setBounds(350,250,150,50);
        Signup.setBounds(350,350,150,50);
        setSize(800,800);
        add(welcome);
        add(Login);
        add(Signup);
        setVisible(true);
        Login.addActionListener(this);
        Signup.addActionListener(this);
	}
public void actionPerformed(ActionEvent ac)
    {
      if(ac.getSource()==Login)  
      {
          new Login();
      }
      else if(ac.getSource()==Signup)  
      {
          new Register();
      }
    
    }
    public static void main(String args[])
    {
        new Home();
    }
}





