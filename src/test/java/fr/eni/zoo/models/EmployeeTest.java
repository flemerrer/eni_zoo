package fr.eni.zoo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

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