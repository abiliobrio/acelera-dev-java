package challange;

public class DesafioApplication {

	public static void main(String[] args) {
		
		CriptografiaCesariana cc = new CriptografiaCesariana();
		
		System.out.println(cc.criptografar("a ligeira raposa marrom saltou sobre o cachorro cansado"));
		
		System.out.println(cc.descriptografar("d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr"));

	}

}
