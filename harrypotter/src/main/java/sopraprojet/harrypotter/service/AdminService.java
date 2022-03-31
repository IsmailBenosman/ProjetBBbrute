package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compte.Admin;
import exception.AdminException;
import exception.EleveException;
import repositories.AdminRepository;

@Service
public class AdminService {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	

	public void create(Admin a) {
		if(a.getId()!=null){ 
			//probl�me
			throw new AdminException("l'id ne doit pas etre d�fini");
		}
		if(a.getLogin().isEmpty()) {
			throw new AdminException("Login manquant");
		}
		if(a.getPassword().isEmpty()) {
			throw new AdminException("Mot de passe manquant");
		}
		adminRepository.save(a);
	}

	public void update(Admin a) {
		if(a.getId()==null){ 
			throw new AdminException("l'id doit pas etre d�fini");
		}
		if(a.getLogin().isEmpty()) {
			throw new EleveException("Login manquant");
		}
		if(a.getPassword().isEmpty()) {
			throw new AdminException("Mot de passe manquant");
		}
		adminRepository.save(a);
	}

public List<Admin> getAll() {
	return adminRepository.findAll();
}
public Admin getById (Integer id) {
	return adminRepository.findById(id).orElseThrow(()->{
		throw new AdminException("numero inconnu");
	});
}	


public void delete (Admin a) {
	
	Admin adminEnBase = getById(a.getId());
	
	adminRepository.delete(adminEnBase);
	
}

public void deleteById (Integer id) {
	Admin admin=new Admin();
	admin.setId(id);
	delete(admin);
}






}