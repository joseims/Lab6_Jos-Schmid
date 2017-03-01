package papeis;
/**
 * Classe que define tipo do jogador(Veterano).
 * @author joseims
 *
 */
public class Veterano extends Papel {
	private String papel = "Veterano";
	
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
		Veterano other = (Veterano) obj;
		if (papel == null) {
			if (other.papel != null)
				return false;
		} else if (!papel.equals(other.papel))
			return false;
		return true;
	}
	/**
	 * Construtor
	 */
	public Veterano(){
	}
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
	@Override
	public String getPapel() {
		return papel;
	}

}
