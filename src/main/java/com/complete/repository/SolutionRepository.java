package com.complete.repository;

import com.complete.domain.Solution;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Rina on 25.05.2016.
 */
@Repository
public interface SolutionRepository extends CrudRepository<Solution, Long> {

}