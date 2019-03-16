package library.broker;

import java.util.List;

import javax.persistence.EntityManager;

import library.core.Constants;

public interface BrokerIf<T>
{
	public List<T> getAll();
	public void commitChanges(List<T> aDtoList);
	public void delete(List<T> aDtoList);
	public T create();
}
