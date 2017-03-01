package lab;

import java.util.HashMap;
import java.util.Set;

import papeis.Papel;

import checks.Check;
import excessões.JogoRepetido;
import excessões.UsuarioInexistente;
import excessões.ValorInvalido;
import factory.GameFact;
import factory.UserFactory;
import jogoVar.Jogo;

public class LojaController {
	private HashMap<String,Usuario> users;

	public LojaController(){
		users = new HashMap<String, Usuario>();
	}
	/**
	 * Dado um nome do usuário, retorna o objeto correspondente no mapa.
	 * @param user Nick do usuário.
	 * @return Um objeto do tipo Usuario.
	 * @throws Exception 
	 */
	private Usuario achaUsuario(String user) throws Exception{
		if (!usuarioCheck(user)) throw new UsuarioInexistente("Usuário Inexistente");
		return users.get(user);
	}
	/**
	 * Retorna a carteira de um usuário 
	 * @param user Identificação do usuario dono da carteira
	 */
	public double getCarteira(String user) throws Exception{
		Usuario a  = achaUsuario(user);
		return a.getCarteira();
		
	}
	public void addUsuario(String nome,String nick,String papel) throws Exception {
		Usuario a;
		a = UserFactory.criaUsuario(nome,nick,papel);
		users.put(a.getNick(), a);
	}
	private boolean usuarioCheck(String string){
		if (users.containsKey(string)) {return true;}
		return false;
	}

	/**
	 * Acrescenta valor a carteira do usuário.
	 * @param money Valor a ser adicionado.
	 * @param user Usuario dono da carteira.
	 */
	public void adicionaCarteira(double money,String user)throws Exception{
		if (!usuarioCheck(user)) throw new UsuarioInexistente("Usuário Inexistente");
		if (Check.ValorError(money)) throw new ValorInvalido("Dinheiro adicionado não pode ser negativo");
		achaUsuario(user).mudaCarteira(money);
	}
	/**
	 * Adiciona jogo à lista de jogos do usuario.
	 * @param game Jogo a ser adicionado.
	 * @param user Usuario que vai receber o jogo.
	 * @throws Exception
	 */
	public void compraJogo(String nome, String categoria,double preco,String tipo, String user) throws Exception {
		if (!usuarioCheck(user)) throw new UsuarioInexistente("Usuário Inexistente");
		Jogo game;
		game = GameFact.criaJogo(nome,categoria,preco,tipo);
		Usuario usuario = achaUsuario(user);
		if (usuario.jogoCheck(nome)) { throw new JogoRepetido("Usuário já possui este jogo");}
		usuario.compraJogo(game);
			
		}
	
	public void atualiza(String user) throws Exception{
		Usuario a = achaUsuario(user);
		a.atualizaPapel();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		LojaController other = (LojaController) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String a = "=== Central P2-CG ===\n\n";
		for (Usuario usuario : users.values()){
			a += usuario;
		}
		a += "\n--------------------------------------------";
		return a;
	}
	
	public int getX2p(String user) throws Exception{
		Usuario a = achaUsuario(user);
		return (int) a.getX2p();
	}
}
