package com.ufes.prova1.dao;

import java.math.BigInteger;
import java.util.List;


public interface DAOInterface<T> {       

    public T get(BigInteger id);
	
    public void save(T obj);
	
    //public void update(T obj);

    public void delete(BigInteger id);

    public List<T> getAll();
}
