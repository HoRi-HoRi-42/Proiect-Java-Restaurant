package BusinessLayer;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int orderID;
    private int clientID;
    private Date data;
    private int incr = 0;
    private float price;

    public Order(int id, Date date, int clientID) {
        this.orderID = id;
        this.data = date;
        this.clientID = clientID;
        this.price = 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setIncr(int incr) {
        this.incr = incr;
    }

    public int getIncr(){
        return incr;
    }

    public int increment(){
        incr++;
        return incr;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", data=" + data +
                ", incr=" + incr +
                ", price=" + price +
                '}';
    }
}
