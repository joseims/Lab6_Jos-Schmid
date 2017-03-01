package lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import checks.Check;

import excessões.JogoInexistente;
import excessões.StringInvalida;
import excessões.ValorInvalido;
import papeis.Noob;
import papeis.Papel;
import papeis.Veterano;
import jogoVar.Jogo;

public class Usuario {
	/**
	 * Nome do usuário
	 */
	private String nome;
	/**
	 * Identificação do usuario
	 */
	private String nick;
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
	
	
	public Usuario(String nome,String nick,Papel papel) throws Exception{
		if (Check.StringError(nome)) throw new StringInvalida("Nome de jogo inválido");
		if (Check.NullError(papel)|| Check.NullError(nome)) throw new NullPointerException("Categoria nula");
		this.nome = nome;
		this.papel = papel;
		this.nick = nick;
		this.x2p = papel.getX2pInicial();
		jogos = new HashMap<String, Jogo>();
	}


	public void registraJogada(String game, int score, boolean win) throws Exception{
		if (!jogoCheck(game)) throw new JogoInexistente("Jogo Inexistente");
		int x2pBonus = achaJogo(game).registraJogada(score,win);
		ganhaX2p(x2pBonus);
		this.atualizaPapel();
	}
	
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws Exception{
		this.registraJogada(nomeJogo, scoreObtido, zerou);
		if (getPapel().equals("Noob")) {
			if (getCategoria(nomeJogo).contains(Jogabilidade.COMPETITIVO)){ganhaX2p(-20);}				
			if (getCategoria(nomeJogo).contains(Jogabilidade.ONLINE)){ganhaX2p(-10);}	
			if (getCategoria(nomeJogo).contains(Jogabilidade.COOPERATIVO)){ganhaX2p(-50);}	
			
		} else {
			if (getCategoria(nomeJogo).contains(Jogabilidade.COMPETITIVO)){ganhaX2p(-20);}
			if (getCategoria(nomeJogo).contains(Jogabilidade.OFFLINE)){ganhaX2p(-20);}	
		}
		atualizaPapel();
	}
	
	private Set<Jogabilidade> getCategoria(String nome) throws Exception{
		Jogo game = achaJogo(nome);
		return game.getCategorias();
	}
	
	private String getPapel() {
		return this.papel.getPapel();
	}


	public void recompensar(String nomeJogo,int scoreObtido,boolean zerou) throws Exception{
		this.registraJogada(nomeJogo, scoreObtido, zerou);
		if (getPapel().equals("Noob")) {
			if (getCategoria(nomeJogo).contains(Jogabilidade.OFFLINE)){ganhaX2p(30);}				
			if (getCategoria(nomeJogo).contains(Jogabilidade.MULTIPLAYER)){ganhaX2p(10);}	
		} else {
			if (getCategoria(nomeJogo).contains(Jogabilidade.COOPERATIVO)){ganhaX2p(20);}
			if (getCategoria(nomeJogo).contains(Jogabilidade.ONLINE)){ganhaX2p(10);}	
		}
		atualizaPapel();
	}
	
	public boolean jogoCheck(String string) throws Exception {
		if (jogos.containsKey(string)){return true;}
		return false;
		
	}

	/**
	 * Dado um nome do jogo, retorna o objeto correspondente no mapa.
	 * @param game Nome do jogo.
	 * @return Um objeto do tipo Jogo.
	 * @throws Exception 
	 */
	private Jogo achaJogo(String game) throws Exception{
		if (!jogoCheck(game)) throw new JogoInexistente("Jogo Inexistente");
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
			mudaCarteira(Math.ceil(-1*precoReal));
			ganhaX2p(game.getPreco()*getMultiplicadorDePontoCompra());
			jogos.put(game.getNome(), game);
		}
		this.atualizaPapel();
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


	public void atualizaPapel() {
		if (this.getX2p()>= 1000) {
			this.papel = new Veterano();
		} else {
			this.papel = new Noob();
		}
		
	}


	public String getNome() {
		return nome;
	}


	public String getNick() {
		return nick;
	}


	@Override
	public String toString() {
		double preco = 0;
		String a = "Jogador " + papel.getPapel()+ ": " + this.getNick() + "\n" +
				this.getNome() + " - " + this.getX2p() + "x2p\nLista de Jogos:";
		for (Jogo game:jogos.values()){
			a  += game.toString();
			preco += game.getPreco();
		}
		
		a += "\nTotal de preço dos jogos: R$  " + preco+ "\n";
		
		return a;
	
	}
}
