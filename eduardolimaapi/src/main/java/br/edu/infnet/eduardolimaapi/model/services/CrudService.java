package br.edu.infnet.eduardolimaapi.model.services;

import java.util.List;

public interface CrudService<T, ID> {

	T alterar(ID id, T entity);
	T incluir(T entity);
	T buscarPorId(ID Id);
	void excluir(ID Id);
	List<T> obterLista();
}
