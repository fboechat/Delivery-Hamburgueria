package br.com.becajava.DeliveryMySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryMySqlApplication.class, args);
	}

	//
	// criando usuarios de teste
	// apagar depois
	//
	/*
	@Bean
	CommandLineRunner init(UsuarioRepository repositorio) {
		return args -> {
			repositorio.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Usuario c = new Usuario();
						c.setNome("Contact " + i);
						c.setEmail("contact" + i + "@gmail.com");
						c.setTelefone("(21) 111-1111");
						return c;
					})
					.map(v -> repositorio.save(v))
					.forEach(System.out::println);
		};


	}

	 */
}
