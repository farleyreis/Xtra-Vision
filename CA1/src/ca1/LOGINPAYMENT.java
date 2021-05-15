/**
 *
 * @author farleyreis  & Matheus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LOGINPAYMENT extends JFrame implements ActionListener {
    	private int payment_id        = 0;
	private String cardName    = null;
	private String phoneNumberCardHolder        = null;
	private String flagCard = null;
	private int cardNumber      = 0;
	private String valid        = null;
	private int codCard      = 0;
	private String status          = null;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

        
        
    public String getPhoneNumberCardHolder() {
        return phoneNumberCardHolder;
    }

    public void setPhoneNumberCardHolder(String phoneNumberCardHolder) {
        this.phoneNumberCardHolder = phoneNumberCardHolder;
    }
        

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getFlagCard() {
        return flagCard;
    }

    public void setFlagCard(String flagCard) {
        this.flagCard = flagCard;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCodCard() {
        return codCard;
    }

    public void setCodCard(int codCard) {
        this.codCard = codCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JButton getForget() {
        return forget;
    }

    public void setForget(JButton forget) {
        this.forget = forget;
    }
	public boolean inserirCheque() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        
        try {


        	String sqlInsert = "INSERT INTO Payment "
        			+ "(payment_id, cardName, phoneNumberCardHolder, flagCard, cardNumber, valid, codCard, status) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

        	
        	
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
    		stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                		

    		stm.setString(5, getCardName());    		
    		stm.setString(6, getPhoneNumberCardHolder());
    		stm.setString(7, getStatus());
    		stm.execute();
            
    		// Setar id que acabou de ser inserido
    		ResultSet rs = stm.getGeneratedKeys();
    		if (rs.next()) {
    			setPayment_id(rs.getInt(1));
    		}
    		
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
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
        public boolean inserirCredito() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        
        try {


        	String sqlInsert = "INSERT INTO Payment "
        			+ "(payment_id, cardName, phoneNumberCardHolder, flagCard, cardNumber, valid, codCard, status) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
    		stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
    		    		
    
    		stm.setString(2, getFlagCard());
    		stm.setInt(   3, getCardNumber());
    		stm.setString(4, getValid());
    		stm.setInt(   5, getCodCard());
    		stm.setString(7, getStatus());
    		stm.execute();
            
    		// Setar id que acabou de ser inserido
    		ResultSet rs = stm.getGeneratedKeys();
    		if (rs.next()) {
    			setPayment_id(rs.getInt(1));
    		}
    		
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
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
    JButton newMovies = new JButton(" BACK");
    JButton mostRented = new JButton("BACK TO MOVIES");
    JButton cSoon = new JButton("CREATE AN ACCOUNT");
    JButton backButton = new JButton("BACK MENU");


    JLabel emailLabel = new JLabel("PHONE NUMBER");
    JTextField emailTextFild = new JTextField();
    JLabel passW = new JLabel("ENTER PASSWORD");

    JPasswordField emailPass = new JPasswordField();

    JButton singIn = new JButton("SING IN");
    JButton singUp = new JButton("SING UP");

    JButton forget = new JButton("FORGOT PASSWORD");

    JLabel background;




    LOGINPAYMENT() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        ImageIcon img = new ImageIcon("src/images/movie.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setSize(1400,788);
        container.add(background);

    }

    LOGINPAYMENT(CA1.EventHandler aThis, boolean b) {
        CA1.actionPerformed(null);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        newMovies.setBounds(100, 10, 300, 100);
        mostRented.setBounds(400, 10, 300, 100);
        cSoon.setBounds(700,10,300,100);
        backButton.setBounds(1000,10,300,100);


        emailLabel.setBounds(700, 200, 170, 50);
        emailLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        emailLabel.setForeground(Color.WHITE);
        emailTextFild.setBounds(980,200,400,50);
        passW.setBounds(700, 250, 400, 50);
        emailPass.setBounds(980, 250, 400, 50);
        passW.setFont(new Font("Calibri", Font.BOLD, 20));
        passW.setForeground(Color.white);

        //emailPass.setBounds(200,100,400,50);

        singIn.setBounds(200,600,250,70);
        singUp.setBounds(200,680,250,70);
        forget.setBounds(1000,690,250,70);

        backButton.setBackground(Color.ORANGE);
        backButton.setOpaque(true);

        setSize(1400, 788);
    }

    public void addComponentsToContainer() {

        container.add(newMovies);
        container.add(mostRented);
        container.add(cSoon);
        container.add(backButton);

        container.add(emailLabel);
        container.add(emailPass);

        container.add(backButton);
        container.add(singIn);
        container.add(emailTextFild);
        container.add(passW);
        container.add(singUp);
        container.add(forget);

    }

    public void addActionEvent() {
        newMovies.addActionListener(this);
        mostRented.addActionListener(this);
        cSoon.addActionListener(this);
        backButton.addActionListener(this);
        singUp.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            CA1 nc = new CA1() {
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == singUp) {
            NCLIENT nc = new NCLIENT() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == singIn) {
            DVDRENT nc = new DVDRENT() {
            };
            nc.setVisible(true);
            dispose();

        }

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Matheus_2019378?useSSL=false", "Matheus_2019378", "2019378");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select phoneNumber, passW from Client where phoneNumber=? and passW=?");


            ResultSet rs = st.executeQuery();
            if (rs.next()) {
//
//                PAYMENTVIEW ah = new PAYMENTVIEW();
//                ah.setVisible(true);
//                dispose();

                JOptionPane.showMessageDialog(newMovies, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(newMovies, "Wrong Username & Password");

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}
