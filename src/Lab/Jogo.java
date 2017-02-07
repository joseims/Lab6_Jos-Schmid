package Lab;

import java.util.Set;

/**
 * Classe que representa um jogo.
 * @author joseims
 */
public class Jogo {
	/**
	 * Nome do jogo.
	 */
	private String nome;
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
	private int pontuacaoMaxima;
	/**
	 * Categorias em que  o jogo se enquadra.
	 */
	private Set<Jogabilidade> categorias;
	
	/**
	 * Tipo do jogo(RPG,Plataforma e Luta).
	 */
	private String tipo;
	/**
	 * 
	 * @param nome
	 * @param tipo
	 * @param categoria
	 */
	public Jogo(String nome, String tipo, Set<Jogabilidade> categoria){
		this.nome = nome;
		this.tipo = tipo;
		this.categorias = categoria;
	}	
	/**
	 * Registra uma jogada, atualizando vezes concluidas e score máximo se necessário.
	 * @param score Pontuação obtida na jogada.
	 * @param win Se o jogador concluiu o jogo ou não.
	 * @return A pontuação obtida na jogada.
	 */
	private int registraJogada(int score, boolean win) {
		this.adicionaJogada();
		if (score > this.pontuacaoMaxima) {this.setPontuacaoMaxima(score);}
		if (win) { this.adicionaConclusao();}
		return score;
		
	}
	/**
	 * Aumenta em 1 o número de vezes jogadas.
	 */
	private void adicionaJogada() {
		this.vezesJogadas++;
		
	}
	/**
	 * Aumenta em 1 o número de vezes que o jogador concluiu o jogo.
	 */
	private void adicionaConclusao() {
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
	/**
	 * Retorna o tipo do jogo(RPG,Plataforma e Luta).
	 * @return String
	 */
	public String getTipo() {
		return tipo;
	}
	
	
}
