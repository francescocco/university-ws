package com.francesco.demoprj.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EXAMS")
@SequenceGenerator(name = "EXAMS_SEQUENCE", sequenceName = "EXAMS_SEQUENCE_ID", initialValue = 1, allocationSize = 1)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Exams extends RepresentationModel<Exams> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAMS_SEQUENCE")
    private Integer id;
    @NotNull(message = "exam code can't be null")
    private Integer codiceEsame;
    @NotNull(message = "exam name can't be null")
    private String nomeEsame;
    private String descrizione;
    private String professore;
    private BigDecimal voto;
    private Date data;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Student studente;
    @Transient
    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodiceEsame() {
        return codiceEsame;
    }

    public void setCodiceEsame(Integer codiceEsame) {
        this.codiceEsame = codiceEsame;
    }

    public String getNomeEsame() {
        return nomeEsame;
    }

    public void setNomeEsame(String nomeEsame) {
        this.nomeEsame = nomeEsame;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getProfessore() {
        return professore;
    }

    public void setProfessore(String professore) {
        this.professore = professore;
    }

    public BigDecimal getVoto() {
        return voto;
    }

    public void setVoto(BigDecimal voto) {
        this.voto = voto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Student getStudente() {
        return studente;
    }

    public void setStudente(Student studente) {
        this.studente = studente;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
