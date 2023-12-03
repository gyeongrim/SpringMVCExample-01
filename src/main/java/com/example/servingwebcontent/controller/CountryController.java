package com.example.servingwebcontent.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.servingwebcontent.entity.CountryEntity;
import com.example.servingwebcontent.form.CountryForm;
import com.example.servingwebcontent.form.CountrySearchForm;
import com.example.servingwebcontent.repository.CountryEntityMapper;
import com.google.gson.Gson;

@Controller
public class CountryController {

	@Autowired
	private CountryEntityMapper mapper;

	@GetMapping("/country")
	public String init(Model model) {

		model.addAttribute("countrySearchForm",new CountrySearchForm());
		model.addAttribute("countryForm",new CountryForm());
		
		return "country/country";
	}

	/**
	 * Represents a sequence of characters. In this context, it is used to return a
	 * JSON representation of a CountryEntity object.
	 */
	@PostMapping("/country/getCountry")
	@ResponseBody
	public String getCountry(@Validated CountrySearchForm countrySearchForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		/**
		 * Optional object containing the result of the database query for the country
		 * with the specified country code.
		 */
		Optional<CountryEntity> countryEntity = mapper.selectByPrimaryKey(countrySearchForm.getMstCountryCD());
		if (countryEntity == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return new Gson().toJson(countryEntity.get());
	}
	
	@PostMapping("/country/loginCountry")
	@ResponseBody
	public String addCustomer(@Validated CountryForm countryForm) {

		CountryEntity countryEntity = new CountryEntity();
		
		countryEntity.setMstcountrycd(countryForm.getMstcountrycd());
		countryEntity.setMstcountrynanme(countryForm.getMstcountrynanme());
		
		mapper.insert(countryEntity);
		
		return "success";
	}
	@PostMapping("/country/updCountry")
	@ResponseBody
	public String updCountry(@Validated CountryForm countryForm) {

		CountryEntity countryEntity = new CountryEntity();
		
		countryEntity.setMstcountrycd(countryForm.getMstcountrycd());
		countryEntity.setMstcountrynanme(countryForm.getMstcountrynanme());
		
		mapper.updateByPrimaryKey(countryEntity);
		
		return "success";
	}
	@PostMapping("/country/delCountry")
	@ResponseBody
	public String delCountry(@Validated CountryForm countryForm) {
		
		mapper.deleteByPrimaryKey(countryForm.getMstcountrycd());
		
		return "success";
	}
}