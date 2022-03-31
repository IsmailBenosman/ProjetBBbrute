package idao;

import java.util.List;

import compte.Eleve;

public interface IDAOEleve extends IDAO<Eleve,Integer>{
	public List<Eleve> findAllByMaison(String maison);
}
