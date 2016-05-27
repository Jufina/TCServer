package com.complete.domain;

import com.complete.jsonview.ContestView;
import com.complete.jsonview.SolutionView;
import com.complete.jsonview.TaskView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rina on 25.05.2016.
 */
@Entity
public class Task implements Serializable {
    @Transient
    private static final long serialVersionUID = -3323245682030341871L;

    @JsonView(TaskView.IdView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTask;
    @JsonView(TaskView.NameView.class)
    private String nameTask;
    @JsonView(TaskView.DecriptionView.class)
    private String description;
    @JsonView(TaskView.NoteView.class)
    private String note; // Необязательное


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Contest.class)
    @JsonView(ContestView.class)
    private Contest contest;

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task") // +Lazy
    private List<Solution> solutions = new ArrayList<>();

    public Task( String nameTask, String description, Contest contest) {
        this.description = description;
        this.contest = contest;
        this.nameTask = nameTask;
    }

    public Task() {
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
