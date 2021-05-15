
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

public class DVDRENT extends JFrame implements ActionListener {
    
    

    Container container = getContentPane();
    JButton addBasket = new JButton("NEW MOVIES");
    JButton backToMovies = new JButton("RENTED");
    JButton creat_an_account = new JButton("CREATE AN ACCOUNT");
    JButton backButton = new JButton("BACK MENU");
    JButton checkoutButton = new JButton("CHECKOUT");
    JButton cancelButton = new JButton("CANCEL");
    JLabel background;
    
     JButton choise1 = new JButton();
     JButton choise2 = new JButton();
     JButton choise3 = new JButton();
     JButton choise4 = new JButton();
     JButton choise5 = new JButton();
     JButton choise6 = new JButton();
     JButton choise7 = new JButton();
     JButton choise8 = new JButton();
     JButton choise9 = new JButton();
     JButton choise10 = new JButton();





    DVDRENT() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
//I cound not get the images from the database, i don't know whats happened but, walways when we tried to get an erro display then we changed for the button.
        ImageIcon img = new ImageIcon("src/images/movie.jpg");
        choise1.setIcon(new ImageIcon("src/images/m1.jpg"));
        choise2.setIcon(new ImageIcon("src/images/m2.jpg"));
        choise3.setIcon(new ImageIcon("src/images/m3.jpg"));
        choise4.setIcon(new ImageIcon("src/images/m4.jpg"));
        choise5.setIcon(new ImageIcon("src/images/m5.jpg"));
        choise6.setIcon(new ImageIcon("src/images/m6.jpg"));
        choise7.setIcon(new ImageIcon("src/images/m7.jpg"));
        choise8.setIcon(new ImageIcon("src/images/m8.jpg"));
        choise9.setIcon(new ImageIcon("src/images/m9.jpg"));
        choise10.setIcon(new ImageIcon("src/images/m10.jpg"));

        background = new JLabel("",img,JLabel.CENTER);
        background.setSize(1400,810);
        container.add(background);
//        container.add(choise1);
//        container.add(choise2);
//        
//        validate();
        

    }

    DVDRENT(CA1.EventHandler aThis, boolean b) {
        CA1.actionPerformed(null);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        addBasket.setBounds(100, 10, 300, 100);
        backToMovies.setBounds(400, 10, 300, 100);
        creat_an_account.setBounds(700,10,300,100);
        backButton.setBounds(1000,10,300,100);
        checkoutButton.setBounds(50, 650, 200,50);
        cancelButton.setBounds(50,700,200,50);
               
        choise1.setBounds(25,110,240,350);    
        choise2.setBounds(295,110,240,350);
        choise3.setBounds(565,110,240,350);    
        choise4.setBounds(835,110,240,350);
        choise5.setBounds(1105,110,240,350); 
        
        //choise6.setBounds(25,460,240,350);
        choise7.setBounds(295,460,240,350);    
        choise8.setBounds(565,460,240,350);
        choise9.setBounds(835,460,240,350);    
        choise10.setBounds(1105,460,240,350);
        
        

        backButton.setBackground(Color.ORANGE);
        backButton.setOpaque(true);

        setSize(1400, 820);
    }

    public void addComponentsToContainer() {

        container.add(addBasket);
        container.add(backToMovies);
        container.add(creat_an_account);
        container.add(backButton);
        container.add(checkoutButton);
        container.add(cancelButton);
        container.add(choise1);
        container.add(choise2);
        container.add(choise3);
        container.add(choise4);
        container.add(choise5);
        container.add(choise6);
        container.add(choise7);
        container.add(choise8);
        container.add(choise9);
        container.add(choise10);

        
    }

    public void addActionEvent() {
        addBasket.addActionListener(this);
        backToMovies.addActionListener(this);
        creat_an_account.addActionListener(this);
        backButton.addActionListener(this);
        checkoutButton.addActionListener(this);
        cancelButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBasket) {
//            PAYMENTVIEW nc = new PAYMENTVIEW() {
//            };
//            nc.setVisible(true);
//            dispose();

        }
        if (e.getSource() == backToMovies) {
            RENTEDDISPLAY nc = new RENTEDDISPLAY() {
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == creat_an_account) {
            NCLIENT nc = new NCLIENT() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == backButton) {
            CA1 nc = new CA1() {
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == checkoutButton) {
            LOGINPAYMENT nc = new LOGINPAYMENT() {
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == cancelButton) {
            CA1 nc = new CA1() {
            };
            nc.setVisible(true);
            dispose();

        }

        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Matheus_2019378?useSSL=false", "Matheus_2019378", "2019378");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select email, password from user where email=? and password=?");


            ResultSet rs = st.executeQuery();
            if (rs.next()) {
//
//                CONTROLLER ah = new CONTROLLER();
//                ah.setVisible(true);
//                dispose();

                JOptionPane.showMessageDialog(addBasket, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(addBasket, "Wrong Username & Password");

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}
