package fr.eni.zoo;

public class Address {

    int id;
    String number;
    String street;
    String city;
    String postalCode;

    public Address(int id, String number, String street, String city, String postalCode) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address [id=" + getId() + ", number=" + getNumber() + ", street=" + getStreet() + ", city=" + getCity() + ", postalCode=" + getPostalCode() + "]";
    }

}
