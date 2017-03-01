package checks;

public class Check {
	public static boolean StringError (String a) {
		if("".equals(a.trim()) || a == null) { return true;}
		return false;
	}
	
	public static boolean ValorError(double a) {
		if (a < 0) {return true;}
		return false;
	}
	
	public static boolean NullError(Object a) {
		if ( a == null) {return true;}
		return false;
	}
}
	
	