package br.edu.infnet.eduardolimatesteapi.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int numeroPedido;
	private StatusPedido statusPedido;
	private List<Item> itens = new ArrayList<Item>();
	
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
}
