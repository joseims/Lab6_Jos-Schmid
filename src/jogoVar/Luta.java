package jogoVar;



import java.util.Set;

import lab.Jogabilidade;

import excessões.PontMaxInvalida;
/**
 * {@inheritDoc}
 * @author joseims
 *
 */
public class Luta extends Jogo {
	double MAX = 100000;
	public Luta(String nome, Set<Jogabilidade> categoria,double preco) throws Exception {
		super(nome, categoria, preco);
	}
	/**
	 * {@inheritDoc}
	 * @throws Exception Pontuação não pode ser maio que 100 mil.
	 */
	@Override
	public int registraJogada(int score, boolean win)throws Exception {
		if (score > MAX)  throw new PontMaxInvalida("Score inválido");
		this.adicionaJogada();
		if (score > this.pontuacaoMaxima) {this.setPontuacaoMaxima(score);}
		if (win) { this.adicionaConclusao();}
		int x2p = score/1000;
		return x2p ;
		
	}
	
	public String toString(){
		return super.toString("Luta");
		
	}

}
