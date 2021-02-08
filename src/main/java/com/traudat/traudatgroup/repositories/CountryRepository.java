package com.traudat.traudatgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traudat.traudatgroup.models.Country;



@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
