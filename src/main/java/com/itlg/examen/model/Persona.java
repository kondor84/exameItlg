package com.itlg.examen.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "has_insurance")
    private boolean hasInsurance;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "peliculas_x_persona",
            joinColumns = { @JoinColumn(name = "persona_id") },
            inverseJoinColumns = { @JoinColumn(name = "pelicula_id") })
    private List<Pelicula> favouriteMovies;

    public Persona() {}

    public Persona(String firstName, String lastName, Date birthdate, boolean hasInsurance, List<Pelicula> favouriteMovies) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.hasInsurance = hasInsurance;
        this.favouriteMovies = favouriteMovies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public List<Pelicula> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(List<Pelicula> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }



}
