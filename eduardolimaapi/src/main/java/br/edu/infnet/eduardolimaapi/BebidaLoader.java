package br.edu.infnet.eduardolimaapi;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.eduardolimaapi.model.domain.Bebida;
import br.edu.infnet.eduardolimaapi.model.domain.Fornecedor;
import br.edu.infnet.eduardolimaapi.model.exceptions.BebidaInvalidaException;
import br.edu.infnet.eduardolimaapi.model.services.BebidaService;


@Component
public class BebidaLoader implements ApplicationRunner{
	
private final BebidaService bebidaService;	
	
	public BebidaLoader(BebidaService bebidaService)
	{
		this.bebidaService = bebidaService;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
	FileReader arquivo = new FileReader("bebidas.txt");	
	BufferedReader leitura = new BufferedReader(arquivo);
	
	String linha = leitura.readLine();
	String[] valores = null;
		
	
	while(linha != null)
	{
		
	valores = linha.split(";");
	
	Bebida bebida = new Bebida();
	Fornecedor fornecedor = new Fornecedor();
	
	bebida.setNome(valores[0]);
	bebida.setPreco(Double.valueOf(valores[1]));
	bebida.setDisponivel(Boolean.valueOf(valores[2]));
	bebida.setDentroDaValidade(Boolean.valueOf(valores[3]));
	bebida.setTipo(valores[4]);
	bebida.setCodigo(Integer.valueOf(valores[5]));
	
	fornecedor.setNome(valores[6]);
	fornecedor.setTelefone(valores[7]);
	fornecedor.setEmail(valores[8]);
	
	bebida.setFornecedor(fornecedor);
	
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
	
	
	System.out.println(bebida);
	
	linha = leitura.readLine();
	
	}
	
	leitura.close();
	
	
	
	}
	
	
}
