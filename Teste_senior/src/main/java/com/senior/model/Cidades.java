package com.senior.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Cidades extends JpaRepository<Cidade, Long>{
	
	@Query(value="select uf, count(uf) from cidade group by uf having count(uf) >1",nativeQuery=true)
	public List<Object> Quest6 ();
	@Query(value="select * from cidade where uf = UF",nativeQuery= true)
	public List<Cidade> bucarUf(String UF);
	
	/*public Cidade buscarId(Long id);*/
	
}
