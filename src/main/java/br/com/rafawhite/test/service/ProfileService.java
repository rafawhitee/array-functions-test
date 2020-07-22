package br.com.rafawhite.test.service;

import java.util.ArrayList;
import java.util.List;

import br.com.rafawhite.test.model.Profile;
import br.com.rafawhite.util.MathUtil;

public class ProfileService {
		
	public List<Profile> createProfiles(int size) {
		List<Profile> list = new ArrayList<Profile>();
		for (int i = 0; i < size; i++) {
			Profile newProfile = new Profile();
		    newProfile.setDescription("Profile description " + MathUtil.randomIntNumber(1, Integer.MAX_VALUE));
			list.add(newProfile);
		}
		return list;
	}

}
