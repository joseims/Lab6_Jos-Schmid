package jogoVar;

import java.util.Set;

import Lab.Jogabilidade;


public class RPG extends Jogo {

	public RPG(String nome, Set<Jogabilidade> categoria) {
		super(nome, categoria);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int registraJogada(int score, boolean win) {
		int x2p = 0;
		this.adicionaJogada();
		x2p += 10;
		if (score > this.pontuacaoMaxima) {this.setPontuacaoMaxima(score);}
		if (win) { this.adicionaConclusao();}
		return x2p;
		
	}
}
