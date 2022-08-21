package PresentationLayer;

import BusinessLayer.*;
import BusinessLayer.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminGui {
    private GUI wp;
    private JFrame frameAdmin;
    private JTable table;
    private JComboBox c;

    public AdminGui(GUI wp, DeliveryService ds, BaseProdusct b, Admin adminClas, Compositeproduct cp) {
        frameAdmin = new JFrame("Administrator");
        frameAdmin.getContentPane().setBackground(new Color(8, 167, 171));
        frameAdmin.setBounds(20, 50, 1400, 600);
        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();


        final JPanel panel = new JPanel();
        final JPanel panel1 = new JPanel();
        final JPanel panel2 = new JPanel();
        final JPanel panel3 = new JPanel();
        final JPanel panel4 = new JPanel();
        final JPanel panel5 = new JPanel();
        final JPanel panel6 = new JPanel();
        // frameAdmin.getContentPane().add(panel, BorderLayout.CENTER);
        // panel.setLayout(null);

        panel.setBackground(new Color(8, 167, 171));


        JTextPane titlu = new JTextPane();
        titlu.setBackground(new Color(8, 167, 171));
        titlu.setForeground(new Color(0, 0, 0));
        titlu.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        titlu.setText("Admin");
        titlu.setBounds(60, 35, 250, 250);
        panel.add(titlu);
        titlu.setEditable(false);

        JLabel label11 = new JLabel("Nume Memniu Compus: ");
        JLabel label1 = new JLabel("Nume: ");
        JLabel label2 = new JLabel("Rating: ");
        JLabel label3 = new JLabel("Calorii: ");
        JLabel label4 = new JLabel("Proteine: ");
        JLabel label5 = new JLabel("Grasimi: ");
        JLabel label6 = new JLabel("Sodiu: ");
        JLabel label7 = new JLabel("Pret: ");
        JLabel label8 = new JLabel("Ora St: ");
        JLabel label9 = new JLabel("Ora Fin: ");

        final JTextField tf11 = new JTextField();
        tf11.setColumns(10);
        tf11.setEditable(true);


        final JTextField tf1 = new JTextField();
        tf1.setColumns(10);
        tf1.setEditable(true);

        final JTextField tf2 = new JTextField();
        tf2.setColumns(10);
        tf2.setEditable(true);

        final JTextField tf3 = new JTextField();
        tf3.setColumns(10);
        tf3.setEditable(true);

        final JTextField tf4 = new JTextField();
        tf4.setColumns(10);
        tf4.setEditable(true);

        final JTextField tf5 = new JTextField();
        tf5.setColumns(10);
        tf5.setEditable(true);

        final JTextField tf6 = new JTextField();
        tf6.setColumns(10);
        tf6.setEditable(true);

        final JTextField tf7 = new JTextField();
        tf7.setColumns(10);
        tf7.setEditable(true);

        final JTextField tf8 = new JTextField();
        tf8.setColumns(10);
        tf8.setEditable(true);

        final JTextField tf9 = new JTextField();
        tf9.setColumns(10);
        tf9.setEditable(true);

        ///this.devserv=null;


//        table = new JTable();
//        table.setModel(new DefaultTableModel
//                (
//                        new Object[][]
//                                {
//
//                                },
//                        new String[]
//                                {
//                                        "title",
//                                        "rating"
//                                        , "calories"
//                                        , "proteins"
//                                        , "fats"
//                                        , "sodium"
//                                        , "price"
//
//                                }));
//        table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//        table.setBounds(60, 400, 650, 100);
//        //JScrollPane sp = new JScrollPane(table);
//        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//
//        for (BaseProdusct basePr : MenuItem) {
//            int title = bs.get();
//            int rating = cmd.getIDProdus();
//            int calories = cmd.getIDClient();
//            int fats = cmd.getCantitate();
//            float pret = cmd.getPret();
//
//            tableModel.addRow(new Object[]{id, idProd, idCl, cant});
//
//        }
//
//        JScrollPane sp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        panel6.removeAll();
//        panel6.add(sp);
//        table.repaint();
//        sp.repaint();
//        panel6.repaint();
//        panel6.revalidate();

        JButton update = new JButton("Update Item");
        JButton insertBP = new JButton("Ins Item");
        JButton delete = new JButton("Delete Item");
        JButton meniu = new JButton("Meniu");
        JButton adaugamen = new JButton("Adauga meniu");
        JButton afisare = new JButton("Afiseaza produsul");
        JButton rap1 = new JButton("Raport1");
        JButton rap2 = new JButton("Raport2");
        JButton rap3 = new JButton("Raport3");
        JButton rap4 = new JButton("Raport4");


//        JList<String> lista = new JList<String>(ds.getListaProduse());


        afisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MenuItem m : ds.getListaProduse()) {
                    if (m.getTitle().equals(tf1.getText())) JOptionPane.showMessageDialog(frameAdmin, m.toString());
//                    else System.out.println("eww");
//                    System.out.println(ds.getListaProduse().size());
                }
            }
        });
        insertBP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float f = Float.parseFloat(tf2.getText());
                float f1 = Float.parseFloat(tf7.getText());
                BaseProdusct m = new BaseProdusct(tf1.getText(), f, Integer.parseInt(tf3.getText()), Integer.parseInt(tf4.getText()),
                        Integer.parseInt(tf5.getText()), Integer.parseInt(tf6.getText()), f1);
                System.out.println(m);
                ds.adaugaItemCP(m);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float f = Float.parseFloat(tf2.getText());
                float f1 = Float.parseFloat(tf7.getText());
                for (MenuItem nume : ds.getListaProduse()) {
                    if (tf1.getText().equals(nume.getTitle()))
                        ds.modifica(nume, tf1.getText(), f, Integer.parseInt(tf3.getText()), Integer.parseInt(tf4.getText()),
                                Integer.parseInt(tf5.getText()), Integer.parseInt(tf6.getText()), f1);
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float f = Float.parseFloat(tf2.getText());
                float f1 = Float.parseFloat(tf7.getText());
                int index = 1;
                for (MenuItem nume : ds.getListaProduse()) {
                    if (tf1.getText().equals(nume.getTitle())) {
                        ds.getListaProduse().remove(nume);
                    }

                }

            }
        });

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Select product");
        for (MenuItem prod : ds.getListaProduse()) {
            menu.add(prod.getTitle());
        }
        c = new JComboBox(menu.toArray());
        c.setForeground(new Color(60, 234, 230));
        c.setBackground(new Color(68, 3, 70));

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf11.setText(c.getSelectedItem().toString());
                for (MenuItem prod : ds.getListaProduse()) {
                    if (prod.getTitle().equals(tf11.getText())) {
                        tf11.setText(prod.getTitle());
                        // System.out.println(Float.toString(prod.getRating()));
                        tf2.setText(Float.toString(prod.getRating()));
                    }
                }
                menu.clear();
                for (MenuItem prod : ds.getListaProduse()) {
                    menu.add(prod.getTitle());
                }
                c = new JComboBox(menu.toArray());

            }
        });
        meniu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = c.getSelectedIndex() - 1;
                for (MenuItem b :
                        ds.getListaProduse()) {

                    if (b.getTitle().equals(tf11.getText()) && ((Float.parseFloat(tf2.getText())) == b.getRating()))
                        cp.setGhita((BaseProdusct) b);
                }
                System.out.println(cp.getGhita().toString());

                menu.clear();
                for (MenuItem prod : ds.getListaProduse()) {
                    menu.add(prod.getTitle());
                }
                c = new JComboBox(menu.toArray());

            }
        });

        rap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr1= Integer.parseInt(tf8.getText());
                int nr2= Integer.parseInt(tf9.getText());

                adminClas.raport1(nr1,nr2, ds);
            }
        });

        rap3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminClas.raport3(1,12,ds);
            }
        });
        rap2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminClas.raport2(1,ds);
            }
        });
        rap4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminClas.raport4(1,ds);
            }
        });

        adaugamen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf1.getText().length() > 0) {
                    cp.setTitle(tf11.getText());
                    System.out.println("adamen" + cp.getGhita());
                    System.out.println(cp.getGhita().size());
                    cp.computeAtributes();

                    System.out.println(ds.getListaProduse().size());
                    ds.adaugaItemCPmod(tf1.getText(), cp);
                    System.out.println(ds.getListaProduse().size());

                    //     System.out.println(cp.getGhita().size());
                    // System.out.println(cp);
//                    ds.adaugaItemCP(cp);
//                    System.out.println(ds.getListaProduse().size());
//                    cp.getGhita().clear();
                } else
                    JOptionPane.showMessageDialog(frameAdmin, "da titlu");
                menu.clear();
                for (MenuItem prod : ds.getListaProduse()) {
                    menu.add(prod.getTitle());
                }
                c = new JComboBox(menu.toArray());

            }
        });


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wp.getFramePrincip().setVisible(true);
                frameAdmin.setVisible(false);
            }
        });
        btnBack.setBounds(800, 50, 100, 30);

        panel1.add(titlu);
        /// panel1.add(btnBack);
        panel1.setBackground(new

                Color(8, 167, 171));
        panel.add(panel1);

        panel2.setVisible(true);
        panel2.add(update);
        panel2.add(insertBP);
        panel2.add(delete);
        panel2.add(btnBack);
        panel2.add(afisare);
        panel2.add(meniu);
        panel2.add(adaugamen);
        panel2.add(rap1);
        panel2.add(rap2);
        panel2.add(rap3);
        panel2.add(rap4);

        panel2.setLayout(new

                FlowLayout());
        panel2.setBackground(new

                Color(8, 167, 171));
        panel.add(panel2);

        panel3.add(label11);
        panel3.add(tf11);
        panel3.add(label1);
        panel3.add(tf1);
        panel3.add(label2);
        panel3.add(tf2);
        panel3.add(label3);
        panel3.add(tf3);
        panel3.add(label4);
        panel3.add(tf4);
        panel3.add(label5);
        panel3.add(tf5);
        panel3.add(label6);
        panel3.add(tf6);
        panel3.add(label7);
        panel3.add(tf7);
        panel3.add(label8);
        panel3.add(tf8);
        panel3.add(label9);
        panel3.add(tf9);

        panel3.setLayout(new

                FlowLayout());
        panel3.setBackground(new

                Color(8, 167, 171));
        panel.add(panel3);
        panel4.add(c);
        panel.add(panel4);


        panel.add(btnBack);


        frameAdmin.add(panel);
        //frameAdmin.add(panel2);
        //frameAdmin.add(panel4);
        // frameAdmin.add(panel6);

        frameAdmin.setVisible(true);
    }
}
