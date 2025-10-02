package br.edu.infnet.eduardolimatesteapi.model.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int numeroPedido;
	private LocalDateTime dataCriacao;
	private String cliente;
	private StatusPedido statusPedido;
	private List<ItemPedido> itens;
	
	public Pedido()
	{
		this.setDataCriacao(LocalDateTime.now());
		this.setStatusPedido(statusPedido.PENDENTE);
		//this.setNumeroPedido();
		this.setCliente(null);
		this.setItens(new ArrayList<ItemPedido>());
	}
	
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
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
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
}
