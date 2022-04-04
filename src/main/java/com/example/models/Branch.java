package com.example.models;

public class Branch {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private Manager manager;

    public Branch() {

    }

    public Branch(Long id, String name, String phone, String address, Manager manager) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.manager = manager;
    }

    public Branch(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
