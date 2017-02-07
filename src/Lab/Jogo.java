package Lab;
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
	 * Construtor.
	 * @param nome
	 */
	public Jogo(String nome){
		this.nome = nome;
	}
	
	
}
