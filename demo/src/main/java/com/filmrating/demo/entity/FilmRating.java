package com.filmrating.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "films_ratings")
public class FilmRating {

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

    public FilmRating() {}

    public FilmRating(int rating, Film film) {
        this.rating = rating;
        this.film = film;
    }

    public FilmRating(int id, int rating, Film film) {
        this.id = id;
        this.rating = rating;
        this.film = film;
    }

    public FilmRating(int rating, Film film, User user) {
        this.rating = rating;
        this.film = film;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmRating() {
        return rating;
    }

    public void setFilmRating(int rating) {
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
        return "FilmRating{" +
                "id=" + id +
                ", rating=" + rating +
                '}';
    }
}

