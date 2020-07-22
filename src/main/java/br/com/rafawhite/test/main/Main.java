package br.com.rafawhite.test.main;

import java.util.List;

import br.com.rafawhite.dto.FilterBy;
import br.com.rafawhite.enums.ComparatorType;
import br.com.rafawhite.test.model.People;
import br.com.rafawhite.test.service.PeopleService;
import br.com.rafawhite.util.ArrayUtil;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			PeopleService peopleService = new PeopleService();
			List<People> peoples = peopleService.createPeoples(50);

			// Create a Filter that will filter age == 19
			FilterBy filterByAgeEquals1 = new FilterBy("age", ComparatorType.Equals, 19);
			List<People> filteredOnlyAge1 = (List<People>) ArrayUtil.filterByFields(peoples, filterByAgeEquals1);
			System.out.println("Size of List Filtered by Age Equals 19: " + filteredOnlyAge1.size());

			// Create a Filter that will filter age > 19
			FilterBy filterByAgeEquals2 = new FilterBy("age", ComparatorType.GreaterThan, 19);
			List<People> filteredOnlyAge2 = (List<People>) ArrayUtil.filterByFields(peoples, filterByAgeEquals2);
			System.out.println("Size of List Filtered by Age Greather Than 19: " + filteredOnlyAge2.size());

			// Create a Filter that will filter age >= 19
			FilterBy filterByAgeEquals3 = new FilterBy("age", ComparatorType.GreaterThanOrEquals, 19);
			List<People> filteredOnlyAge3 = (List<People>) ArrayUtil.filterByFields(peoples, filterByAgeEquals3);
			System.out.println("Size of List Filtered by Age Greather Than or Equals To 19: " + filteredOnlyAge3.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}