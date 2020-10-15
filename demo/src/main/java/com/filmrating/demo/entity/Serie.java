package com.filmrating.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private int release_year;

    @OneToMany(mappedBy = "serie",
               cascade = {CascadeType.MERGE, CascadeType.DETACH,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<SerieRating> serieRatings;

    public Serie(){}

    public Serie(String title, int release_year) {
        this.title = title;
        this.release_year = release_year;
    }

    public Serie(int id, String title, int release_year) {
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
        return "Serie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_year=" + release_year +
                ", serieRatings=" + serieRatings +
                '}';
    }

    public List<SerieRating> getRatings() {
        return serieRatings;
    }

    public void setRatings(List<SerieRating> serieRatings) {
        this.serieRatings = serieRatings;
    }

    public void add(SerieRating tempSerieRating){

        if(serieRatings == null) {
            serieRatings = new ArrayList<>();
        }

        serieRatings.add(tempSerieRating);

        tempSerieRating.setSerie(this);
    }
}
