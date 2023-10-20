package streamAvancado_java8.src.streamAvancado;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Metodos {

	public Metodos() {
	}

	public static void somarSalarios(List<Funcionario> funcionarios) {
		System.out.println("		SOMAR TODOS OS SALARIOS \n");
		/*
		 * RETORNO -> DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
		 */
		double soma_mapToDouble = funcionarios.stream()
											  .mapToDouble(Funcionario::getSalario).sum();

		System.out.println("Soma Map To Double: " + soma_mapToDouble + "\n");

		/*
		 * RETORNO -> <R>Stream<R> map(Function<? super T, ? extends R> mapper);
		 */

		double valorInicial = 0.0;

		BinaryOperator<Double> acumulador = (x, y) -> {
			System.out.println(x + " + " + y);
			return x + y;
		};

		double soma_mapReduce = funcionarios.stream()
											.map(Funcionario::getSalario).reduce(valorInicial, acumulador);

		System.out.println("\nSoma Map Reduce: " + soma_mapReduce + "\n");
	}

	public static void listarHobbies(List<Funcionario> funcionarios) {
		System.out.println("(Collectors)		LISTAR TODOS OS HOBBIES \n");
		
		/*
		 * flatMap().collect() - achatamento dos dados
		 */
		
		List<String> toList = funcionarios.stream()
									      .flatMap(funcionario -> funcionario.getHobbies().stream())
									      .distinct() // remove valores duplicados
									      .collect(Collectors.toList());
		
		System.out.println("Collectors - toList: " + toList);

		Set<String> toSet = funcionarios.stream()
										.flatMap(funcionario -> funcionario.getHobbies().stream())
										.collect(Collectors.toSet());
		
		System.out.println("Collectors - toSet: " + toSet + "\n");
	}

	public static void listarHobbiesPorNome(List<Funcionario> funcionarios) {
		/* 
		 * Estrutura chave x valor 
		*/
		
		System.out.println("\n		LISTAR TODOS OS HOBBIES POR NOME \n");
		Map<String, List<String>> toMap = funcionarios.stream()
													  .collect(Collectors.toMap(Funcionario::getNome, Funcionario::getHobbies));

		System.out.println("toMap: " + toMap);
		System.out.println("\ntoMap (forEach): \n");

		funcionarios.stream()
					.collect(Collectors.toMap(Funcionario::getNome, Funcionario::getHobbies))
					.forEach((k, v) -> System.out.println(k + " = " + v));

	}

	public static void agruparPorIdade(List<Funcionario> funcionarios) {
		System.out.println("\n		AGRUPAR FUNCIONARIOS POR IDADE \n");
		
		Map<Integer, List<Funcionario>> groupingBy = funcionarios.stream()
																 .collect(Collectors.groupingBy(Funcionario::getIdade));

		System.out.println("groupingBy: " + groupingBy);
	}

	public static void agruparSalariosPorIdade(List<Funcionario> funcionarios) {
		System.out.println("\n		AGRUPAR SALARIOS POR IDADE \n");

		Map<Integer, List<Double>> groupingBy_mapping = funcionarios.stream()
																	.collect(
																			Collectors.groupingBy(Funcionario::getIdade, 
																					Collectors.mapping(Funcionario::getSalario, 
																							Collectors.toList()
																							)));
		System.out.println("groupingBy Mapping: " + groupingBy_mapping);
	}

}
