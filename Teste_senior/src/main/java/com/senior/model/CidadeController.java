package com.senior.model;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cidades")
public class CidadeController 
{
	@Autowired
	private CidadeService cidadeService;

	
	@GetMapping("/buscarCidade/{UF} ")
	public  ResponseEntity<List<Cidade>> buscarUF(@PathVariable String UF)
	{
		List<Cidade> cidades = cidadeService.buscarUf(UF);
		
		return ResponseEntity.ok().body(cidades);
	}
	
	
	@GetMapping("/buscar ")
	public  ResponseEntity<List<Cidade>> buscar()
	{
		List<Cidade> cidades = cidadeService.buscarTodos();
		
		return ResponseEntity.ok().body(cidades);
	}
	
	//quest 4	
	@GetMapping("/buscarGrupCidade")
	public  ResponseEntity<List<Cidadeaux>> buscar6()
	{
		List<Cidadeaux> cidades = cidadeService.cidadeaux();
		
		return ResponseEntity.ok().body(cidades);
	}
	
	/*//quest 5
	@GetMapping("/buscarID/{id}")
	public ResponseEntity<Cidade> buscarId(@PathVariable Long id) {
		Cidade cidades = cidadeService.buscarid(id);
		return ResponseEntity.ok().body(cidades);
	}*/

	
	
	//Quest 7
	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Cidade cidade)
	{
		cidade = cidadeService.inserir(cidade);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cidade.getIbge_id()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	



}
