package model;

public class User {
    private String name;
    private String email;
    private String password;
    private String skill;

    public User(String name, String email, String password, String skill) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.skill = skill;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getSkill() { return skill; }

    public void setName(String name) { this.name = name; }
    public void setSkill(String skill) { this.skill = skill; }
}
