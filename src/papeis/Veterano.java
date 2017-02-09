package papeis;
/**
 * Classe que define tipo do jogador(Veterano).
 * @author joseims
 *
 */
public class Veterano extends Papel {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDesconto() {
			return 0.8;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX2pInicial() {
		return 1000;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMultiplicadorPontoCompra() {
		return 15;
	}

}
