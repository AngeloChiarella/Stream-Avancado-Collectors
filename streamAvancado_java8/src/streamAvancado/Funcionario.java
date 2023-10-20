package streamAvancado_java8.src.streamAvancado;

import java.util.List;

public class Funcionario {

	private String nome;
	private Integer idade;
	private Double salario;
	private List<String> hobbies;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, Integer idade, Double salario, List<String> hobbies) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.hobbies = hobbies;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return nome;
	}

}
