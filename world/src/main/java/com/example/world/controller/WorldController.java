package com.example.world.controller;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.dao.CountryDao;
import com.example.world.entity.Country;

@RestController
@RequestMapping("/countries")
@CrossOrigin
@Validated
public class WorldController {
	private final CountryDao countryDao;
	
	public WorldController(CountryDao countryDao) {
		this.countryDao = countryDao;
	}
    // http://localhost:9090/world/api/v1/countries/TUR
	@GetMapping(value="{code}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Country getCountryByCode(@PathVariable String code) {
		return countryDao.findCountryByCode(code);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Country addCountry(@RequestBody Country country) {
		return countryDao.addCountry(country);
	}
}
