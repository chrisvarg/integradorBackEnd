package com.cvargas.dentalOffice.models;

public class Dentist {

    private int id;
    private String name;
    private String lastName;
    private String license;

    public Dentist() {
    }

    public Dentist(String name, String lastName, String license) {
        this.name = name;
        this.lastName = lastName;
        this.license = license;
    }

    public Dentist(int id, String name, String lastName, String license) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.license = license;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}
