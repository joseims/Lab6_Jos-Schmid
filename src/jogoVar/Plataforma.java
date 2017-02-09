package jogoVar;

import java.util.Set;

import Lab.Jogabilidade;


public class Plataforma extends Jogo {
	public Plataforma(String nome, Set<Jogabilidade> categoria) {
		super(nome, categoria);
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
}
