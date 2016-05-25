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
                ", task=" + task +
                ", user=" + user +
                '}';
    }
}
