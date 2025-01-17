package com.filmrating.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private int release_year;

    @OneToMany(mappedBy = "film",
               cascade = {CascadeType.MERGE, CascadeType.DETACH,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<FilmRating> filmRatings;

    public Film(){}

    public Film(String title, int release_year) {
        this.title = title;
        this.release_year = release_year;
    }

    public Film(int id, String title, int release_year) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_year=" + release_year +
                '}';
    }

    public List<FilmRating> getRatings() {
        return filmRatings;
    }

    public void setRatings(List<FilmRating> filmRatings) {
        this.filmRatings = filmRatings;
    }

    public void add(FilmRating tempFilmRating){

        if(filmRatings == null) {
            filmRatings = new ArrayList<>();
        }

        filmRatings.add(tempFilmRating);

        tempFilmRating.setFilm(this);
    }
}
