package papeis;
/**
 * Classe que define tipo do jogador(Noob).
 * @author joseims
 *
 */
public class Noob extends Papel {
	private String papel = "Noob";
	/**
	 * Construtor
	 */
	public Noob(){
	}
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
	@Override
	public String getPapel() {
		return "Noob";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((papel == null) ? 0 : papel.hashCode());
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
		Noob other = (Noob) obj;
		if (papel == null) {
			if (other.papel != null)
				return false;
		} else if (!papel.equals(other.papel))
			return false;
		return true;
	}

}
