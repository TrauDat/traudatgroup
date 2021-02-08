package com.traudat.traudatgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traudat.traudatgroup.models.State;

@Repository	
public interface StateRepository extends JpaRepository<State, Integer> {

}
