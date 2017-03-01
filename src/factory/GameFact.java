package factory;

import java.util.HashSet;
import java.util.Set;
import jogoVar.*;
import lab.Jogabilidade;

public class GameFact {
	public static Jogo criaJogo(String nome, String categ,double preco,String tipo) throws Exception{
		Jogo game;
		HashSet<Jogabilidade> categoria = new HashSet<Jogabilidade>();
		String[] cats = categ.split(" ");
		for (String a:cats){
			Jogabilidade each;
			/* COMO FAZ ESSE CARAI*/			
		}
		if (tipo.equals("Luta")){
			game = new Luta(nome,categoria,preco);
		}
		if (tipo.equals("RPG")) {
			game = new RPG(nome,categoria,preco);

		}
		else {
			game = new Plataforma(nome,categoria,preco);

		}
		return game;
	}

}
