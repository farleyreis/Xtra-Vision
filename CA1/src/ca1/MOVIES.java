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

public class MOVIES extends JFrame implements ActionListener {

    Container container = getContentPane();
    JButton newMovies = new JButton("NEW MOVIES");
    JButton mostRented = new JButton("MOST RENTED");
    JButton cSoon = new JButton("COMMING SOON");
    JButton backButton = new JButton("BACK MENU");
    JLabel background;



          

    
    MOVIES() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        ImageIcon img = new ImageIcon("src/images/movie.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setSize(1400,788);
        container.add(background);

    }
    

    MOVIES(CA1.EventHandler aThis, boolean b) {
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

        backButton.setBackground(Color.ORANGE);
        backButton.setOpaque(true);

        setSize(1400, 788);
    }

    public void addComponentsToContainer() {

        container.add(newMovies);
        container.add(mostRented);
        container.add(cSoon);
        container.add(backButton);
        

  
    //container.setLayout(new GridLayout(3,3));
    }

    public void addActionEvent() {
        newMovies.addActionListener(this);
        mostRented.addActionListener(this);
        cSoon.addActionListener(this);
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            CA1 nc = new CA1() {
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == cSoon) {
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

//                CONTROLLER ah = new CONTROLLER();
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
