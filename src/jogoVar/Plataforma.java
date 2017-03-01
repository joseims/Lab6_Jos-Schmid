package jogoVar;

import java.util.Set;

import lab.Jogabilidade;



public class Plataforma extends Jogo {
	/**
	 * {@inheritDoc}
	 * @author joseims
	 *
	 */
	public Plataforma(String nome, Set<Jogabilidade> categoria,double preco) throws Exception{
		super(nome, categoria, preco);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int registraJogada(int score, boolean win) {
		int x2p = 0;
		this.adicionaJogada();
		if (score > this.pontuacaoMaxima) {this.setPontuacaoMaxima(score);}
		if (win) { this.adicionaConclusao();x2p += 20;}
		return x2p;
		
	}
	public String toString(){
		return super.toString("Plataforma");
		
	}
}
