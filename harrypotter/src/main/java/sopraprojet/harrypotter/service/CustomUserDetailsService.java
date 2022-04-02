package sopraprojet.harrypotter.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.repositories.CompteRepository;
import sopraprojet.harrypotter.repositories.EleveRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepository;

	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserDetails u = compteRepository.findByLogin(login).orElseThrow(() -> {
			System.out.println("Eroro");
			throw new UsernameNotFoundException("utilisateur inconnu");
		});
		System.out.println("connect"+u);
		return u;
	}

}
