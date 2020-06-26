package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> listaTimes = new ArrayList<Time>();
	List<Jogador> listaJogadores = new ArrayList<Jogador>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {

		if (listaTimes.stream().anyMatch(time -> time.getId().equals(id))) {
			throw new IdentificadorUtilizadoException();
		}

		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		listaTimes.add(time);

	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {

		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		Time time = buscarTime(idTime);

		if (time.listaJogadores().stream().anyMatch(jogador -> jogador.getId().equals(id))) {
			throw new IdentificadorUtilizadoException();
		}

		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		time.addJogadorTime(jogador);
		listaJogadores.add(jogador);

//		throw new UnsupportedOperationException();
	}

	public void definirCapitao(Long idJogador) {

		if (listaJogadores.stream().noneMatch(jogador -> jogador.getId().equals(idJogador))) {
			throw new JogadorNaoEncontradoException();
		}

		Jogador jogador = buscarJogador(idJogador);
		Time time = buscarTime(jogador.getIdTime());

		time.setCapitao(idJogador);

	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		Time time = buscarTime(idTime);
		if (time.getCapitao() == null) {
			throw new CapitaoNaoInformadoException();
		}

		return time.getCapitao();
	}

	public String buscarNomeJogador(Long idJogador) {
		if (listaJogadores.stream().noneMatch(jogador -> jogador.getId().equals(idJogador))) {
			throw new JogadorNaoEncontradoException();
		}

		return buscarJogador(idJogador).getNome();
	}

	public String buscarNomeTime(Long idTime) {
		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		return buscarTime(idTime).getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		Time time = buscarTime(idTime);

		if (time.listaJogadores().isEmpty()) {
			throw new JogadorNaoEncontradoException();
		}

		return time.listaJogadores().stream().map(Jogador::getId).collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		Time time = buscarTime(idTime);
		if (time.listaJogadores().isEmpty()) {
			throw new JogadorNaoEncontradoException();
		}

		List<Jogador> melhorJogador = time.listaJogadores().stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()).collect(Collectors.toList());
		return melhorJogador.get(0).getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		Time time = buscarTime(idTime);
		if (time.listaJogadores().isEmpty()) {
			throw new JogadorNaoEncontradoException();
		}

		List<Jogador> jogadorVelho = time.listaJogadores().stream()
				.sorted(Comparator.comparing(Jogador::getDataNascimento)).collect(Collectors.toList());
		return jogadorVelho.get(0).getId();
	}

	public List<Long> buscarTimes() {

		List<Long> timesEncontrados = new ArrayList<>();
		if (listaTimes.isEmpty()) {
			return timesEncontrados;
		}
		timesEncontrados = listaTimes.stream().map(Time::getId).collect(Collectors.toList());
		return timesEncontrados;

	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (listaTimes.stream().noneMatch(time -> time.getId().equals(idTime))) {
			throw new TimeNaoEncontradoException();
		}

		Time time = buscarTime(idTime);
		if (time.listaJogadores().isEmpty()) {
			throw new JogadorNaoEncontradoException();
		}

		List<Jogador> maiorSalario = time.listaJogadores().stream()
				.sorted(Comparator.comparing(Jogador::getSalario).reversed()).collect(Collectors.toList());
		return maiorSalario.get(0).getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (listaJogadores.stream().noneMatch(jogador -> jogador.getId().equals(idJogador))) {
			throw new JogadorNaoEncontradoException();
		}

		return buscarJogador(idJogador).getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Jogador> nivelJogadores = listaJogadores.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).
				reversed()).collect(Collectors.toList());
		List<Long> topJogadores = new ArrayList<>();
		if (listaJogadores.isEmpty()) {
			return topJogadores;
		}
		for (int i = 0; i < top; i++) {
			topJogadores.add(nivelJogadores.get(i).getId());
		}
		return topJogadores;
	}

	public Time buscarTime(Long idTime) {
		List<Time> timeEncontrado = listaTimes.stream().filter(time -> time.getId().equals(idTime))
				.collect(Collectors.toList());
		return timeEncontrado.get(0);
	}

	public Jogador buscarJogador(Long idJogador) {
		List<Jogador> jogadorLocaliz = listaJogadores.stream().filter(jogador -> jogador.getId().equals(idJogador))
				.collect(Collectors.toList());
		return jogadorLocaliz.get(0);
	}

}
