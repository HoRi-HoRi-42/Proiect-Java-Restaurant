package DataLayer;

import java.io.*;

public class Serializare implements Serializable {

    // Emp object = new Emp("ab", 20, 2, 1000);
    private static String filename = "shubham.txt";

    public static void serializare() {
        try {

            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            // Method for serialization of object
            //out.writeObject(object);

            out.close();
            file.close();


            // value of static variable changed
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }


    }


    public static void deserializare() {
        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            // object = (Emp)in.readObject();

            in.close();
            file.close();


            // System.out.println("z = " + object1.z);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }
}
