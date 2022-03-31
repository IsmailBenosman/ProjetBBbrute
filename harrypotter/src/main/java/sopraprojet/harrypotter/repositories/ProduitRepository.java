package repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import boutique.Produit;



public interface ProduitRepository extends JpaRepository<Produit,Integer>  {


}
