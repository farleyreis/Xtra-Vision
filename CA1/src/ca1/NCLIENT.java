/**
 *
 * @author farleyreis  & Matheus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

    public abstract class NCLIENT extends JFrame implements ActionListener {
        
	private long idClient         = 0;
	private String name      = null;
	private String phoneN  = null;
	private String email     = null;


	
	public long getidClient() {
		return idClient;
	}
	public void setidClient(long idClient) {
		this.idClient = idClient;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getphoneN() {
		return phoneN;
	}
	public void setphoneN(String phoneN) {
		this.phoneN = phoneN;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public static boolean consultar(long idClient) {
	
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
    
        try {
            
        	String sql = "SELECT * FROM Cliente WHERE idClient = ?";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            stm.setLong(1, idClient);
            
            rs = stm.executeQuery();
            
            
            if (rs.next()) {
            	rs.close();
            	return true;
            }            

            rs.close();            
            return false;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return false;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }		

	}



    Container container = getContentPane();
    JLabel nameLabel = new JLabel("ENTER FULL NAME");
    JTextField nameFild = new JTextField();
    JLabel phoneLabel = new JLabel("PHONE NUMBER");
    JTextField phoneTextFild = new JTextField();
    JLabel emailLabel = new JLabel("EMAIL");
    JTextField emailTextFild = new JTextField();
    JLabel passW = new JLabel("ENTER PASSWORD");

    JPasswordField emailPass = new JPasswordField();
    JLabel passW1 = new JLabel("CONFIRM PASSW");
    JPasswordField emailPass1 = new JPasswordField();
    JButton backButton = new JButton("BACK MENU");
    JButton submitB = new JButton("SUBMIT");

    JLabel background;
    JLabel qrC;




    NCLIENT() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        ImageIcon img = new ImageIcon("src/images/movieQR.jpg");
        //ImageIcon qrCode = new ImageIcon("CA1/src/images/QR.png");

        background = new JLabel("",img,JLabel.CENTER);
        //qrC = new JLabel("",qrCode,JLabel.CENTER);
        //qrC.setSize(400,400);
        background.setSize(1400,788);
        container.add(background);
        //container.add(qrC);
        //qrCode.getImageLoadStatus();
    }

    NCLIENT(CA1.EventHandler aThis, boolean b) {
        CA1.actionPerformed(null);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        nameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(700, 100, 250, 50);
        nameFild.setBounds(900, 100, 400, 50);
        phoneLabel.setBounds(700,150,150,50);
        phoneLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        phoneLabel.setForeground(Color.white);
        phoneTextFild.setBounds(900,150,400,50);
        emailLabel.setBounds(700, 200, 150, 50);
        emailLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        emailLabel.setForeground(Color.WHITE);
        emailTextFild.setBounds(900,200,400,50);
        passW.setBounds(700, 250, 400, 50);
        emailPass.setBounds(900, 250, 400, 50);
        passW.setFont(new Font("Calibri", Font.BOLD, 20));
        passW.setForeground(Color.white);
        passW1.setBounds(700,300,400,50);
        passW1.setFont(new Font("Calibri", Font.BOLD, 20));
        passW1.setForeground(Color.white);
        emailPass1.setBounds(900, 300, 400, 50);
        //emailPass.setBounds(200,100,400,50);

        submitB.setBounds(200,600,250,70);
        backButton.setBounds(200,680,250,70);


;

        setSize(1400, 788);
    }

    public void addComponentsToContainer() {
        

        container.add(nameLabel);
        container.add(nameFild);
        container.add(phoneLabel);
        container.add(phoneTextFild);
        container.add(emailLabel);
        container.add(emailPass);
        container.add(emailPass1);
        container.add(backButton);
        container.add(submitB);
        container.add(emailTextFild);
        container.add(passW);
        container.add(passW1);
    }

    public void addActionEvent() {
        //newMovies.addActionListener(this);
        submitB.addActionListener(new ActionListener() {

                                     public void actionPerformed(ActionEvent e) {
                                         try {
                                             theQuery("INSERT INTO Client (fullName,phoneNumber,email,passW,passwC) VALUES ('" + nameFild.getText() + "','" + phoneTextFild.getText() + "','" + emailTextFild.getText() + "','" + emailPass.getText() + "','" + emailPass1.getText() + "')");
                                              CA1 ps = new CA1();
                                         } catch (Exception ex) {
                                         }

                                     }

                                 }
        );
        backButton.addActionListener(new ActionListener() {

                                    public void actionPerformed(ActionEvent e) {
                                        DVDRENT ps = new DVDRENT();

                                        ps.setVisible(true);

                                    }

                                }
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setLocationRelativeTo(null);
        setSize(1400, 799);

    }

    //function to execute the insert update delete query
    public void theQuery(String query) {
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/Matheus_2019378?useSSL=false", "Matheus_2019378", "2019378");
            st = con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Query Executed");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

//    public static void main(String[] args) {
//
//        new NCLIENT() {
//
//            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//        };
//
//    }
}
