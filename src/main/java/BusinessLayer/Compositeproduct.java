package BusinessLayer;

import java.util.ArrayList;

public class Compositeproduct extends MenuItem {

    public void addds (DeliveryService d){
        d.adaugaItemCP(ghita.get(0));
    }
    public ArrayList<BaseProdusct> getGhita() {
        return ghita;
    }

    public void setGhita(BaseProdusct ss) {
       this.ghita.add(ss);
    }

    ArrayList<BaseProdusct> ghita = new ArrayList<BaseProdusct>();

    public Compositeproduct(String title, float rating, int calories, int proteins, int fats, int sodium, float price) {
        super(title, rating, calories, proteins, fats, sodium, price);
    }
    public Compositeproduct() {

    }

    public void generareNume(){
        String ss = new String();
        for (MenuItem x: getGhita()
             ) {
            ss += x.getTitle();
        }
    }

    @Override
    public void computeAtributes() {
        float pret_compprod = 0;
        int calorii = 0;
        float rating = 0;
        int proteine = 0;
        int sodiu = 0;
        int gras = 0;

        for (BaseProdusct ana : ghita) {
            pret_compprod += ana.getPrice();
        }
        this.setPrice(pret_compprod);

        for (BaseProdusct ana : ghita) {
            calorii += ana.getCalories();
        }
        this.setCalories(calorii);

        for (BaseProdusct ana : ghita) {
            rating += ana.getRating();
        }
        this.setRating(rating);

        for (BaseProdusct ana : ghita) {
            proteine += ana.getPrice();
        }
        this.setProteins(proteine);

        for (BaseProdusct ana : ghita) {
            sodiu += ana.getSodium();
        }
        this.setSodium(sodiu);

        for (BaseProdusct ana : ghita) {
            gras += ana.getFats();
        }
        this.setFats(gras);
    }

}
