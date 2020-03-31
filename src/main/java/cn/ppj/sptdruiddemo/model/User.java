package cn.ppj.sptdruiddemo.model;

public class User {
    private int id;
    private String username;
    private String truename;

    public User() {
    }

    public User(int id, String username, String truename) {
        this.id = id;
        this.username = username;
        this.truename = truename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", truename='" + truename + '\'' +
                '}';
    }
}
