/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author admin
 */
public class librarians {
    private String name;
    private String password;
    private String Id;
    private String email;
    private String address;
    private String city;
    private String contactno;

    public librarians(String name, String password, String Id, String email, String address, String city, String contactno) {
        this.name = name;
        this.password = password;
        this.Id = Id;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contactno = contactno;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    librarians(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getContactno() {
        return contactno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
    
    
    
}

