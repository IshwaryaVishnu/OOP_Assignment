package se.lexicon.model;

import java.util.Objects;

public class AppUser {
    private String username;
    private String password;
     private AppRole role;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null) throw new IllegalArgumentException("username cannot be null");
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null) throw new IllegalArgumentException("password cannot be null");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public AppUser(String username, String password, AppRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return getUsername().equals(appUser.getUsername()) && getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getRole());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
