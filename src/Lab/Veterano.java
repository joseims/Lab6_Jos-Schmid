package Lab;
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
			return 0.2;
	}

}
