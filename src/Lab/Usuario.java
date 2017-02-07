package Lab;

import java.util.ArrayList;

public class Usuario {
	/**
	 * Nome do usuário
	 */
	private String nome;
	/**
	 * Lista de jogos que o usuário possui.
	 */
	private ArrayList<Jogo> jogos;
	/**
	 * Quantidade de dinheiro disponivel para o usuário comprar jogos.
	 */
	private int carteira;
	/**
	 * Especificação do tipo de usuário.
	 */
	private Papel papel;
	
	
	public Usuario(String nome,Papel papel){
		this.nome = nome;
		this.papel = papel;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
