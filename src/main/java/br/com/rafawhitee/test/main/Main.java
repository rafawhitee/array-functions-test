package br.com.rafawhitee.test.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.rafawhite.dto.FilterBy;
import br.com.rafawhite.dto.GroupResult;
import br.com.rafawhite.enums.ComparatorType;
import br.com.rafawhite.util.ArrayUtil;
import br.com.rafawhitee.test.enums.ProfileType;
import br.com.rafawhitee.test.model.People;
import br.com.rafawhitee.test.service.PeopleService;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {		
			PeopleService peopleService = new PeopleService();
			List<People> peoples = peopleService.createPeoples(50);
			
			System.out.println(" -------- ");
			System.out.println(" TESTANDO AGRUPADORES ");
			System.out.println(" -------- ");
			
			// Agrupará por Idade
			List<GroupResult> agrupandoPorAge = ArrayUtil.groupBy(peoples, "age");
			Map<List<?>, ?> agrupadoPorAgeWithMapReturn = ArrayUtil.groupByWithMapReturn(peoples, "age", "active");
			Set<List<?>> lista = agrupadoPorAgeWithMapReturn.keySet();
			for(List<?> current : lista) {
				for(Object obj : current) {
					System.out.println(obj.toString());
				}
			}
			agrupandoPorAge.forEach(gr -> System.out.println(gr.getDescription() + " - TOTAL : " + gr.getValues().size()));
			
			System.out.println(" -------- ");
			List<GroupResult> agrupandoPorAgeAndActive = ArrayUtil.groupBy(peoples, "age", "active");
			agrupandoPorAgeAndActive.forEach(gr -> System.out.println(gr.getDescription() + " - TOTAL : " + gr.getValues().size()));
			
			System.out.println(" -------- ");
			System.out.println(" TESTANDO FILTROS ");
			System.out.println(" -------- ");
			
			// Vai filtrar as pessoas que tem idade igual a 19 anos
			FilterBy filterEqualsAge = new FilterBy("age", ComparatorType.Equals, 19);
			List<People> filteredEqualsAge = (List<People>) ArrayUtil.filterByFields(peoples, filterEqualsAge);
			System.out.println("Total Equals Age: " + filteredEqualsAge.size());

			System.out.println(" -------- ");
			
			// Vai filtrar as pessoas que tem idade menor que 19 anos
			FilterBy filterLessThanAge = new FilterBy("age", ComparatorType.LessThan, 19);
			List<People> filteredLessThanAge = (List<People>) ArrayUtil.filterByFields(peoples, filterLessThanAge);
			System.out.println("Total LessThan Age: " + filteredLessThanAge.size());
			
			System.out.println(" -------- ");
			
			// Vai filtrar as pessoas que tem idade maior que 19 anos
			FilterBy filterGreaterThanAge = new FilterBy("age", ComparatorType.GreaterThan, 19);
			List<People> filteredGreaterThanAge = (List<People>) ArrayUtil.filterByFields(peoples, filterGreaterThanAge);
			System.out.println("Total GreaterThan Age: " + filteredGreaterThanAge.size());
			
			System.out.println(" -------- ");
			
			// Vai filtrar as pessoas que tem idade menor ou igual a 19 anos
			FilterBy filterLessThanOrEqualsAge = new FilterBy("age", ComparatorType.LessThanOrEquals, 19);
			List<People> filteredLessThanOrEqualsAge = (List<People>) ArrayUtil.filterByFields(peoples, filterLessThanOrEqualsAge);
			System.out.println("Total LessThanOrEquals Age: " + filteredLessThanOrEqualsAge.size());
			
			System.out.println(" -------- ");
			
			// Vai filtrar as pessoas que tem idade maior ou igual a 19 anos
			FilterBy filterGreaterThanOrEquals = new FilterBy("age", ComparatorType.GreaterThanOrEquals, 19);
			List<People> filteredGreaterThanOrEquals = (List<People>) ArrayUtil.filterByFields(peoples, filterGreaterThanOrEquals);
			System.out.println("Total GreaterThanOrEquals Age: " + filteredGreaterThanOrEquals.size());
			
			System.out.println(" -------- ");		
			System.out.println(" FILTRANDO COM ATRIBUTOS DE RELACIONAMENTOS ");				
			System.out.println(" -------- ");
			// Filtrando por hierarquia
			FilterBy filterWithHierarchy = new FilterBy("profile.description", ComparatorType.Equals, ProfileType.Administrador.toString());
			List<People> filteredByPerfilDescriptionAdmin = (List<People>) ArrayUtil.filterByFields(peoples, filterWithHierarchy);
			System.out.println("Total Equals Perfil.Description ADMIN: " + filteredByPerfilDescriptionAdmin.size());
			
			System.out.println(" -------- ");
			
			filterWithHierarchy = new FilterBy("profile.description", ComparatorType.Equals, ProfileType.Cliente.toString());
			List<People> filteredByPerfilDescriptionCliente = (List<People>) ArrayUtil.filterByFields(peoples, filterWithHierarchy);
			System.out.println("Total Equals Perfil.Description CLIENTE: " + filteredByPerfilDescriptionCliente.size());
			
			System.out.println(" -------- ");
			
			filterWithHierarchy = new FilterBy("profile.description", ComparatorType.Equals, ProfileType.Gerente.toString());
			List<People> filteredByPerfilDescriptionGerente = (List<People>) ArrayUtil.filterByFields(peoples, filterWithHierarchy);
			System.out.println("Total Equals Perfil.Description GERENTE: " + filteredByPerfilDescriptionGerente.size());
			
			System.out.println(" -------- ");
			
			filterWithHierarchy = new FilterBy("profile.description", ComparatorType.Equals, ProfileType.Vendedor.toString());
			List<People> filteredByPerfilDescriptionVendedor = (List<People>) ArrayUtil.filterByFields(peoples, filterWithHierarchy);
			System.out.println("Total Equals Perfil.Description VENDEDOR: " + filteredByPerfilDescriptionVendedor.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}