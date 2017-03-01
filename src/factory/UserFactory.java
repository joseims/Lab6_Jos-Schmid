package factory;

import lab.Usuario;
import papeis.*;

public class UserFactory {
	public static Usuario  criaUsuario(String nome,String nick,String func) throws Exception{
		Papel papel;
		if (func.equals("noob")) {
			papel = new Noob();		
		}
		else {
			papel = new Veterano();
		}
		Usuario a = new Usuario(nome,nick,papel);
		return a;
		
	}
}
