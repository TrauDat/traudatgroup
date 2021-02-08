package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.common.CustomException;
import com.traudat.traudatgroup.models.State;
import com.traudat.traudatgroup.repositories.StateRepository;
import com.traudat.traudatgroup.services.StateService;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	private StateRepository stateRepository;
	Logger LOG = LogManager.getLogger(StateServiceImpl.class);	
	
	
	@Override
	public List<State> getListState() {
		try {
			return stateRepository.findAll();
		} catch (Exception ex) {
			LOG.error("Error getListState in StateServiceImpl: ",ex);
			return Collections.emptyList();
		}
	}


	@Override
	public State save(State state) {
		try {
			return stateRepository.save(state);
		} catch (Exception ex){
			LOG.error("Error create State in StateServiceImpl", ex);
			new CustomException("Error");
		}
		return state;
	}


	@Override
	public State findById(int id) {
		Optional<State> reponse = Optional.empty();
		State state = new State();
		try {
			reponse = stateRepository.findById(id);
			if (reponse.isPresent()) {
				state = reponse.get();
			} else {
				new CustomException("State not found");
			}
		} catch (Exception e) {
			new CustomException("State not found");
		}
		return state;
	}


	@Override
	public void deleteById(int id) {
		try {
			stateRepository.deleteById(id);
		} catch (Exception ex) {
			LOG.error("Error deleteById() in StateServiceImpl",ex);
		}
	}

}
