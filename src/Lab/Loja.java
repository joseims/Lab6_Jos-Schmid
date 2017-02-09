package Lab;

import java.util.HashMap;

import jogoVar.Jogo;

public class Loja {
	private HashMap<String,Usuario> users;

	public Loja(){
	}
	/**
	 * Dado um nome do usuário, retorna o objeto correspondente no mapa.
	 * @param user Nick do usuário.
	 * @return Um objeto do tipo Usuario.
	 */
	private Usuario achaJogo(String user){
		return users.get(user);
	}
	
	private void adicionaCarteira(int money,String user){
		achaJogo(user).mudaCarteira(money);
	}
	
	private void compraJogo(Jogo game, String user) {
		Usuario usuario = achaJogo(user);
		usuario.compraJogo(game);
			
		}
	}
