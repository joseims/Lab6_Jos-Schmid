package lab;

public class LojaFacade {
	LojaController loja;
	public LojaFacade(){
		loja = new LojaController();
	}
	
	public void criaUsuario(String nome,String nick,String papel) throws Exception{
	loja.addUsuario(nome, nick, papel);
	}
	
	public void adicionaCredito(String user,double money) throws Exception{
		loja.adicionaCarteira(money, user);
	}
	
	public double ConfereCredito(String user) throws Exception {
		return loja.getCarteira(user);
		
	}
	public void upgrade(String user) throws Exception{
		loja.atualiza(user);
		
	}
	
	public int getX2p(String user) throws Exception{
		return loja.getX2p(user);
		
	}
}
