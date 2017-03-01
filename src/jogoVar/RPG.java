package jogoVar;

import java.util.Set;

import lab.Jogabilidade;



public class RPG extends Jogo {
	/**
	 * {@inheritDoc}
	 * @author joseims
	 *
	 */
	public RPG(String nome, Set<Jogabilidade> categoria,double preco)throws Exception {
		super(nome, categoria, preco);
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
	
	public String toString(){
		return super.toString("RPG");
		
	}
}
