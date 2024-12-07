package labexam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                     .buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // Create Car object
            Car car = new Car();
            car.setName("Sedan");
            car.setType("Car");
            car.setMaxSpeed(180);
            car.setColor("Red");
            car.setNumberOfDoors(4);

            // Create Truck object
            Truck truck = new Truck();
            truck.setName("Cargo Truck");
            truck.setType("Truck");
            truck.setMaxSpeed(120);
            truck.setColor("Blue");
            truck.setLoadCapacity(10000);

            // Save the objects
            session.save(car);
            session.save(truck);

            session.getTransaction().commit();
            System.out.println("Records inserted successfully!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
