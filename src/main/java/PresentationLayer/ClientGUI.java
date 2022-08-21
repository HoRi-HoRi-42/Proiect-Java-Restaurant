package PresentationLayer;

import BusinessLayer.*;
import BusinessLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClientGUI implements Observer {

    private GUI wp;
    private JFrame frameClient;
    JComboBox jc;
    JFrame chelner;

    public ClientGUI(GUI wp, Client c, DeliveryService ds, Compositeproduct cp) {
        chelner = new JFrame();
        frameClient = new JFrame("Client");
        frameClient.setVisible(true);
        frameClient.getContentPane().setBackground(new Color(17, 138, 77));
        frameClient.setBounds(200, 50, 1000, 600);
        frameClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();

        final JPanel panel = new JPanel();
        final JPanel panel1 = new JPanel();
        final JPanel panel2 = new JPanel();
        final JPanel panel3 = new JPanel();
        final JPanel panel4 = new JPanel();
        final JPanel panel5 = new JPanel();
        final JPanel panel6 = new JPanel();
        //panel.setBackground(new Color(102, 255, 178));
        frameClient.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JTextPane titlu = new JTextPane();
        titlu.setBackground(new Color(102, 255, 178));
        titlu.setForeground(new Color(0, 0, 0));
        titlu.setFont(new Font("COMIC SANS MS", Font.BOLD, 40));
        titlu.setText("Client");
        titlu.setBounds(60, 35, 250, 250);
        //panel.add(titlu);
        titlu.setEditable(false);


        JButton showMen = new JButton("Arata meniu");
        JButton cautaBtn = new JButton("Cauta");
        JButton addProd = new JButton("Adauga produsul");
        JButton comandaBtn = new JButton("Comanda");
        JButton search = new JButton("Cauta");

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wp.getFramePrincip().setVisible(true);
                frameClient.setVisible(false);
            }
        });
        btnBack.setBounds(800, 50, 100, 30);


        JLabel label1 = new JLabel("Titlu: ");
        JLabel label2 = new JLabel("Rating: ");
        JLabel label3 = new JLabel("Calorii: ");
        JLabel label4 = new JLabel("Proteine: ");
        JLabel label5 = new JLabel("Grasimi: ");
        JLabel label6 = new JLabel("Sodiu: ");
        JLabel label7 = new JLabel("Pret: ");
        JLabel label8 = new JLabel("Ora: ");


        final JTextField tf1 = new JTextField();
        tf1.setColumns(13);
        tf1.setEditable(true);

        final JTextField tf2 = new JTextField();
        tf2.setColumns(13);
        tf2.setEditable(true);

        final JTextField tf3 = new JTextField();
        tf3.setColumns(13);
        tf3.setEditable(true);

        final JTextField tf4 = new JTextField();
        tf4.setColumns(13);
        tf4.setEditable(true);

        final JTextField tf5 = new JTextField();
        tf5.setColumns(13);
        tf5.setEditable(true);

        final JTextField tf6 = new JTextField();
        tf6.setColumns(13);
        tf6.setEditable(true);

        final JTextField tf7 = new JTextField();
        tf7.setColumns(13);
        tf7.setEditable(true);

        final JTextField tf8 = new JTextField();
        tf8.setColumns(13);
        tf8.setEditable(true);


        ArrayList<String> menu = new ArrayList<>();
        menu.add("Select product");
        for (MenuItem prod : ds.getListaProduse()) {
            menu.add(prod.getTitle());
        }
        jc = new JComboBox(menu.toArray());
        jc.setForeground(new Color(60, 234, 230));
        jc.setBackground(new Color(68, 3, 70));


        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(jc.getSelectedItem().toString());
                for (MenuItem prod : ds.getListaProduse()) {
                    if (prod.getTitle().equals(tf1.getText())) {
                        tf1.setText(prod.getTitle());
                        tf2.setText(Float.toString(prod.getRating()));
                    }
                }
            }
        });

        addProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MenuItem prod : ds.getListaProduse()) {
                    if (prod.getTitle().equals(tf1.getText()) && (Float.parseFloat(tf2.getText())) == prod.getRating()) {
                        System.out.println(c.getComenzi().size());
                        c.getComenzi().add(prod);
                    }
                }

                System.out.println(c.getComenzi().toString());
            }
        });

        cautaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


//                String keyWord = tf1.getText();
//                ds.setListaProduse11(ds.getListaProduse());
               // float rating = Float.parseFloat(tf2.getText());
//                int calories = Integer.parseInt(tf3.getText());
//                int protein = Integer.parseInt(tf4.getText());
//                int fat = Integer.parseInt(tf5.getText());
//                int sodium = Integer.parseInt(tf6.getText());
//                float price = Integer.parseInt(tf7.getText());

               /// System.out.println(ds.getListaProduse11().size());

//                if (keyWord != null)
//                    ds.setListaProduse11(ds.searchKeyWord(keyWord));
//                if (rating != 0)
//                    ds.setListaProduse11(ds.searchRating(rating));
//                if (calories != 0)
//                    ds.setListaProduse11(ds.searchCalories(calories));
//                if (protein != 0)
//                    ds.setListaProduse11(ds.searchProtein(protein));
//                if (fat != 0)
//                    ds.setListaProduse11(ds.searchFat(fat));
//                if (sodium != 0)
//                    ds.setListaProduse11(ds.searchSodium(sodium));
//                if (price != 0)
//                    ds.setListaProduse11(ds.searchPrice(price));

//                String result1 = "";
//                System.out.println(ds.getListaProduse11());
//                for (MenuItem m : ds.getListaProduse11()) {
//                    System.out.println(m.toString());
//                    result1 += m.toString() + "\n";
//                }
//                System.out.println(result1);
//
//                JOptionPane.showMessageDialog(frameClient, result1);


            }
        });

        comandaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                c.generareListaComanda();
                int orderId = rand.nextInt();
                String maSinucid = new String();
                maSinucid = String.valueOf(c.getLogin().size());
                Order order = new Order(orderId, data, Integer.parseInt(maSinucid));

//                c.observatu();
                int numar = 1;
                chelner.setVisible(true);
                chelner.getContentPane().setBackground(new Color(17, 138, 77));
                chelner.setBounds(200, 50, 500, 200);
                chelner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JTextField tf = new JTextField();
                tf.setEditable(false);
//                for (MenuItem m :
//                        c.getObs()) {
//                    tf.setText("Comanda" + " a fsot servita");
//                    numar += 1;
//                }
//                System.out.println(c.getObs().toString());
                //tf.setText(c.getObs().toString());
                chelner.add(tf);
                ds.getAlabun().put(order, c.comenzi);

                for (MenuItem prod : c.getComanda()) {
                    if (prod.getTitle().equals(tf1.getText()) && (Float.parseFloat(tf2.getText())) == prod.getRating()) {
                        String textFisier = ("Comanda " + tf1.getText() + " " +
                                " acosta " + prod.getPrice());
                        System.out.println(textFisier);
                        CreatFis fisiernouw=new CreatFis();
                        fisiernouw.scrie("Bon", textFisier);
                    }
                }
                c.comenzi.clear();
            }
        });




        panel1.setLayout(null);
        panel1.add(titlu);
        titlu.setBounds(60, 35, 250, 250);
        //panel1.add(btnBack);
        btnBack.setBounds(800, 50, 100, 30);
        panel1.setBackground(new Color(102, 255, 178));
        panel.add(panel1);

        panel2.setVisible(true);
        panel2.add(showMen);
        panel2.add(cautaBtn);
        panel2.add(addProd);
        panel2.add(btnBack);
        panel2.add(comandaBtn);
        panel2.add(cautaBtn);
        panel2.setLayout(new FlowLayout());
        panel2.setBackground(new Color(102, 255, 178));
        panel.add(panel2);

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
        panel3.setLayout(new FlowLayout());
        panel3.setBackground(new Color(102, 255, 178));
        panel.add(panel3);

        panel6.add(jc);
        panel.add(panel6);
        panel6.setBackground(new Color(102, 255, 178));
        panel.setBackground(new Color(102, 255, 178));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frameClient.setContentPane(panel);
        frameClient.add(btnBack);

    }

    private ArrayList<MenuItem> meniuCloient = new ArrayList<>();

    public void addObserver(MenuItem channel) {
        this.meniuCloient.add(channel);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
