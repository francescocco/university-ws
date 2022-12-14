package com.francesco.demoprj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
@SequenceGenerator(name = "STUDENTS_SEQUENCE", sequenceName = "STUDENTS_SEQUENCE_ID", initialValue = 1, allocationSize = 1)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student extends RepresentationModel<Student> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_SEQUENCE")
    private Integer id;
    @Digits(integer = 10, fraction = 3, message = "matricola is wrong!")
    @NotNull(message = "matricola can't be null")
    private Integer matricola;
    @Size(min = 5, max = 20, message = "Is too long")
    @NotNull(message = "the name can't be null")
    private String name;
    @Size(min = 5, max = 20, message = "Is too long")
    @NotNull(message = "The surname can't be null")
    private String surname;
    private String corso;
    private String città;
    private String indirizzo;
    private Date dataDiNascita;

    @OneToMany(mappedBy = "studente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Exams> exams;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
