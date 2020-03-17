package com.aits.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aits.apps.model.CityModel;
import com.aits.apps.model.CountryModel;
import com.aits.apps.model.StateModel;
import com.aits.apps.util.HibernateUtil;

public class AjaxAppDao {

	public Map<Integer, String> getCountriesMap() {
		Session hsession = null;
		List<CountryModel> countries = null;
		Map<Integer, String> countryMap = new HashMap<>();
		try {
			hsession = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = hsession.createCriteria(CountryModel.class);
			countries = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!countries.isEmpty()) {
			for (CountryModel model : countries) {
				countryMap.put(model.getCountryId(), model.getCountryName());
			}
		}
		return countryMap;
	}

	public Map<Integer, String> getStatesMap(Integer countryId) {
		Session hsession = null;
		List<StateModel> states = null;
		Map<Integer, String> statesMap = new HashMap<>();
		try {
			hsession = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = hsession.createCriteria(StateModel.class);
			criteria.add(Restrictions.eq("countryId", countryId));
			states = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!states.isEmpty()) {
			for (StateModel model : states) {
				statesMap.put(model.getStateId(), model.getStateName());
			}
		}
		return statesMap;
	}

	public Map<Integer, String> getCitiesMap(Integer stateId) {
		Session hsession = null;
		List<CityModel> cities = null;
		Map<Integer, String> citiesMap = new HashMap<>();
		try {
			hsession = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = hsession.createCriteria(CityModel.class);
			criteria.add(Restrictions.eq("stateId", stateId));
			cities = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!cities.isEmpty()) {
			for (CityModel model : cities) {
				citiesMap.put(model.getCityId(), model.getCityName());
			}
		}
		return citiesMap;
	}

}
