package com.senior.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService 
{
	@Autowired
	private Cidades cidades;
	
	public Cidade inserir(Cidade cidade)
	{
		return cidades.save(cidade);
	}
	
	
	public List<Cidadeaux> cidadeaux()
	{
				
		List < Object > result =  cidades.Quest6();

		Iterator itr = result.iterator();
		
		List<Cidadeaux> lista = new ArrayList<>();
		while(itr.hasNext())
		{
			Cidadeaux cidadeaux = new Cidadeaux();
			Object[] obj = (Object[]) itr.next();
			
			cidadeaux.setUf(String.valueOf(obj[0])); 
			cidadeaux.setQuant(Integer.parseInt(String.valueOf(obj[1]))); 
		   
			lista.add(cidadeaux);
		}
		
		return lista;
	}
	
	public List<Cidade> buscarTodos()
	{
		return cidades.findAll();
	}
	
	public List<Cidade> buscarUf(String UF)
	{
		return cidades.bucarUf(UF);
	}
	
	/*public Cidade buscarid(Long id)
	{
		return cidades.buscarId(id);
	}*/
	

}
