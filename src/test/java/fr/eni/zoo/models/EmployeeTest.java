package fr.eni.zoo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    private static Address a1;
    private static Address a2;
    private static Address a3;
    private static Employee s1;
    private static Employee s2;
    private static Employee s3;
    private static Employee s4;

    @BeforeAll
    static void init() throws Exception {

        a1 = new Address(1, "9", " chemin des bois", "Nantes", "44000");
        a2 = new Address(2, "1", " rue de la forêt", "Rennes", "35000");
        a3 = new Address(3, "2b", " rue Faraday", "Saint Herblain", "44800");

        s1 = new Healer(1, "Dupont", "Daniel", 1800, a1, AnimalType.LION);
        s2 = new Healer(2, "Martin", "Julie", 1750, a2, AnimalType.MONKEY);
        s3 = new Guardian(3, "Dubois", "Sophie", 1600, a3, true);
        s4 = new Guardian(4, "Leclerc", "Jacques", 1700, a3, false);
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

    @Test
    public void guardianInstanceTest(){
        Address address = new Address();
        Employee employee = new Guardian();
        assertNotNull(employee);
    }

    @Test
    public void healerInstanceTest(){
        Address address = new Address();
        Employee employee = new Healer();
        assertNotNull(employee);
    }

    @Test
    public void guardianConstructorShouldReturnInstanceWithGivenAttributes() {
        Address address = new Address();
        Guardian expectedEmployee = new Guardian();
        expectedEmployee.setId(1);
        expectedEmployee.setFirstName("John");
        expectedEmployee.setLastName("Doe");
        expectedEmployee.setSalary(1600.00);
        expectedEmployee.setAddress(address);
        expectedEmployee.setNightShift(true);
        Guardian employee = new Guardian(1, "John", "Doe", 1600.00, address, true);
        Assertions.assertEquals(expectedEmployee, employee);
    }

    @Test
    public void healerConstructorShouldReturnInstanceWithGivenAttributes() {
        Address address = new Address();
        Healer expectedEmployee = new Healer();
        expectedEmployee.setId(1);
        expectedEmployee.setFirstName("Jane");
        expectedEmployee.setLastName("Doe");
        expectedEmployee.setSalary(1400.00);
        expectedEmployee.setAddress(address);
        expectedEmployee.setSpecialty(AnimalType.GIRAFE);
        Healer employee = new Healer(1, "Jane", "Doe", 1400.00, address, AnimalType.GIRAFE);
        Assertions.assertEquals(expectedEmployee, employee);
    }

}