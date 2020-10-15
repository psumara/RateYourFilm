package com.filmrating.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.MERGE, CascadeType.DETACH,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<FilmRating> filmRatings;

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.MERGE, CascadeType.DETACH,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<SerieRating> serieRatings;

    public User(){}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", filmRatings=" + filmRatings +
                ", serieRatings=" + serieRatings +
                '}';
    }

    public List<FilmRating> getFilmRatings() {
        return filmRatings;
    }

    public void setFilmRatings(List<FilmRating> filmRatings) {
        this.filmRatings = filmRatings;
    }

    public List<SerieRating> getSerieRatings() {
        return serieRatings;
    }

    public void setSerieRatings(List<SerieRating> serieRatings) {
        this.serieRatings = serieRatings;
    }


    public void addFilm(FilmRating tempFilmRating){

        if(filmRatings == null) {
            filmRatings = new ArrayList<>();
        }

        filmRatings.add(tempFilmRating);

        tempFilmRating.setUser(this);
    }

    public void addSerie(SerieRating tempSerieRating){

        if(serieRatings == null) {
            serieRatings = new ArrayList<>();
        }

        serieRatings.add(tempSerieRating);

        tempSerieRating.setUser(this);
    }
}
