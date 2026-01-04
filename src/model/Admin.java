package model;

public class Admin {
    private String name;
    private String email;

    public Admin(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
}
