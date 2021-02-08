package br.com.rafawhitee.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.rafawhitee.test.enums.ProfileType;
import br.com.rafawhitee.test.model.Profile;

public class ProfileService {
		
	public List<Profile> createProfiles() {
		List<Profile> list = new ArrayList<Profile>();
		List<ProfileType> names = Arrays.asList(ProfileType.values());
		for(ProfileType current : names) {
			list.add(new Profile(current.toString()));
		}
		return list;
	}

}