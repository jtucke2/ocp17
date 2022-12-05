package C14IO;

import java.io.*;

class SerializableCar implements Serializable {
    public String make;
    public String model;
    public transient int year = 2000;
    public static long id = 1L;
    private static final long serialVersionUID = 1L;

    {
        year = 2010;
    }

    public SerializableCar() {
        // This no-arg constructor is not called
        int a = 3;
    }

    public SerializableCar(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "SerializableCar{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

public class SerializableFun {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableCar car = new SerializableCar("Ford", "F-150", 2012);
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(output))) {
                objectOutputStream.writeObject(car);
            }
            output.flush();
            byte[] bytes = output.toByteArray();

            try (ByteArrayInputStream input = new ByteArrayInputStream(bytes)) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(
                        new BufferedInputStream(input)
                )) {

                    SerializableCar deserializedCar = (SerializableCar) objectInputStream.readObject();
                    System.out.println(deserializedCar);
                }
            }
        }

    }
}
