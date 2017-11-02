package br.com.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.domain.Carro;
import br.com.service.CarroService;

public class CarroTest {

	private CarroService service = new CarroService();
	
	@Test
	public void listarTodos() {
		List<Carro> carros= service.getCarros();
		assertNotNull(carros);
		//Valida se encontrou algo
		assertTrue(carros.size()>0);
		//Valida se encontrou o Trucker
		Carro trucker = service.findByName("Trucker 1948").get(0);
		assertEquals("Trucker 1948", trucker.getNome());
	}

}











