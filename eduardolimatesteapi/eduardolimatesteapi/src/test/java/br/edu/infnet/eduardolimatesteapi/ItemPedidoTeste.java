package br.edu.infnet.eduardolimatesteapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.infnet.eduardolimatesteapi.model.domain.Item;
import br.edu.infnet.eduardolimatesteapi.model.domain.ItemPedido;
import br.edu.infnet.eduardolimatesteapi.model.domain.Pedido;

public class ItemPedidoTeste {

	@Test
	@DisplayName("Deve retornar zero quando não houver nenhum item.")
	void DeveMostrarZeroQuandoCalcularSubTotalForZero()
	{
		//Dado: um item do pedido
		ItemPedido item = new ItemPedido();
		item.setQuantidade(0);
		
		//Quando: o subtotal for calculado
		BigDecimal subTotalEsperado = BigDecimal.ZERO;
		BigDecimal subTotalRealizado = item.calcularSubTotal();
		
		//Entao:
		assertEquals(subTotalEsperado, subTotalRealizado, "O subtotal deve ser 0 para esse item.");
		
	}
	
	@Test
	@DisplayName("Deve mostrar o resultado do subcalculo do item somente quando for válido.")
	void DeveMostrarOResultadoDoSubTotalQuandoItemForValido()
	{
		//Dado: Entrada de dados
		Item item = new Item("Coca-cola", new BigDecimal(2.50));
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setItem(item);
		itemPedido.setQuantidade(3);
		
		//Quando: O item for valido e o subcalculo for realizado
		BigDecimal subtotalEsperado = new BigDecimal(7.50);
		BigDecimal subtotalResultado = itemPedido.calcularSubTotal();
		
		//Entao:
		assertEquals(subtotalEsperado, subtotalResultado, "O subtotal deve ser 7.50");
		
	}
	
	@Test
	@DisplayName("Deve mostrar zero quando a quantidade do item for negativa.")
	void DeveMostrarZeroQuandoItemForNegativo()
	{
		//Dado: Entrada de dados
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setQuantidade(-1);
		
		//Quando: o subcalculo for chamado
		BigDecimal subtotalEsperado = BigDecimal.ZERO;
		BigDecimal subtotalResultado = itemPedido.calcularSubTotal();
			
		//Entao:
		assertEquals(subtotalEsperado, subtotalResultado, "O subtotal deve ser zero quando a quantidade for negativa.");
		
	}
	
	@Test
	@DisplayName("Deve mostrar zero quando o preço do item for nulo")
	void DeveMostrarZeroQuandoPrecoDoItemForNulo()
	{
		//Dado: Entrada de dados
		Item item = new Item("Coca-cola", null);
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setItem(item);
		
		//Quando: o subcalculo for chamado
		BigDecimal subtotalEsperado = BigDecimal.ZERO;
		BigDecimal subtotalResultado = itemPedido.calcularSubTotal();
				
		//Entao:
		assertEquals(subtotalEsperado, subtotalResultado, "O subtotal deve ser zero quando o preço do item for nulo.");
		
	}
	
	@Test
	@DisplayName("Deve mostrar zero quando o item for inválido.")
	void DeveMostrarZeroQuandoItemForInvalido()
	{
		//Dado: Entrada de dados
		Item item = new Item(null, null);
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setItem(item);
		
		//Quando: o subcalculo for chamado
		BigDecimal subtotalEsperado = BigDecimal.ZERO;
		BigDecimal subtotalResultado = itemPedido.calcularSubTotal();				
		//Entao:
		
		assertEquals(subtotalEsperado, subtotalResultado, "O subtotal deve ser zero quando o item for inválido.");
	}
}
