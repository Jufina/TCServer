package com.complete.domain;

import com.complete.jsonview.SolutionView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rina on 25.05.2016.
 */

@Entity
public class Solution implements Serializable {
    @Transient
    private static final long serialVersionUID = -3323225682030341871L;

    @JsonView(SolutionView.IdView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolution;

    @JsonView(SolutionView.CodeView.class)
    private String code;
    @JsonView(SolutionView.ScoreView.class)
    private Long score;
    @JsonView(SolutionView.timeSendView.class)
    private Long timeSend;
    @JsonView(SolutionView.languageView.class)
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(Long idSolution) {
        this.idSolution = idSolution;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonView(SolutionView.TaskView.class)
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Task.class)
    private Task task;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    private User user;

    @Override
    public String toString() {
        return "Solution{" +
                "idSolution=" + idSolution +
                ", code='" + code + '\'' +
                ", score=" + score +
                ", timeSend=" + timeSend +
                ", language='" + language + '\'' +
                ", task=" + task +
                '}';
    }

    public Solution(Long timeSend, String language, Task task, User user, String code) {
        this.timeSend = timeSend;
        this.language = language;
        this.task = task;
        this.user = user;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(Long timeSend) {
        this.timeSend = timeSend;
    }

    public Solution() {
    }
}
