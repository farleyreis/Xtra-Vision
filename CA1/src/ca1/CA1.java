/**
 *
 * @author farleyreis  & Matheus
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class CA1 extends JPanel {


    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JTextField ta;
    static EventHandler eventHandler;

    public static void  WelcomeWindow() {

        JFrame frame = new JFrame("Xtra-vision -- Video rental kiosk");
        JPanel panel = new JPanel();
        Font font = new Font("Courier", Font.BOLD,20);

        button1 = new JButton("RENT");
        button2 = new JButton("RETURN");
        button3 = new JButton("Xtra-Vision support");
        JLabel tex = new JLabel("Your first Rental  is FREE \n" +
                "Use a coupon code: FREEMOVIE");

        tex.setFont(font);

        eventHandler = new EventHandler();

        button1.addActionListener(eventHandler);
        button2.addActionListener(eventHandler);
        button3.addActionListener(eventHandler);

        JLabel background;

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

   
        frame.setSize(1400, 788);

        //image do back...
        ImageIcon img = new ImageIcon("src/images/movie.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setSize(1400,788);
        panel.add(background);

        background.setVisible(true);

 
        background.add(tex);
        tex.setFont(new Font("Calibri", Font.BOLD, 20));
        tex.setForeground(Color.white);
        tex.setBounds(650,150,700,120);
        background.add(button1);
        button1.setBounds(600,300,300,400);
        background.add(button2);
        button2.setBounds(1000,300,300,400);
        button3.setBounds(50,100,150,50);
         background.add(button3);

        panel.setBorder(BorderFactory.createTitledBorder(""));
        // this should close the frame and open another one, but it must be in the wrong place.
        // but that will solve it.
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class EventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                DVDRENT ps = new DVDRENT();

                ps.setVisible(true);

                //dispose();
            } // here your part .. of button2 SERVICEPROVIDER will enter.
            // my old condition is in the SERVICEPROVIDER class, you can copy all code from the NewCliente class and put it in
            // from SERVICEPROVIDER to have the same design.
            else if (e.getSource() == button2) {
//                PAYMENTVIEW nc = new PAYMENTVIEW();
//                nc.setVisible(true);

            }
            

        }

        private void dispose() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public static void main(String[] args) {

         //this is to open the new windows
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WelcomeWindow();
            }

        });

    }
}
