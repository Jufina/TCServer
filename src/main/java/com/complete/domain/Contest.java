package com.complete.domain;

import com.complete.jsonview.ContestView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rina on 25.05.2016.
 */
@Entity
public class Contest implements Serializable {
    @Transient
    private static final long serialVersionUID = -3323225680030341871L;

    @JsonView(ContestView.IdView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContest;

    @JsonView(ContestView.NameView.class)
    private String nameContest;

    private Long duration;
    private Long timeBegin;

    public Long getIdContest() {
        return idContest;
    }

    public void setIdContest(Long idContest) {
        this.idContest = idContest;
    }



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contest") // +Lazy
    private List<Task> tasks = new ArrayList<>();

    public Contest(String nameContest, Long duration) {
        this.nameContest = nameContest;
        this.duration = duration;
    }

    public Contest() {
    }

    public String getNameContest() {
        return nameContest;
    }

    public void setNameContest(String nameContest) {
        this.nameContest = nameContest;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Long timeBegin) {
        this.timeBegin = timeBegin;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "idContest=" + idContest +
                ", nameContest='" + nameContest + '\'' +
                ", duration=" + duration +
                ", timeBegin=" + timeBegin +
                '}';
    }

}
