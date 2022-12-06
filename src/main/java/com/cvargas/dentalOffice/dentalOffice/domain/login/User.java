package com.cvargas.dentalOffice.dentalOffice.domain.login;

public class User {
    private int id;
    private Rol rol;
    private String username;
    private String email;
    private String name;
    private String lastName;

    public User(int id, Rol rol, String username) {
        this.id = id;
        this.rol = rol;
        this.username = username;
    }

    public User(int id, Rol rol, String username, String email, String name, String lastName) {
        this.id = id;
        this.rol = rol;
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
