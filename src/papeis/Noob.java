package papeis;
/**
 * Classe que define tipo do jogador(Noob).
 * @author joseims
 *
 */
public class Noob extends Papel {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDesconto() {
			return 0.9;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX2pInicial() {
		return 0;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMultiplicadorPontoCompra() {
		return 10;
	}

}
