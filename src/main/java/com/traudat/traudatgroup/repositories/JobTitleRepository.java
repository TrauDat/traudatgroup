package com.traudat.traudatgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traudat.traudatgroup.models.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{

}
