package test;

import jogoVar.*;

import java.util.HashSet;

import lab.*;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excessões.*;

public class JogoTest {
	Jogo a;
	Jogo b;
	Jogo c;
	
	@Before
	public void setUp() throws Exception {
		HashSet<Jogabilidade> cat = new HashSet<Jogabilidade>();
		a = new RPG("macacão",cat,4);
		b = new Luta("macaco",cat,5);
		c = new RPG("macacão",cat,6);
	}

	@Test
	public void testHashCode() {
		Assert.assertTrue(a.equals(c));
	}

	@Test(expected=StringInvalida.class)
	public void testJogo() throws Exception {
		HashSet<Jogabilidade> cat = new HashSet<Jogabilidade>();
		Jogo a = new RPG("  ",cat,5);
		
	}
	
	@Test(expected= NullPointerException.class)
	public void testJogo1() throws Exception {
		HashSet<Jogabilidade> cat = new HashSet<Jogabilidade>();
		Jogo a = new RPG("  sd",null,6);
		
	}


	@Test
	public void testRegistraJogada() throws Exception {
		a.registraJogada(4, true);
		Assert.assertEquals(4, a.getPontuacaoMaxima());
		Assert.assertEquals(1, a.getVezesConcluidas());
		Assert.assertEquals(4, a.getPreco());
	}


}
