package br.edu.infnet.eduardolimatesteapi.model.domain;

import java.math.BigDecimal;

public class ItemPedido {

	private Item item;
	private int quantidade;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal calcularSubTotal()
	{	
		if(quantidade <= 0 || item.getPreco() == null) return BigDecimal.ZERO;
		if(item.getNome() == null && item.getPreco() == null) return BigDecimal.ZERO;
		
		BigDecimal resultado = item.getPreco();
		return resultado.multiply(new BigDecimal(quantidade));		
	}
	
	
}
