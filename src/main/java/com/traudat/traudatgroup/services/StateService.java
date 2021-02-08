package com.traudat.traudatgroup.services;

import java.util.List;

import com.traudat.traudatgroup.models.State;

public interface StateService {
	List<State> getListState();
	
	State save(State state);
	
	State findById(int id);
	
	void deleteById(int id);
}
