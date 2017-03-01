package test;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import jogoVar.Jogo;
import jogoVar.Luta;
import jogoVar.RPG;
import lab.Jogabilidade;
import lab.Usuario;
import excessões.*;

import papeis.*;

public class UsuarioTest {
	Jogo a,b,c;
	Usuario teste1,teste2;
	Papel papel;
	
	@Before
	public void setUp() throws Exception{
		HashSet<Jogabilidade> cat = new HashSet<Jogabilidade>();
		a = new RPG("macacão",cat,4);
		b = new Luta("macaco",cat,4);
		c = new RPG("macacão",cat,6);

	}

	@Test
	public void testHashCode() throws Exception {
		papel = new Veterano();
		teste1 = new Usuario("Marco","wik",papel);
		teste2 = new Usuario("Chico","pep",papel);
		Usuario teste3 = new Usuario("Marco","wik",papel);
		Assert.assertFalse(teste1.equals(teste2));
		Assert.assertTrue(teste1.equals(teste3));
	}

	@Test(expected = StringInvalida.class )
	public void testUsuario() throws Exception{
		papel = new Veterano();
		teste1 = new Usuario(" ","wik",papel);
	}
	
	@Test(expected = NullPointerException.class )
	public void testUsuario1() throws Exception{
		papel = new Veterano();
		teste1 = new Usuario(null,"wik",papel);
	}
	
	
	@Test(expected = NullPointerException.class )
	public void testUsuario2() throws Exception{
		papel = new Veterano();
		teste1 = new Usuario(" wefs","wik",null);
	}

	@Test
	public void testMudaCarteira_Comprajogo_Mudapapel() throws Exception {
			Papel papel1 = new Noob();
			teste1 = new Usuario("marco","wik",papel1);
			Assert.assertTrue(0 == teste1.getCarteira());
			teste1.mudaCarteira(4);
			Assert.assertTrue(4 == teste1.getCarteira());
			teste1.compraJogo(b);
			for ( int i = 0;i <11;i++){
				teste1.registraJogada("macaco",100000, false);
			}
			Assert.assertTrue(1140==teste1.getX2p());
			teste1.atualizaPapel();
			Assert.assertTrue(teste1.getMultiplicadorDePontoCompra() == 15 );
			
			
		}

	


}
