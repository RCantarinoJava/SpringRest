package br.com.cantarino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cantarino.Models.Pessoa;
import br.com.cantarino.Models.Response;

import br.com.cantarino.Repository.PessoaRepositoryImpl;

@RestController
@RequestMapping("/service")
public class PessoaService 
{

	
	@Autowired
	private PessoaRepositoryImpl pessoaRepository; 
	
	
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response  Insert(@RequestBody Pessoa model) 
	{
		
		try
		{
			this.pessoaRepository.save(model);
			return new Response(1, "Salvo com sucesso");
		}
		catch(Exception ex)
		{
			return new Response(0, ex.getMessage());
		}
		
	}
	
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Optional<Pessoa> buscar(@PathVariable("codigo") Long codigo){
 
		return this.pessoaRepository.findById(codigo);
	}
 
	
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("codigo") Long codigo){
 
		
 
		try {
 
			pessoaRepository.deleteById(codigo);
 
			return new Response(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new Response(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/pessoa", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Pessoa>  GetAll() 
	{		
			return this.pessoaRepository.findAll();	
	}	
}
