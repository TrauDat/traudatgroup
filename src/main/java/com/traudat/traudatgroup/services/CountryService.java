package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.Country;



public interface CountryService {
	List<Country> listCountries();
	
	Country save(Country country);
	
	Country findById(int id);
	
	void deleteById(Integer id);
}
