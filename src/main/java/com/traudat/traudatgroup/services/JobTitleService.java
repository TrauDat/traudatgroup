package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.JobTitle;

public interface JobTitleService {
	List<JobTitle> getJobTitles();
	
	JobTitle save(JobTitle JobTitle);
	
	Optional<JobTitle> findById(int id);
	
	void deleteById(int id);
}
