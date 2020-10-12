package com.filmrating.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "films")
@Table(name = "films")
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private int release_year;

    @ManyToOne
    @JoinColumn(name = "")

    public Films(){}

    public Films(String title, int release_year) {
        this.title = title;
        this.release_year = release_year;
    }

    public Films(int id, String title, int release_year) {
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
}
