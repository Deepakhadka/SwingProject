import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
	JLabel login,name,password;
	JTextField tfname;
	JPasswordField pass;
	JButton Submit;
	public Login(){
		login=new JLabel("LOGIN YOUR ACCOUNT");
		name=new JLabel("Name");
		password=new JLabel("Password");
		tfname=new JTextField(40);
		pass=new JPasswordField(40);
		Submit=new JButton("Submit");
		setLayout(null);
		setSize(800,800);
		setVisible(true);
		login.setBounds(100,90,200,100);//x,y,width,height//
		name.setBounds(100,200,100,60);
		tfname.setBounds(200,200,100,60);
		password.setBounds(100,300,100,60);
		pass.setBounds(200,300,100,60);
		Submit.setBounds(100,400,100,60);
		add(login);
		add(name);
		add(tfname);
		add(password);
		add(pass);
		add(Submit);
		Submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent aeyyy){
		String name=tfname.getText();
		String password=pass.getText();
			if (name.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter your username");
            
            }else if(password.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter your password");
                
            }
            else{
            	try{
            		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
						System.out.println("connected");
            		            		 Statement stmt = con.createStatement();
                        String sql="select Name,Password from register";
                        ResultSet rs = stmt.executeQuery(sql); 
                        while(rs.next())
                        { 
                                String dbname= rs.getString("Name");  
                                String dbpass= rs.getString("Password");
                           
                            if(name.equals(dbname) &&password.equals(dbpass))
                                {
                                    new Product();
                                }
                                else{
                                	JOptionPane.showMessageDialog(this,"SORRY!!");
                                }
                            
                        }

                    
                    }catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
	}
}

public static void main(String args[])
    {
        new Login();
    }
}