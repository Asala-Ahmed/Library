/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author admin
 */
public class students {
	private int id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contactno;
    private ArrayList<Books> issued;

    public students(int id,String name, String password, String email, String address, String city, String contactno) {
        this.id = id;
    	this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contactno = contactno;
        this.issued = new ArrayList<>();
    }

    students(String name, String password) {
       this.name = name;
        this.password = password; 
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

	public ArrayList<Books> getIssued() {
		return issued;
	}

	public void setIssued(ArrayList<Books> issued) {
		this.issued = issued;
	}
    
	public void issue_book(Books b) {
		if(!this.issued.contains(b) && !(this.issued.size()==3))
			this.issued.add(b);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public boolean has_issued() {
		return !this.issued.isEmpty();
	}
	public void return_book(Books b) {
			
			Iterator<Books> iterator = this.issued.iterator();
			while(iterator.hasNext()) {
				Books temp = iterator.next();
				if(temp.getCallno().equalsIgnoreCase(b.getCallno())) {
					iterator.remove();
				}
			}
		}
	public boolean has_book(Books b) {
		for(Books x : this.issued) {
			if(x.getCallno().equalsIgnoreCase(b.getCallno()))
				return true;
		}
		return false;
	}
   
}
