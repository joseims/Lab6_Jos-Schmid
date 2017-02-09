package jogoVar;

import java.util.Set;

import Lab.Jogabilidade;

/**
 * Classe que representa um jogo.
 * @author joseims
 */
public abstract class Jogo {
	/**
	 * Nome do jogo.
	 */
	private String nome;
	/**
	 * Custo necessário para adquirir o jogo.
	 */
	private int preco;
	/**
	 * Número de vezes que o usuário jogou o jogo.
	 */
	private int vezesJogadas;
	/**
	 * Número de vezes que o usuário concluiu o jogo.
	 */
	private int vezesConcluidas;
	/**
	 * Pontuação máxima alcançada no jogo.
	 */
	protected int pontuacaoMaxima;
	/**
	 * Categorias em que  o jogo se enquadra.
	 */
	private Set<Jogabilidade> categorias;
	
	/**
	 * Construtor.
	 * @param nome Nome do jogo.
	 * @param categoria Categorias à que o jogo pertence.
	 */
	
	public Jogo(String nome, Set<Jogabilidade> categoria){
		this.nome = nome;
		this.categorias = categoria;
	}	
	
	/**
	 * Registra uma jogada, atualizando vezes concluidas e score máximo se necessário.
	 * @param score Pontuação obtida na jogada.
	 * @param win Se o jogador concluiu o jogo ou não.
	 * @return pontuação x2p que tenho que descobrir oque é e ver etc etc
	 * 
	 */
	public abstract int registraJogada(int score, boolean win) throws Exception;
	/**
	 * Aumenta em 1 o número de vezes jogadas.
	 */
	protected void adicionaJogada() {
		this.vezesJogadas++;
		
	}
	/**
	 * Aumenta em 1 o número de vezes que o jogador concluiu o jogo.
	 */
	protected void adicionaConclusao() {
		this.vezesConcluidas++;
		
	}
	/**
	 * Retorna a pontuação máxima no jogo.
	 */
	public int getPontuacaoMaxima() {
		return pontuacaoMaxima;
	}
	/**
	 * Substitui a pontuação máxima anterior por uma nova pontuação.
	 * @param pontuacaoMaxima
	 */
	public void setPontuacaoMaxima(int pontuacaoMaxima) {
		this.pontuacaoMaxima = pontuacaoMaxima;
	}
	/**
	 * Retorna o nome do jogo.
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	public int getVezesJogadas() {
		return vezesJogadas;
	}
	/**
	 * Retorna o número de vezes que o jogo foi concluido.
	 * @return Int
	 */
	public int getVezesConcluidas() {
		return vezesConcluidas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorias == null) ? 0 : categorias.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
	
		return true;
	}

	public int getPreco() {
		return preco;
	}
}