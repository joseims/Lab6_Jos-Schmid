package Lab;
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
			return 0.1;
	}

}
