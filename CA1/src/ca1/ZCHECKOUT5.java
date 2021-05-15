




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


public class ZCHECKOUT5 extends JFrame implements ActionListener {
    
    

    Container container = getContentPane();
    JButton addBasket = new JButton("NEW MOVIES");
    JButton backToMovies = new JButton("MOST RENTED");
    JButton creat_an_account = new JButton("CREATE AN ACCOUNT");
    JButton backButton = new JButton("BACK MENU");
    //JButton checkoutButton = new JButton("CHECKOUT");
    JButton cancelButton = new JButton("CANCEL");
    JButton checkout = new JButton("CHECKOUT");
    JLabel background;
JTextArea textArea = new JTextArea(
    "Only a few years after the all-out guerrilla war in First Blood (1982), John Rambo's former commanding officer, Colonel Sam Trautman, pulls him out of jail, only to send him back to a place he swore never to return: the impenetrable jungles of Vietnam. Entrusted with the dangerous task of collecting evidence that American POWs are still being held captive, Rambo agrees to infiltrate the unknown zone, and before long, he finds himself double-crossed, marooned behind the enemy lines. Once, John fought for his country. Now, the government has left him for dead in a Soviet-infested land. Can Rambo fulfil his suicide mission? Will he deliver his lethal justice? Written by Nick Riganas"
);

    

     JButton choise2 = new JButton();






    ZCHECKOUT5() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
//I cound not get the images from the database, i don't know whats happened but, walways when we tried to get an erro display then we changed for the button.
        ImageIcon img = new ImageIcon("src/images/movie.jpg");

        choise2.setIcon(new ImageIcon("src/images/m6.jpg"));


        background = new JLabel("",img,JLabel.CENTER);
        background.setSize(1400,810);
        container.add(background);
//        container.add(choise1);
//        container.add(choise2);
//        
//        validate();
        

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        addBasket.setBounds(100, 10, 300, 100);
        backToMovies.setBounds(400, 10, 300, 100);
        creat_an_account.setBounds(700,10,300,100);
        backButton.setBounds(1000,10,300,100);
        textArea.setBounds(700, 200, 500,300);
        cancelButton.setBounds(50,700,200,50);
        checkout.setBounds(700,700,200,50);
               
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
  
        choise2.setBounds(295,110,240,350);

        
        

        backButton.setBackground(Color.ORANGE);
        backButton.setOpaque(true);

        setSize(1400, 820);
    }

    public void addComponentsToContainer() {

        container.add(addBasket);
        container.add(backToMovies);
        container.add(creat_an_account);
        container.add(backButton);
        container.add(textArea);
        container.add(cancelButton);
        container.add(checkout);
        
    
        container.add(choise2);


        
    }

    public void addActionEvent() {
        addBasket.addActionListener(this);
        backToMovies.addActionListener(this);
        creat_an_account.addActionListener(this);
        backButton.addActionListener(this);
        //checkoutButton.addActionListener(this);
        cancelButton.addActionListener(this);
        checkout.addActionListener(this);

    }

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
        if (e.getSource() == checkout) {
            LOGINPAYMENT nc = new LOGINPAYMENT() {
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == cancelButton) {
            DVDRENT nc = new DVDRENT() {
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
