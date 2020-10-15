package com.filmrating.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "series_ratings")
public class SerieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    public SerieRating() {}

    public SerieRating(int rating, Serie serie) {
        this.rating = rating;
        this.serie = serie;
    }

    public SerieRating(int id, int rating, Serie serie) {
        this.id = id;
        this.rating = rating;
        this.serie = serie;
    }

    public SerieRating(int rating, Serie serie, User user) {
        this.rating = rating;
        this.serie = serie;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerieRating() {
        return rating;
    }

    public void setSerieRating(int rating) {
        this.rating = rating;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SerieRating{" +
                "id=" + id +
                ", rating=" + rating +
                '}';
    }
}

