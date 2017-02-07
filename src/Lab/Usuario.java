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
}
