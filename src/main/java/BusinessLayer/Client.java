package BusinessLayer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {
    Compositeproduct cpc = new Compositeproduct();


    public HashMap<String, String> getLogin() {
        return login;
    }

    public ArrayList<Integer> ore = new ArrayList<Integer>();

    public ArrayList<MenuItem> getComenzi() {
        return comenzi;
    }

    public void setComenzi(MenuItem comenzi) {
        this.comenzi.add(comenzi);
    }

    public ArrayList<MenuItem> comenzi = new ArrayList<MenuItem>();

    public ArrayList<MenuItem> getComanda() {
        return comanda;
    }

    public void setComanda(MenuItem m) {
        this.comanda.add(m);
    }

    public ArrayList<MenuItem> comanda = new ArrayList<MenuItem>();


    private HashMap<String, String> login = new HashMap<String, String>();

    public void setLogin(String zz, String ss) {
        this.login.put(zz, ss);
    }

    public int gasire(String a) {
        for (int i = 0; i < login.size(); i++) {
            if (login.containsKey(a)) return 1;
        }
        return 0;
    }

//    public ArrayList<MenuItem> getObs() {
//        return comandaW;
//    }
//
//    public void observatu() {
//        comandaW.addAll(comanda);
//    }

    public float generareListaComanda() {
        float pret_compprod = 0;
        String nume = new String();


        for (MenuItem ana : comenzi) {
            pret_compprod += ana.getPrice();
            nume += ana.getTitle();
            nume += ',';
        }

        float f = comenzi.get(0).getRating();

        MenuItem m = new BaseProdusct(nume, f, comenzi.get(0).getCalories(), comenzi.get(0).getProteins(), comenzi.get(0).getFats(), (int) f, pret_compprod);

        comanda.add(m);

        System.out.println("gencom" + comanda.size());
        //observatu();
        return pret_compprod;
        //  System.out.println(nume);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    /*public HashMap<Order, ArrayList<MenuItem>> creareComanda(Order orders){
        float price = generareListaComanda();
        orders.setPrice(price);
        delivery.getAlabun().put(orders, comanda);

        return delivery.getAlabun();
    }*/






}
