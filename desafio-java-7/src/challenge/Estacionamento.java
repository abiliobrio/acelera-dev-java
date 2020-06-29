package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	final int TOTALVAGAS = 10;
	final int PONTOSCARTEIRA = 20;
	final int IDADEMINIMA = 18;
	final int IDADEJOVEM = 55;

	private List<Carro> carros = new ArrayList<>();

	public void estacionar(Carro carro) {
		if (carro.getMotorista() == null) {
			throw new EstacionamentoException("N�o � permitido carro sem motorista cadastrado");
		}

		if (carro.getMotorista().getIdade() < IDADEMINIMA) {
			throw new EstacionamentoException("O motorista � menor de idade");
		}

		if (carro.getMotorista().getPontos() > PONTOSCARTEIRA) {
			throw new EstacionamentoException("Carteira de motorista suspensa");
		}

		if (carros.size() == TOTALVAGAS) {
			if (carrosEstacionadosComMotoristasJovens().isEmpty()) {
				throw new EstacionamentoException("N�o h� vaga dispon�vel");
			}
			carros.remove(carrosEstacionadosComMotoristasJovens().get(0));
		}
		carros.add(carro);
	}

	private List<Carro> carrosEstacionadosComMotoristasJovens() {
		List<Carro> carrosComMotoristasJovens = new ArrayList<>();
		for (Carro carro : carros) {
			if (carro.getMotorista().getIdade() <= IDADEJOVEM) {
				carrosComMotoristasJovens.add(carro);
			}
		}
		return carrosComMotoristasJovens;
	}

	public int carrosEstacionados() {
		return carros.size();
	}

	public boolean carroEstacionado(Carro carro) {
		return carros.contains(carro);
	}
}
