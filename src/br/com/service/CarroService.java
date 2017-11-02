package br.com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.CarroDao;
import br.com.domain.Carro;

public class CarroService {

	private CarroDao db = new CarroDao();

	// Lista os carros do banco
	public List<Carro> getCarros() {
		try {
			List<Carro> carros = db.getCarros();
			return carros;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Carro>();
		}
	}
	
	//busca um carro pelo id
	public Carro getCarro(Long id) {
		try {
			return db.getCarroById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//deleta um carro pelo id
	public boolean delete(Long id) {
		try {
			return db.deletar(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Salva um carro
	public boolean save (Carro carro) {
		try {
			db.save(carro);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//buca pelo nome
	public List<Carro> findByName(String nome){
		try {
			return db.findByName(nome);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Carro> findByType(String tipo){
		try {
			return db.findByTipo(tipo);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}




























