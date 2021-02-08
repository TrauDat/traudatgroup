package com.traudat.traudatgroup.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.common.CustomException;
import com.traudat.traudatgroup.models.Country;
import com.traudat.traudatgroup.repositories.CountryRepository;
import com.traudat.traudatgroup.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Country> listCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country findById(int id) {
		Optional<Country> reponse = Optional.empty();
		Country country = new Country();
		try {
			reponse = countryRepository.findById(id);
			if (reponse.isPresent()) {
				country = reponse.get();
			} else {
				new CustomException("Country not found");
			}
		} catch (Exception e) {
			new CustomException("Country not found");
		}
		return country;
	}

	@Override
	public void deleteById(Integer id) {
		try {
			countryRepository.deleteById(id);
		} catch (Exception e) {
			new CustomException("Country not found");
		}
	}
}
