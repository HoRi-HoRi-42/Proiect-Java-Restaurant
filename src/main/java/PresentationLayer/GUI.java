package PresentationLayer;

import BusinessLayer.*;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.Exception;
import java.text.ParseException;

public class GUI extends JFrame {
    private JFrame framePrincip;
    private JTable table;
    //JScrollPane sp = new JScrollPane(table);
    //private ClientBLL c;
    JTextArea a = new JTextArea();
    final GUI guiAdm = this;
    Client c;
    DeliveryService ds;
    BaseProdusct bs;
    Admin admClasa;
    Compositeproduct cp;



    public JFrame getFramePrincip() {
        return framePrincip;
    }

    //calling constructor
    public GUI() {

        ds = new DeliveryService();
        c = new Client();
        bs = new BaseProdusct();
        admClasa = new Admin();
        cp = new Compositeproduct();

        JCheckBox cb1 = null, cb2 = null;
        framePrincip = new JFrame("LOGIN");
        framePrincip.setBounds(200, 300, 1100, 200);
        framePrincip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(8, 217, 210));

        framePrincip.getContentPane().add(panel2, BorderLayout.SOUTH);


        JLabel userLabel = new JLabel();
        userLabel.setText("Username");

        JTextField textField1 = new JTextField(15);

        JLabel passLabel = new JLabel();
        passLabel.setText("Password");

        JPasswordField textField2 = new JPasswordField(15);

        panel2.add(userLabel);
        panel2.add(textField1);
        panel2.add(passLabel);
        panel2.add(textField2);

        add(panel2, BorderLayout.CENTER);

        JButton b1 = new JButton("Login");
        JButton b2 = new JButton("Register");


        cb1 = new JCheckBox("Manager");
        cb1.setBounds(100, 100, 150, 20);
        cb2 = new JCheckBox("Client");
        cb2.setBounds(100, 150, 150, 20);
//        cb3=new JCheckBox("Tea @ 10");
//        cb3.setBounds(100,200,150,20);

        b1.setBackground(new Color(192, 192, 192));

        JCheckBox finalCb = cb1;
        JCheckBox finalCb1 = cb2;

        String ana = String.valueOf("");
        String are = String.valueOf("");
        c.setLogin("zz", "ss");
        try {
            admClasa.read(ds);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (finalCb.isSelected() && !finalCb1.isSelected() && textField1.getText().equals(ana) && textField2.getText().equals(are)) {
//                    System.out.println(textField1.getText());
//                    System.out.println(ds.getListaProduse().size());
                    framePrincip.setVisible(false);
                    AdminGui admn = new AdminGui(guiAdm, ds, bs, admClasa, cp);
                } else if (finalCb1.isSelected() && !finalCb.isSelected() && (c.gasire(textField1.getText()) == 1)) {
                    framePrincip.setVisible(false);

                    ClientGUI admn = new ClientGUI(guiAdm, c, ds, cp);
                } else {
                    JOptionPane.showMessageDialog(framePrincip, "Verificati credidentialele sau selectia!!");

                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (finalCb1.isSelected() && !finalCb.isSelected()) {
                    c.setLogin(textField1.getText(), textField2.getText());
                } else {
                    JOptionPane.showMessageDialog(framePrincip, "Register esuat");

                }
            }
        });

        b2.setBackground(new Color(192, 192, 192));
        b2.setBounds(60, 160, 120, 30);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(cb1);
        panel2.add(cb2);

        framePrincip.add(panel2);
        framePrincip.setVisible(true);

    }
}
