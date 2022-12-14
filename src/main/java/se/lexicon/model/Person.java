package se.lexicon.model;

import java.util.Objects;

public class Person {

    //Fields
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;
// Constructors
public Person(int id,String firstName,String lastName,String email){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;

}
//Getters & Setters

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getFirstName(){ return firstName;}

    public void setFirstName(String firstName) {
        if(firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
    this.firstName = firstName;}

    public String getLastName(){ return lastName;}

    public void setLastName(String lastName) {
        if(lastName == null) throw new IllegalArgumentException("LastName cannot be null");
    this.lastName = lastName;}

    public String getEmail() {return email;}

        public void setEmail(String email) {
            if(email == null) throw new IllegalArgumentException("LastName cannot be null");
            this.email = email;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName()) && getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
    }
}
