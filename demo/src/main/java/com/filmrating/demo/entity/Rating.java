package com.filmrating.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ratings")
@Table(name = "ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rating")
    private int rating;

    @ManyToMany
    @PrimaryKeyJoinColumn(name = "user_id")
    private Set<Users> users = new HashSet<>();

    @ManyToMany
    @PrimaryKeyJoinColumn(name = "film_id")
    private Set<Films> movies = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Films films;

    public Ratings() {
    }

    public Ratings(int id, int rating, Set<Users> users, Set<Films> movies, Films films) {
        this.id = id;
        this.rating = rating;
        this.users = users;
        this.movies = movies;
        this.films = films;
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

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Set<Films> getMovies() {
        return movies;
    }

    public void setMovies(Set<Films> movies) {
        this.movies = movies;
    }

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "id=" + id +
                ", rating=" + rating +
                ", users=" + users +
                ", movies=" + movies +
                ", films=" + films +
                '}';
    }
}

