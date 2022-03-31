package idao;

import java.util.List;

public interface IDAO<T,K> {

	String urlBdd="jdbc:mysql://localhost:3306/poudlard";
	String loginBdd="root";
	String passwordBdd="";

	public T findById(K id);
	public List<T> findAll();
	public T insert(T o);
	public T update(T o);
	public void delete(K id);


}
