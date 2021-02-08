package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.JobTitle;
import com.traudat.traudatgroup.repositories.JobTitleRepository;
import com.traudat.traudatgroup.services.JobTitleService;

@Service
public class JobTitleServiceImpl implements JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	Logger LOG = LogManager.getLogger(JobTitleServiceImpl.class);
	
	@Override
	public List<JobTitle> getJobTitles() {
		List<JobTitle> listJobTitles = Collections.emptyList();
		try {
			listJobTitles = jobTitleRepository.findAll();
			return listJobTitles;
		} catch (Exception ex) {
			LOG.error("Error getJobTitles() in JobTitleServiceImpl", ex);
		}
		return listJobTitles;
	}

	@Override
	public JobTitle save(JobTitle JobTitle) {
		try {
			return jobTitleRepository.save(JobTitle);
		} catch(Exception ex) {
			LOG.error("Error save() in JobTitleServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<JobTitle> findById(int id) {
		Optional<JobTitle> res = Optional.empty();
		try {
			res = jobTitleRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() JobTitleServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			jobTitleRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in JobTitleServiceImpl()",ex);
		}
		
	}

}
