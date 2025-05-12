package fr.eni.zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.eni.zoo.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ZooTests {

    public static List<Animal> animals;
    public static Address a1;
    public static Address a2;
    public static Address a3;
    public static Employee s1;
    public static Employee s2;
    public static Employee s3;
    public static Employee s4;

    @BeforeAll
    static void init() throws Exception {

        animals = List.of(new Animal(1, "Simba", false, AnimalType.LION),
                new Animal(2, "Coco", true, AnimalType.MONKEY), new Animal(3, "Gerald", false, AnimalType.GIRAFE),
                new Animal(4, "dumbo", true, AnimalType.ELEPHANT));

        a1 = new Address(1, "9", " chemin des bois", "Nantes", "44000");
        a2 = new Address(2, "1", " rue de la forêt", "Rennes", "35000");
        a3 = new Address(3, "2b", " rue Faraday", "Saint Herblain", "44800");

        s1 = new Healer(1, "Dupont", "Daniel", 1800, a1, AnimalType.LION);
        s2 = new Healer(2, "Martin", "Julie", 1750, a2, AnimalType.MONKEY);
        s3 = new Guardian(3, "Dubois", "Sophie", 1600, a3, true);
        s4 = new Guardian(4, "Leclerc", "Jacques", 1700, a3, false);
    }

    @Test
    void animalsToStringTest() {

        for (Animal animal : animals) {
            String expectedString = "Animal [id=" + animal.getId() + ", name=" + animal.getName() + ", isFemale=" + animal.isFemale() + ", type=" + animal.getAnimalType() + "]";
            assertEquals(expectedString, animal.toString());
        }

    }

    @Test
    void AddressToStringTest() {

        List<Address> addressList = new ArrayList<>();
        addressList.add(a1);
        addressList.add(a2);
        addressList.add(a3);

        for (Address address : addressList) {
            String expectedString = "Address [id="+address.getId()+", number="+address.getNumber()+", street="+address.getStreet()+", city="+address.getCity()+", postalCode="+address.getPostalCode()+"]";
            assertEquals(expectedString, address.toString());
        }
    }

    @Test
    void polymorphismTest() {

        List<Employee> tempContacts = new ArrayList<>();
        tempContacts.add(s1);
        tempContacts.add(s2);
        tempContacts.add(s3);
        tempContacts.add(s4);

        for (Employee contact : tempContacts) {
            if (contact.getClass() == Guardian.class) {
                String expectedString = "Guardian [id=" + contact.getId() + ", lastName=" + contact.getLastName() + ", firstName=" + contact.getFirstName() + ", salary=" + contact.getSalary() + "] [nightShift=" + ((Guardian) contact).isNightShift() + "]";
                assertEquals(expectedString, contact.toString());
            }
            if (contact.getClass() == Healer.class) {
                String expectedString = "Healer [id=" + contact.getId() + ", lastName=" + contact.getLastName() + ", firstName=" + contact.getFirstName() + ", salary=" + contact.getSalary() + "] [specialty=" + ((Healer) contact).getSpecialty() + "]";
                assertEquals(expectedString, contact.toString());
            }
        }

    }

}

