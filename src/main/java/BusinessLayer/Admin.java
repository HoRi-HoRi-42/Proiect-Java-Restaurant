package BusinessLayer;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

import static java.util.stream.Collectors.*;


public class Admin<orders> {
    private static DeliveryService modelulMeu;

    public void readFile(DeliveryService model) throws IOException, ParseException {
               modelulMeu=model;
        String fileName = "D:\\Coader\\TP\\PT2021_6_Bologa_Horatiu_Assignment_4\\products.csv";
        List<String[]> list = new ArrayList<String[]>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.map(line -> line.split("\t\t")).collect(Collectors.toList());
            //stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] l : list) {

        }
    }

    public ArrayList<MenuItem> getArrayBun() {
        return arrayBun;
    }

    public void setArrayBun(MenuItem m) {
        this.arrayBun.add(m);
    }

    static ArrayList<MenuItem> arrayBun = new ArrayList<MenuItem>();

    public static final String delimiter = ",";

    public static void read(DeliveryService model) throws IOException {
        String csvFile = "D:\\Coader\\TP\\PT2021_6_Bologa_Horatiu_Assignment_4\\products.csv";
        File file = new File(csvFile);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempArr;
        List<String> linii = new ArrayList<>();
        while ((line = br.readLine()) != null) {//vector de linii
            linii.add(line);
        }
        br.close();
        // linii.remove(linii.get(0));//elimin headeru

        HashSet<String> listaUnica = new HashSet<>();

        ArrayList<String> listaMare = new ArrayList<>();
        linii.stream().forEach(k ->
        {
            String[] micut = k.split(",");
            listaMare.add(micut[0]);
            listaMare.add(micut[1]);
            listaMare.add(micut[2]);
            listaMare.add(micut[3]);
            listaMare.add(micut[4]);
            listaMare.add(micut[5]);
            listaMare.add(micut[6]);
        });

        MenuItem nou = null;
        for (int i = 0; i < listaMare.size(); i++) {

            String element = listaMare.get(i);
            if (i % 7 == 0) {
                nou = new BaseProdusct();
                nou.setTitle(element);
            }
            if (i % 7 == 1)
                nou.setRating(Float.parseFloat(element));

            if (i % 7 == 2)
                nou.setCalories(Integer.parseInt(element));

            if (i % 7 == 3)
                nou.setProteins(Integer.parseInt(element));

            if (i % 7 == 4)
                nou.setFats(Integer.parseInt(element));

            if (i % 7 == 5)
                nou.setSodium(Integer.parseInt(element));

            if (i % 7 == 6) {
                nou.setPrice(Float.parseFloat(element));
                model.adaugaItemCP(nou);
            }
        }
        int i = 0;


//        for (MenuItem m : model.getListaProduse()) {
//            System.out.println(m);
//            System.out.println(i += 1);
//
//            // listaUnica.add(m);
//        }

        for (MenuItem m : model.getListaProduse()) {
            for (MenuItem m1 : model.getListaProduse()) {
                if (m1.getTitle().equals(m.getTitle()) && model.getListaProduse().indexOf(m) != model.getListaProduse().indexOf(m1) && m.getEsteVizitat() == false) {
                    m1.setEsteVizitat(true);
                    m.setEsteVizitat(true);
                    MenuItem m2 = new BaseProdusct(m.getTitle(), m.getRating(), m.getCalories(), m.getProteins(), m.getSodium(), m.getFats(), m.getPrice());

                    arrayBun.add(m2);
                }
            }
        }
        for (MenuItem m : model.getListaProduse()) {
            if (m.getEsteVizitat() == false) {
                arrayBun.add(m);
            }
        }
        model.getListaProduse().clear();
        model.getListaProduse().addAll(arrayBun);
        System.out.println(arrayBun.size());

        //System.out.println(arrayBun.toString());
    }


    public static void main(String[] args) throws IOException {
        //csv file to read
//        String csvFile = "D:\\Coader\\TP\\PT2021_6_Bologa_Horatiu_Assignment_4\\products.csv";
        DeliveryService d = new DeliveryService();
        Admin.read(d);
    }

    public static void raport1(int hour1, int hour2, DeliveryService delivery) {
        ArrayList<Order> orders = new ArrayList<Order>();
        String result = "";

        orders = (ArrayList<Order>) delivery.getAlabun().keySet().stream().filter(p -> {

            return p.getData().getHours() >= hour1;
        }).filter(m -> {
            return m.getData().getHours() <= hour2;
        }).collect(toList());

        for (Order o : orders) {

            result += o.toString();
        }

        CreatFis.scrie("raport1Disperare", result);
    }


    public static void raport2(int nrMinComandariSameProdus,DeliveryService delivery) {



    }


    public static void raport3(int nr, int price, DeliveryService delivery) {
        ArrayList<String> clients = new ArrayList<String>();
        delivery.getAlabun().keySet().stream().filter(m -> {
            return m.getPrice() >= price;
        }).forEach(c -> {
            ArrayList<Order> order = new ArrayList<Order>();
            order = (ArrayList<Order>) delivery.getAlabun().keySet().stream().filter(p -> {
                if (p.getClientID() == c.getClientID())
                    c.increment();
                return c.getIncr() >= nr;
            });

            clients.add(String.valueOf(c.getClientID()));
        });

        CreatFis.scrie("raport2Disperare", clients.toString());
    }

    public void raport4(int ziuaSpecifica, DeliveryService model) {

    }




}
