package Lab;

public enum Jogabilidade {
	ONLINE("Online"), OFFLINE("Offline"), MULTIPLAYER("Multiplayer"), COOPERATIVO("Cooperativo"), COMPETITIVO("Competitivo");
	
	/**
	 * Especificação de um tipo de jogabilidade disponivel no jogo.
	 */
	private String categoria;
	/**
	 * Construtor.
	 * @param categoria
	 */
	Jogabilidade(String categoria){
		this.categoria = categoria;
	}
}
