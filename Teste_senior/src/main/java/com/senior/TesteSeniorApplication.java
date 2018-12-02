package com.senior;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.senior.model.*;

@SpringBootApplication
public class TesteSeniorApplication implements CommandLineRunner {
	@Autowired
	private  CidadeService cidadeService;
	 

	public static void main(String[] args) {
		SpringApplication.run(TesteSeniorApplication.class, args);	
		
				
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		String arquivoCSV = "C:\\Users\\LUCAS\\Documents\\senior\\Teste_senior\\arquivo.csv";
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ",";
	    
	    
	    
	    boolean primeiraLinha = true;	   
	    
	    
	    try {

	        br = new BufferedReader(new FileReader(arquivoCSV));
	        while ((linha = br.readLine()) != null) {
	        	
	            if (primeiraLinha) {
	    	        primeiraLinha = false;
	    	        continue;
	    	      }
	    	    
	           //
	            Cidade cidade = new Cidade();
	            //colocando os dados do csv em uma array de string
	            String[] cidadeCSV = linha.split(csvDivisor);
	            //setando vaolres no objeto 
	            cidade.setMesoregion(cidadeCSV [cidadeCSV .length-1]);
	            cidade.setMicroregion(cidadeCSV [cidadeCSV .length-2]);
	            cidade.setAltermative_names(cidadeCSV [cidadeCSV .length-3]);
	            cidade.setNo_accents(cidadeCSV [cidadeCSV .length-4]);
	            cidade.setLat(Double.parseDouble(cidadeCSV [cidadeCSV .length-5]));
	            cidade.setLon(Double.parseDouble(cidadeCSV [cidadeCSV .length-6]));
	            cidade.setCapital (cidadeCSV [cidadeCSV .length-7]);
	            cidade.setName (cidadeCSV [cidadeCSV .length-8]);
	            cidade.setUf(cidadeCSV [cidadeCSV .length-9]);  
	            cidade.setIbge_id(Long.parseLong(cidadeCSV [cidadeCSV .length-10]));     
	            
	            
	            

	            //inserir no banaco
	          
	            cidade = cidadeService.inserir(cidade);
	            

	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
	}
	
	
	
}
