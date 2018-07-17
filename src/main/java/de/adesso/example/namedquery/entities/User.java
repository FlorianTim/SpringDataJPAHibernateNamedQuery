package de.adesso.example.namedquery.entities;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "User.seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(generator = "User.seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstname;
    private String lastname;
    private String username;
    private String mail;


    public User() {
    }

    public User(String firstname, String lastname, String username, String mail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
