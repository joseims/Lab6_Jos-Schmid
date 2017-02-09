package jogoVar;

import java.util.Set;

import Lab.Jogabilidade;

public class Luta extends Jogo {
	int MAX =100000;
	public Luta(String nome, Set<Jogabilidade> categoria) {
		super(nome, categoria);
	}
	/**
	 * {@inheritDoc}
	 * @throws Exception Pontuação não pode ser maio que 100 mil.
	 */
	@Override
	public int registraJogada(int score, boolean win)throws Exception {
		if (score > MAX)  throw new Exception("Score inválido");
		this.adicionaJogada();
		if (score > this.pontuacaoMaxima) {this.setPontuacaoMaxima(score);}
		if (win) { this.adicionaConclusao();}
		int x2p = score/1000;
		return x2p ;
		
	}

}
