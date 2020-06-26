package challange;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {

		if (texto.isEmpty())
			throw new IllegalArgumentException("A string informada não pode estar vazia.");

		return inverte(texto, 3).toLowerCase();

	}

	@Override
	public String descriptografar(String texto) {

		if (texto.isEmpty())
			throw new IllegalArgumentException("A string informada não pode estar vazia.");

		return inverte(texto, -3).toLowerCase();

	}

	public static String inverte(String txtOriginal, int key) {

		final int TAM_ALFABETO = 26, INIC_MINUSCULA = 97, INIC_MAIUSCULA = 65;

		String txtAlterado = "";

		for (int x = 0; x < txtOriginal.length(); x++) {

			char cAtual = txtOriginal.charAt(x);

			if (!Character.isLetter(cAtual)) {
				txtAlterado += cAtual;
				continue;
			}

			int codAsciiCharAtual = (int) cAtual;
			boolean isMaiuscula = Character.isUpperCase(cAtual);

			int novaPosAlfab = ((codAsciiCharAtual
					- (isMaiuscula ? INIC_MAIUSCULA : INIC_MINUSCULA)) + key) % TAM_ALFABETO;

			if (novaPosAlfab < 0)
				novaPosAlfab += TAM_ALFABETO;

			int novaPosicAscii = (isMaiuscula ? INIC_MAIUSCULA : INIC_MINUSCULA) + novaPosAlfab;
			txtAlterado += Character.toString((char) novaPosicAscii);
		}
		return txtAlterado;
	}

}
