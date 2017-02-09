package Lab;

import java.util.ArrayList;
import java.util.HashMap;

import papeis.Papel;
import jogoVar.Jogo;

public class Usuario {
	/**
	 * Nome do usuário
	 */
	private String nome;
	/**
	 * Mapa de jogos que o usuário possui.Chave é a String representando o nome do jogo e valor é o Objeto jogo.
	 */
	private HashMap<String,Jogo> jogos;
	/**
	 * Quantidade de dinheiro disponivel para o usuário comprar jogos.
	 */
	private double carteira;
	/**
	 * Especificação do tipo de usuário.
	 */
	private Papel papel;
	
	
	/**
	 * Pontuação baseado na experiencia do usuário.
	 * @param x2p
	 */
	private double x2p;
	
	
	public Usuario(String nome,Papel papel){
		this.nome = nome;
		this.papel = papel;
		this.x2p = papel.getX2pInicial();
	}


	private void registraJogada(String game, int score, boolean win) throws Exception{
		int x2pBonus = achaJogo(game).registraJogada(score,win);
		ganhaX2p(x2pBonus);
	}
	/**
	 * Dado um nome do jogo, retorna o objeto correspondente no mapa.
	 * @param game Nome do jogo.
	 * @return Um objeto do tipo Jogo.
	 */
	private Jogo achaJogo(String game){
		return jogos.get(game);
	}
	/**
	 * Aumenta o seu x2p.
	 * @param d Quantidade de x2P  a ser adicionado ao total atual.
	 */
	private void ganhaX2p(double d) {
		this.x2p += d;
		
	}

	public double getCarteira() {
		return carteira;
	}


	public double getX2p() {
		return x2p;
	}


	public void mudaCarteira(double d) {
		this.carteira += d;
	}

	public void compraJogo(Jogo game) {
		double precoReal = game.getPreco()*getDesconto();
		if (getCarteira() >= precoReal) {
			mudaCarteira(-1*precoReal);
			ganhaX2p(game.getPreco()*getMultiplicadorDePontoCompra());
			jogos.put(game.getNome(), game);
		}
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
	
	public double getDesconto() {
		return this.papel.getDesconto();
	}
	public double getMultiplicadorDePontoCompra() {
		return this.papel.getMultiplicadorPontoCompra();
		
	}
}
