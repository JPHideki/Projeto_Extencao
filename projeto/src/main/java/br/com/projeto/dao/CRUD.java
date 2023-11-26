package br.com.projeto.dao;

import java.util.List;

public interface CRUD<T, ID> {
	
	T searchID(ID id);
	List<T> lista();
	void insert(T t);
	void update(T t);
	void remove(T t);

}
