package models;

public class UserModel {

    private String name;
    private String email;
    private String job;
    private String password;

    public UserModel(String name, String email, String password, String job) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.job = job;
    }
}
