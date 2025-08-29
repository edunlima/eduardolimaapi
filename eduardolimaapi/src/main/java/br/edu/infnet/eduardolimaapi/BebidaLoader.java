package br.edu.infnet.eduardolimaapi;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.eduardolimaapi.model.domain.Bebida;
import br.edu.infnet.eduardolimaapi.model.domain.Fornecedor;
import br.edu.infnet.eduardolimaapi.model.exceptions.BebidaInvalidaException;
import br.edu.infnet.eduardolimaapi.model.exceptions.FornecedorNaoEncontradoException;
import br.edu.infnet.eduardolimaapi.model.services.BebidaService;
import br.edu.infnet.eduardolimaapi.model.services.FornecedorService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Order(2)
@Component
public class BebidaLoader implements ApplicationRunner{
	
private final BebidaService bebidaService;	
private final FornecedorService fornecedorService;
	
	public BebidaLoader(BebidaService bebidaService, FornecedorService fornecedorService)
	{
		this.bebidaService = bebidaService;
		this.fornecedorService = fornecedorService;
	}
	
	//Professor, tentei d todo jeito fazer isso funcionar sem o @Transactional mas não rolou
	//ficava dando detached entity passed to persist
	//enfim, ta funcionando, perdão o comentario
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
	
	FileReader arquivo = new FileReader("bebidas.txt");	
	BufferedReader leitura = new BufferedReader(arquivo);
	
	String linha = leitura.readLine();
	String[] valores = null;
		
	
	while(linha != null)
	{
		
	valores = linha.split(";");
	
	Integer codigo = Integer.valueOf(valores[5]);
	
	Fornecedor fornecedor = null;
	
	try {
	
		fornecedor = fornecedorService.obterPorCodigo(codigo);
		if(fornecedor == null)
		{
			System.err.println("Fornecedor nulo!");
			linha = leitura.readLine();
			continue;
		}

	}
	catch(FornecedorNaoEncontradoException e)
	{
		linha = leitura.readLine();
		continue;
	} 
	
/*	Fornecedor fornecedor = new Fornecedor();
	
	fornecedor.setNome("Eduardo");
	fornecedor.setEmail("eduardo@lima.com");
	fornecedor.setCodigo(8932);*/
	
	Bebida bebida = new Bebida();
	
	bebida.setNome(valores[0]);
	bebida.setPreco(Double.valueOf(valores[1]));
	bebida.setDisponivel(Boolean.valueOf(valores[2]));
	bebida.setDentroDaValidade(Boolean.valueOf(valores[3]));
	bebida.setTipo(valores[4]);
	
	bebida.setFornecedor(fornecedor);
//	bebida.setCodigo(Integer.valueOf(valores[5]));
	
	try {
		
		bebidaService.incluir(bebida);	
		
		System.out.println("A bebida foi incluida com sucesso!");
		
	}
	catch(IllegalArgumentException e)
	{
		System.err.println("A bebida é invalida por apresentar argumentos não coerentes!");
	}
	catch(BebidaInvalidaException e)
	{
		System.err.println("A bebida é invalida por não ter nome!");
	}
	catch(Exception e)
	{
		System.err.println(e.getMessage());
	}
	
	
	System.out.println(bebida);
	
	linha = leitura.readLine();
	
	}
	
	leitura.close();
	
	
	
	}
	
	
}
