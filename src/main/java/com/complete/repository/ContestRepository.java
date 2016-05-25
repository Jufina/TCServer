package com.complete.repository;

import com.complete.domain.Contest;
import com.complete.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rina on 25.05.2016.
 */
@Repository
public interface ContestRepository extends CrudRepository<Contest, Long> {
}