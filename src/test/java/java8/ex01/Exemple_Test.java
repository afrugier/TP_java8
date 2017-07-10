package java8.ex01;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Exemple Test
 */
public class Exemple_Test {

	@Test
	public void testQuiEchoue() {
		fail();
	}

	@Test
	public void test1() {
		int nb1 = 12;
		int nb2 = 24;

		int somme = nb1 + nb2;
		assert 36 == somme;
	}

}
