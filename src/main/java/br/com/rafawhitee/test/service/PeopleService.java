package br.com.rafawhitee.test.service;

import java.util.ArrayList;
import java.util.List;

import br.com.rafawhite.util.MathUtil;
import br.com.rafawhitee.test.model.People;
import br.com.rafawhitee.test.model.Profile;

public class PeopleService {
	
	private ProfileService profileService = new ProfileService();

	public List<People> createPeoples(int size) {
		List<People> list = new ArrayList<People>();
		List<Profile> profiles = profileService.createProfiles();
		for (int i = 0; i < size; i++) {
			People newPeople = new People();
			newPeople.setAge(MathUtil.randomIntNumber(18, 30));
			newPeople.setHeight(MathUtil.formatDouble(MathUtil.randomDoubleNumber(1.20, 2.00), 2));
			newPeople.setActive((MathUtil.randomIntNumber(0, 1) == 0) ? false : true);
			newPeople.setName("People " + (i+1));
			newPeople.setWeight(MathUtil.formatDouble(MathUtil.randomDoubleNumber(45.00, 90.00), 2));
			int indexProfile = MathUtil.randomIntNumber(0, profiles.size() - 1);
			Profile profile = profiles.get(indexProfile);
			newPeople.setProfile(profile);
			list.add(newPeople);
		}
		return list;
	}

}