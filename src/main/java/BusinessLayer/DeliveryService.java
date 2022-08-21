package BusinessLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import static java.util.stream.Collectors.toList;

public class DeliveryService {
    public void setListaProduse(ArrayList<MenuItem> listaProduse) {
        this.listaProduse = listaProduse;
    }

    private ArrayList<MenuItem> listaProduse = new ArrayList<MenuItem>();

    public ArrayList<MenuItem> getListaProduse11() {
        return listaProduse11;
    }

    public void setListaProduse11(ArrayList<MenuItem> listaProduse11) {
        this.listaProduse11 = listaProduse11;
    }

    private ArrayList<MenuItem> listaProduse11 = new ArrayList<MenuItem>(listaProduse);


    public HashMap<Order, ArrayList<MenuItem>> getAlabun() {
        return alabun;
    }

    public void setAlabun(HashMap<Order, ArrayList<MenuItem>> alabun) {
        this.alabun = alabun;
    }

    private HashMap<Order, ArrayList<MenuItem>> alabun = new HashMap<Order, ArrayList<MenuItem>>();


    /**
     * @param m = un Menu Item care o sa fie inserat in lista de produse
     */
    public void adaugaItemCP(MenuItem m) {
        assert m != null;
        //System.out.println(listaProduse.size());
        this.listaProduse.add(m);
        assert listaProduse != null;
    }

    public void invariant() {
        assert listaProduse.size() != 0;
    }

    /**
     * @param title = titlul sa nu fie null
     * @param c     = lusta sa nu fie nula
     */
    public void adaugaItemCPmod(String title, Compositeproduct c) {
        assert title.length() > 0;

        assert c != null;
        listaProduse.add(c);
        c.setTitle(title);
    }




    public void modifica(MenuItem m, String s, float rating, int calories, int proteins, int fats, int sodium, float price) {
        // System.out.println(m);
        m.setTitle(s);
        m.setRating(rating);
        m.setCalories(calories);
        m.setProteins(proteins);
        m.setFats(fats);
        m.setSodium(sodium);
        m.setPrice(price);
        // System.out.println(m);
    }


    public void adaugaItemBP(MenuItem m) {
        this.listaProduse.add(m);
    }

    public ArrayList<MenuItem> getListaProduse() {
        return listaProduse;
    }


    public ArrayList<MenuItem> searchKeyWord(String KeyWord){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> m.getTitle().contains(KeyWord)).collect(toList());
        return menu;
    }

    public ArrayList<MenuItem> searchRating(Float rating){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> Float.compare(m.getRating(), rating) == 0).collect(toList());
        return menu;
    }


    public ArrayList<MenuItem> searchCalories(int calories){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> m.getCalories() == calories).collect(toList());
        return menu;
    }

    public ArrayList<MenuItem> searchFat(int calories){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> m.getCalories() == calories).collect(toList());
        return menu;
    }

    public ArrayList<MenuItem> searchProtein(int calories){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> m.getCalories() == calories).collect(toList());
        return menu;
    }

    public ArrayList<MenuItem> searchSodium(int calories){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> m.getCalories() == calories).collect(toList());
        return menu;
    }


    public ArrayList<MenuItem> searchPrice(Float rating){

        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) listaProduse11.stream().filter(m -> Float.compare(m.getRating(), rating) == 0).collect(toList());
        return menu;
    }
}
