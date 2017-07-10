package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

	// tag::PersonToAccountMapper[]
	interface PersonToAccountMapper {
		Account map(Person p);
	}

	interface GenericMapper<E, S> {
		S map(E p);
	}
	// end::PersonToAccountMapper[]

	// tag::map[]
	private <E, S> List<S> map(List<E> listEntrees, GenericMapper<E, S> mapper) {
		// TODO implémenter la méthode pour transformer une liste de personnes
		// en liste de comptes
		List<S> resultat = new ArrayList<>();
		for (E entree : listEntrees) {
			resultat.add(mapper.map(entree));
		}
		return resultat;
	}
	// end::map[]

	// tag::test_map_person_to_account[]
	@Test
	public void test_map_person_to_account() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO transformer la liste de personnes en liste de comptes
		// TODO tous les objets comptes ont un solde à 100 par défaut
		List<Account> result = map(personList, p -> {
			Account account = new Account();
			account.setOwner(p);
			account.setBalance(100);
			return account;
		});

		assert result.size() == personList.size();
		for (Account account : result) {
			assert account.getBalance().equals(100);
			assert account.getOwner() != null;
		}
	}
	// end::test_map_person_to_account[]

	// tag::test_map_person_to_firstname[]
	@Test
	public void test_map_person_to_firstname() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO transformer la liste de personnes en liste de prénoms
		List<String> result = map(personList, p -> p.getFirstname());

		assert result.size() == personList.size();
		for (String firstname : result) {
			assert firstname.startsWith("first");
		}
	}
	// end::test_map_person_to_firstname[]
}
