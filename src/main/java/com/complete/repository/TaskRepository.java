package com.complete.repository;

import com.complete.domain.Contest;
import com.complete.domain.Task;
import com.complete.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rina on 25.05.2016.
 */

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByContest(Contest contest);
}