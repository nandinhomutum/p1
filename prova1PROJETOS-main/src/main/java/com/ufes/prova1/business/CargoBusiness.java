package com.ufes.prova1.business;

import java.math.BigInteger;
import java.util.List;

import com.ufes.prova1.dao.CargoDAO;
import com.ufes.prova1.model.Cargo;
import com.ufes.prova1.utilidades.Notificador;

public class CargoBusiness {
	private static CargoBusiness INSTANCE;

	private CargoBusiness() {

	}

	public static CargoBusiness getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CargoBusiness();
			return INSTANCE;
		} else {
			return INSTANCE;
		}
	}
	
	public List<Cargo> getAll(){
		return CargoDAO.getCargoDAOInstance().getAll();
	}
	
	public Cargo get(BigInteger id) {
		return CargoDAO.getCargoDAOInstance().get(id);
	}
	
	public Cargo get(String nome) {
		return CargoDAO.getCargoDAOInstance().get(nome);
	}
	
	public void cadastrarCargo(String nome) {
		if (null != CargoDAO.getCargoDAOInstance().get(nome)) {
			System.out.println("Cargo " + nome + "  já existe!!!");
			Notificador.getInstance().disparaAviso("Cargo " + nome + " já existe!!!");
		} else {
			Cargo cargo = new Cargo();
			cargo.setNome(nome);
			save(cargo);
		}
	}
	
	public void update(BigInteger id, String nome) {
		Cargo cargo = get(id);
		cargo.setNome(nome);
		save(cargo);
	}
	
	public void save(Cargo cargo) {
		if (validate(cargo)) {
			if (null != cargo.getId()) {
				if (validaUpdate(cargo)) {
					CargoDAO.getCargoDAOInstance().save(cargo);
				}
			} else {
				CargoDAO.getCargoDAOInstance().save(cargo);
			}
		}
	}

	private Boolean validaUpdate(Cargo cargo) {
		Cargo cargoBanco = get(cargo.getNome());
		if (null != cargoBanco && !cargoBanco.getId().equals(cargo.getId())) {
			System.out.println("Já existe Cargo com nome " + cargo.getNome() + "!!!");
			Notificador.getInstance().disparaAviso("Já existe Cargo com nome " + cargo.getNome() + "!!!");
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
	
	private Boolean validate(Cargo cargo) {
		if(null == cargo.getNome() || "".equals(cargo.getNome())) {
			System.out.println("Nome do Cargo não pode Estar com nome Vazio");
			Notificador.getInstance().disparaAviso("Nome do Cargo não pode Estar com nome Vazio");
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
	
	public void delete(BigInteger id) {
		CargoDAO.getCargoDAOInstance().delete(id);
	}
}
