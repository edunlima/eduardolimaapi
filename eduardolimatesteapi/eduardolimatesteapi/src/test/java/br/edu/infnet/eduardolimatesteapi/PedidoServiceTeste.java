package br.edu.infnet.eduardolimatesteapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.infnet.eduardolimatesteapi.model.domain.Item;
import br.edu.infnet.eduardolimatesteapi.model.domain.ItemPedido;
import br.edu.infnet.eduardolimatesteapi.model.domain.Pedido;
import br.edu.infnet.eduardolimatesteapi.model.service.PedidoService;

public class PedidoServiceTeste {

	private PedidoService pedidoService;
	private Item item1;
	private Item item2;
	
	@BeforeEach
	void setUp()
	{
		pedidoService = new PedidoService();
		item1 = new Item("Coca-cola", new BigDecimal(5));
		item2 = new Item("Guarana", new BigDecimal(5));
	}
	
	@Test
	@DisplayName("O desconto percentual deve devolver o total com desconto se o pedido for válido.")
	void DeveDevolverOTotalComODescontoQuandoOPedidoForValido()
	{
		//Dado: Entrada de dados
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setItem(item1);
		itemPedido1.setQuantidade(1);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setItem(item2);
		itemPedido2.setQuantidade(3);
		
		List<ItemPedido> listaItensPedido = new ArrayList<ItemPedido>();
		listaItensPedido.add(itemPedido1);
		listaItensPedido.add(itemPedido2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(listaItensPedido);
		
		//Quando:

		BigDecimal descontoPercentual = new BigDecimal(10);
		BigDecimal totalEsperado = new BigDecimal(18);
		BigDecimal totalResultado = pedidoService.aplicarDescontoPercentual(pedido, descontoPercentual);
		
		//Entao:
		
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "Com desconto o resultado tem que dar 18");
		
	}
	
	//TODO REFAZER ISSO AQUI Q O ALGORITMO TA COPIADO DO DESCONTO
	@Test
	@DisplayName("O acrescimo percentual deve devolver o total com acrescimo se o pedido for válido.")
	void DeveDevolverOTotalComOAcrescimoQuandoOPedidoForValido()
	{
		//Dado:
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setItem(item1);
		itemPedido1.setQuantidade(1);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setItem(item2);
		itemPedido2.setQuantidade(3);
		
		List<ItemPedido> listaItensPedido = new ArrayList<ItemPedido>();
		listaItensPedido.add(itemPedido1);
		listaItensPedido.add(itemPedido2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(listaItensPedido);
		
		//Quando:

		BigDecimal descontoPercentual = new BigDecimal(10);
		BigDecimal totalEsperado = new BigDecimal(18);
		BigDecimal totalResultado = pedidoService.aplicarAcrescimoPercentual(pedido, descontoPercentual);
		
		//Entao:
		
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "Com acrescimo o resultado tem que dar algum ai vou ver");
		
	}
	
	@Test
	@DisplayName("O calculo do Total deve ser realizado corretamente com diferentes itens de pedido.")
	void DeveCalcularOTotalDosItensDePedidoCorretamenteQuandoNecessario()
	{
		
		//Dado: Entrada de dados
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setItem(item1);
		itemPedido1.setQuantidade(3);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setItem(item2);
		itemPedido2.setQuantidade(2);
		
		List<ItemPedido> listaItensPedido = new ArrayList<ItemPedido>();
		listaItensPedido.add(itemPedido1);
		listaItensPedido.add(itemPedido2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(listaItensPedido);
		
		//Quando: o calculo do total for chamado
		
		BigDecimal totalEsperado = new BigDecimal(25);
		BigDecimal totalResultado = pedidoService.totalPedido(pedido);
		
		//Entao:
		
		assertEquals(totalEsperado.compareTo(totalResultado), 0 , "O resultado deve ser 25.00");
	
	}
	
	@Test
	@DisplayName("O calculo do Total do Pedido deve devolver zero quando o pedido não tiver itens.")
	void DeveDevolverZeroQuandoOPedidoTiverZeroItensDePedido()
	{
		//Dado: Entrada de dados
		Pedido pedido = new Pedido();
		pedido.setItens(new ArrayList<>());
		//Quando: o totalPedido for chamado
		BigDecimal totalEsperado = BigDecimal.ZERO;
		BigDecimal totalResultado = pedidoService.totalPedido(pedido);
		
		//Entao:
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "O resultado tem que ser zero quando a lista tiver zero itens.");
		
	}
	
	@Test
	@DisplayName("O calculo do Total do Pedido deve devolver zero quando o pedido tiver itens nulos.")
	void DeveDevolverZeroQuandoOPedidoTiverItensNulos()
	{
		//Dado: Entrada de dados
		Pedido pedido = new Pedido();
		pedido.setItens(null);
		
		//Quando: o totalPedido for chamado
		BigDecimal totalEsperado = BigDecimal.ZERO;
		BigDecimal totalResultado = pedidoService.totalPedido(pedido);
						
		//Entao:
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "O resultado tem que dar zero quando a lista de itens estiver nula.");
		
		
	}
	
	@Test
	@DisplayName("O calculo do Total não deve ser alterado se o desconto for zero.")
	void DeveDevolverOValorTotalNormalQuandoODescontoForZero()
	{
		//Dado:
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setItem(item1);
		itemPedido1.setQuantidade(2);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setItem(item2);
		itemPedido2.setQuantidade(2);

		List<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
		listaDeItens.add(itemPedido1);
		listaDeItens.add(itemPedido2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(listaDeItens);
		
		//Quando:
		BigDecimal totalEsperado = new BigDecimal("20.00");
		BigDecimal totalResultado = pedidoService.aplicarDescontoPercentual(pedido, BigDecimal.ZERO);
						
		//Entao:
		
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "O resultado não tem desconto por isso o resultado é cheio: 20.00");
		
	}
	
	@Test
	@DisplayName("O calculo do Total não deve ser alterado se o acrescimo for zero.")
	void DeveDevolverOValorTotalNormalQuandoOAcrescimoForZero()
	{
		//Dado:
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setItem(item1);
		itemPedido1.setQuantidade(2);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setItem(item2);
		itemPedido2.setQuantidade(2);

		List<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
		listaDeItens.add(itemPedido1);
		listaDeItens.add(itemPedido2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(listaDeItens);
		
		//Quando:
		
		BigDecimal totalEsperado = new BigDecimal("20");
		BigDecimal totalResultado = pedidoService.aplicarAcrescimoPercentual(pedido, BigDecimal.ZERO);
						
		//Entao:
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "O valor total não deve ter acrescimo quando o acrescimo for zero por cento.");
		
	}
	
	@Test
	@DisplayName("Deve devolver o valor total zero quando o desconto for de 100%")
	void DeveDevolverOValorTotalZeroQuandoODescontoForCemPorCento()
	{
		//Dado:
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setItem(item1);
		itemPedido1.setQuantidade(2);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setItem(item2);
		itemPedido2.setQuantidade(2);

		List<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
		listaDeItens.add(itemPedido1);
		listaDeItens.add(itemPedido2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(listaDeItens);
		
		//Quando:
		
		BigDecimal totalEsperado = BigDecimal.ZERO;
		BigDecimal totalResultado = pedidoService.aplicarDescontoPercentual(pedido, new BigDecimal("100"));
		
		//Entao:
		
		assertEquals(totalEsperado.compareTo(totalResultado), 0, "O total deve retornar zero quando o desconto for de 100%");
		
		
		
	}
	
	@Test
	@DisplayName("Deve lançar um erro quando o desconto for maior que 100%.")
	void DeveLancarUmErroQuandoODescontoForMaiorQueCemPorCento()
	{
		//Dado: Entrada de dados
		ItemPedido itemPedidoMock = new ItemPedido();
		itemPedidoMock.setItem(item1);
		itemPedidoMock.setQuantidade(2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(List.of(itemPedidoMock));
		
		//Quando:
		BigDecimal descontoPercentual = new BigDecimal("101");
		
		//Entao:
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
														() -> pedidoService.aplicarDescontoPercentual(pedido, descontoPercentual), 
														"Deve lançar IllegalArgumentException para percentual maior que 100%");
		
		assertEquals("O percentual de desconto não pode ser maior que 100%", thrown.getMessage());
	
	}
	
}
