package com.filmrating.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;


    public Rating() {}

    public Rating(int rating, Film film) {
        this.rating = rating;
        this.film = film;
    }

    public Rating(int id, int rating, Film film) {
        this.id = id;
        this.rating = rating;
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + rating +
                '}';
    }
}

