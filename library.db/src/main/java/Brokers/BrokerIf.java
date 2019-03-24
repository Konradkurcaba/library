package Brokers;

import java.util.List;

public interface BrokerIf<T>
{
	List<T> getAll();
	void commitChanges(List<T> aDtoList);
	void delete(List<T> aDtoList);
	T create();
}
