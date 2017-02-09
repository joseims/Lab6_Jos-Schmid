package papeis;
/**
 * Classe que define o tipo de jogador.
 */
public abstract class Papel {
	/**
	 * Classe que define o desconto baseado no tipo de jogador.
	 * @return Desconto do tipo especificado.
	 */
	public abstract double getDesconto();
	
	/**
	 * Classe que define a quantidade de x2p inicial do usuário.
	 * @return Quantidade de x2p inicial do usuário.
	 */
	
	
	public abstract int getX2pInicial();

	/**
	 * Classe que define o multiplicador de x2P para a compra de jogos baseado no tipo do  usuário.
	 * @return Multiplicador de x2p para a compra de jogos.
	 */
	
	public abstract double getMultiplicadorPontoCompra();
	
	public abstract String getPapel();
}
