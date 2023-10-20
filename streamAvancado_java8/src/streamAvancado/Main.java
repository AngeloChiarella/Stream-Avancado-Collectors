package streamAvancado_java8.src.streamAvancado;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Funcionario> funcionarios = Arrays.asList(
				new Funcionario("José", 32, 4500.0, Arrays.asList("música", "futebol")),
				new Funcionario("Luana", 23, 2800.0, Arrays.asList("teatro", "academia")),
				new Funcionario("Paulo", 19, 1300.0, Arrays.asList("videogame", "leitura")),
				new Funcionario("Guilherme", 28, 5300.0, Arrays.asList("música", "pescar")),
				new Funcionario("Karina", 32, 4500.0, Arrays.asList("surfar", "futebol")),
				new Funcionario("Ana", 19, 1300.0, Arrays.asList("leitura", "arte")));

		/*
		 * ****************** SOMAR TODOS OS SALARIOS
		 */
		Metodos.somarSalarios(funcionarios);

		/*
		 * ****************** LISTAR TODOS OS HOBBIES
		 */

		Metodos.listarHobbies(funcionarios);

		/*
		 * ****************** MAPEAR FUNCIONARIOS POR HOBBIES
		 */

		Metodos.listarHobbiesPorNome(funcionarios);

		/*
		 * ****************** AGRUPAR FUNCIONARIOS POR IDADE
		 */

		Metodos.agruparPorIdade(funcionarios);

		/*
		 * ****************** AGRUPAR SALARIOS POR IDADE
		 */

		Metodos.agruparSalariosPorIdade(funcionarios);

		/*
		 * ****************** Lidar com performance
		 */

		// fazer testes para saber quando fica mais performatico levando em questao o tempo
		funcionarios.parallelStream().mapToDouble(Funcionario::getSalario).sum();

	}

}
