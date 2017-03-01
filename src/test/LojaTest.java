package test;

import static org.junit.Assert.*;

import java.util.HashSet;

import jogoVar.Jogo;
import jogoVar.RPG;
import lab.Jogabilidade;
import lab.LojaController;
import lab.Usuario;

import org.junit.Before;
import org.junit.Test;


import excessões.UsuarioInexistente;
import excessões.ValorInvalido;

import papeis.Noob;
import papeis.Papel;

public class LojaTest {
	Jogo a;
	Usuario teste1;
	Papel papel;
	LojaController loja;
	
	@Before
	public void setUp() throws Exception {
		HashSet<Jogabilidade> cat = new HashSet<Jogabilidade>();
		a = new RPG("macacão",cat,4);
		papel = new Noob();
		loja = new LojaController();
		loja.addUsuario("marco","marq", "Noob");
		
	
	}

	


	@Test(expected = UsuarioInexistente.class)
	public void testLoja1() throws Exception {
		loja.adicionaCarteira(-1," " );
	}
	@Test(expected = ValorInvalido.class)
	public void testAdicionaCarteira() throws Exception {
		loja.adicionaCarteira(-1,"marco");
	}

}
