package br.edu.infnet.eduardolimaapi;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.eduardolimaapi.model.domain.Fornecedor;
import br.edu.infnet.eduardolimaapi.model.services.FornecedorService;

@Order(1)
@Component
public class FornecedorLoader implements ApplicationRunner {
	
	private final FornecedorService fornecedorService;
	
	public FornecedorLoader(FornecedorService fornecedorService)
	{
		this.fornecedorService = fornecedorService;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	FileReader arquivo = new FileReader("fornecedor.txt");	
	BufferedReader leitura = new BufferedReader(arquivo);
	
	String linha = leitura.readLine();
	String[] valores = null;
		
	
	while(linha != null)
	{
		
	valores = linha.split(";");
	
	Fornecedor fornecedor = new Fornecedor();
	
	fornecedor.setNome(valores[0]);
	fornecedor.setTelefone(valores[1]);
	fornecedor.setEmail(valores[2]);
	fornecedor.setCodigo(Integer.valueOf(valores[3]));
	
	fornecedorService.incluir(fornecedor);
	
	System.out.println(fornecedor);
	
	linha = leitura.readLine();
	
	}
	
	leitura.close();
	
	
	}
}

	
