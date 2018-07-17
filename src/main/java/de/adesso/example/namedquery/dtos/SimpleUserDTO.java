package de.adesso.example.namedquery.dtos;

public class SimpleUserDTO {

    private String username;
    private String mail;

    public SimpleUserDTO(String username, String mail) {
        this.username = username;
        this.mail = mail;
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
        return "SimpleUserDTO{" +
                "username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
