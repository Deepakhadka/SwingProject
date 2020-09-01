import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Add extends JFrame implements ActionListener{
	JLabel name,price,description,catagory;
	JButton Add;
	JTextField tfname,tfprice,tfdec;
	JComboBox jcatagory;
	public Add(){
		name=new JLabel("Name");
		price=new JLabel("Price");
		description=new JLabel("Description");
		catagory=new JLabel("Catagory");
		Add=new JButton("Add");
		tfname=new JTextField(50);
		tfprice=new JTextField(50);
		tfdec=new JTextField(50);
		String[] arr={"T-shirt","pants","shorts","kurtii","saari"};
		jcatagory=new JComboBox(arr);
		add(name);
		add(tfname);
		add(price);
		add(tfprice);
		add(description);
		add(tfdec);
		add(catagory);
		add(jcatagory);
		add(Add);
		setVisible(true);
		setSize(800,800);
		setLayout(null);
		name.setBounds(60,100,100,50);
		tfname.setBounds(130,100,100,50);
		price.setBounds(60,200,100,50);
		tfprice.setBounds(130,200,100,50);
		description.setBounds(60,300,100,50);
		tfdec.setBounds(150,300,100,50);
		catagory.setBounds(60,400,100,60);
		jcatagory.setBounds(140,400,100,60);
		Add.setBounds(80,500,100,60);
		  Add.addActionListener(this);
  }
  	public void actionPerformed(ActionEvent aeee){
  			String name=tfname.getText();
  			String price=tfprice.getText();
  			String description=tfdec.getText();
  			String catagory=jcatagory.getSelectedItem().toString();
  			if(name.isEmpty()){
  				JOptionPane.showMessageDialog(this,"enter name please!!");
  			}
  			if(price.isEmpty()){
  				JOptionPane.showMessageDialog(this,"enter price please!!");
  			}

  			if(description.isEmpty()){
  				JOptionPane.showMessageDialog(this,"feature please!!");
  			}

  			else{
  				try{
  					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
						System.out.println("connected");
						String q="insert into Product(Name,Price,Description,Category) values(?,?,?,?)";
                    PreparedStatement ps=con.prepareStatement(q);
                    ps.setString(1,name);
                    ps.setString(2,price);
                    ps.setString(3,description);
                    ps.setString(4,catagory);
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
        new Add();
    }
}