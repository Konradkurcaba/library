package library.broker;

import java.util.List;

import javax.persistence.EntityManager;

import library.core.Constants;

public interface Broker<T>
{
	public List<T> getAll();
	public void commitChanges(List<T> aDtoList);
}
