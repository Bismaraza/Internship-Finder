package model;

public class Employer {
    private String name;
    private String company;
    private String email;

    public Employer(String name, String company, String email) {
        this.name = name;
        this.company = company;
        this.email = email;
    }

    public String getName() { return name; }
    public String getCompany() { return company; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setCompany(String company) { this.company = company; }
}
