package sopraprojet.harrypotter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sopraprojet.harrypotter.compte.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}