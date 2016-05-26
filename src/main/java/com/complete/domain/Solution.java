package com.complete.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rina on 25.05.2016.
 */
@Entity
public class Solution implements Serializable {
    @Transient
    private static final long serialVersionUID = -3323225682030341871L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolution;
    private String code;
    private Long score;
    private Long timeSend;


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
                ", task=" + task +
                ", user=" + user +
                '}';
    }

    public Solution(String code, Long timeSend, Task task, User user) {
        this.code = code;
        this.timeSend = timeSend;
        this.task = task;
        this.user = user;
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
