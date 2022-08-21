package BusinessLayer;

public class BaseProdusct extends MenuItem {

    public BaseProdusct() {
        super();
    }

    @Override
    public void computeAtributes() {
        this.getPrice();
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + getTitle() + '\'' +
                ", rating=" + getRating() +
                ", calories=" + getCalories() +
                ", proteins=" + getProteins() +
                ", fats=" + getFats() +
                ", sodium=" + getSodium() +
                ", price=" + getPrice() +
                '}';
    }

    public BaseProdusct(String title, Float rating, int calories, int protein, int fat, int sodium, float price) {
        super(title,rating,calories,protein,fat,sodium,price);
    }
}
