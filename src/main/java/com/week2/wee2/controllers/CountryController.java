package com.week2.wee2.controllers;

import com.week2.wee2.beans.Country;
import com.week2.wee2.services.CountrySservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    //    CountrySservice countrySservice = new CountrySservice();
    @Autowired
    CountrySservice countrySservice;

    @GetMapping("/getcountries")
    public List getCountries() {
        return countrySservice.getAllCountries();
    }

    @GetMapping("/getcountries/{id}")
    public Country getCountriesById(@PathVariable(value = "id") int id) {
        return countrySservice.sgetCountryById(id);

    }

    @GetMapping("/getcountries/countryname")
    public Country getCountriesByName(@RequestParam(value = "name") String countryName) {
        return countrySservice.getCountryByName(countryName);
    }

    @PostMapping("/addcountry")
    public Country addCountries(@RequestBody Country country) {
        return countrySservice.addCountry(country);
    }

    @PutMapping("/updatecountry")
    public Country updateCountries(@RequestBody Country country) {
        return countrySservice.addCountry(country);
    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountries(@PathVariable(value="id") int id) {
        return countrySservice.deleteCountry(id);
    }

}
