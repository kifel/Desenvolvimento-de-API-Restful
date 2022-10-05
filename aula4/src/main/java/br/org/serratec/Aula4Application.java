package br.org.serratec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.serratec.model.Pagamento;

@SpringBootApplication
public class Aula4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Aula4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pagamento pagamento = new Pagamento();

		System.out.printf("Total a pagar: %.2f", pagamento.calcularProcedimentos(200.0, 80.0));

	}
}
