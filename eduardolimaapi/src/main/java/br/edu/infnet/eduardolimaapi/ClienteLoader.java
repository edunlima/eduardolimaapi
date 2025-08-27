package br.edu.infnet.eduardolimaapi;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.eduardolimaapi.model.domain.Cliente;
import br.edu.infnet.eduardolimaapi.model.services.ClienteService;

@Component
public class ClienteLoader implements ApplicationRunner {
	
	private final ClienteService clienteService;
	
	public ClienteLoader(ClienteService clienteService)
	{
		this.clienteService = clienteService;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	
	FileReader arquivo = new FileReader("cliente.txt");	
	BufferedReader leitura = new BufferedReader(arquivo);
	
	String linha = leitura.readLine();
	String[] valores = null;
		
	
	while(linha != null)
	{
		
	valores = linha.split(";");
	
	Cliente cliente= new Cliente();
	
	cliente.setNome(valores[0]);
	cliente.setIdade(Integer.valueOf(valores[1]));
	
	
	clienteService.incluir(cliente);
	
	System.out.println(cliente);
	
	linha = leitura.readLine();
	
	}
	
	leitura.close();
	
	
	}
}

	
