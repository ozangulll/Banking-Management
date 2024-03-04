package model;

public class Customer {
    private int Userid;
    private String name;
    private String address;
    private String city;

    public Customer(int Userid, String name, String address, String city) {
        this.setUserid(Userid);
        this.setName(name);
        this.setAddress(address);
        this.setCity(city);

    }

    public Customer() {

    }

    public Customer(int id, String branch, String balance) {
    }


    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
