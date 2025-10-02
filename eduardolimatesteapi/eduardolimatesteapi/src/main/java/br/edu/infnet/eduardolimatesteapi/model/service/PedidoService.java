package br.edu.infnet.eduardolimatesteapi.model.service;

import java.math.BigDecimal;
import java.util.Objects;
import org.springframework.stereotype.Service;

import br.edu.infnet.eduardolimatesteapi.model.domain.ItemPedido;
import br.edu.infnet.eduardolimatesteapi.model.domain.Pedido;


@Service
public class PedidoService {
	
	public BigDecimal totalPedido(Pedido pedido)
	{
		if(Objects.isNull(pedido))
		{
			return BigDecimal.ZERO;
		}
		
		if(Objects.isNull(pedido.getItens()) || pedido.getItens().isEmpty())
		{
			return BigDecimal.ZERO;
		}
		
		BigDecimal valorTotal = BigDecimal.ZERO;
		for(ItemPedido item : pedido.getItens())
		{
			valorTotal = valorTotal.add(item.calcularSubTotal());
		}
		
		return valorTotal;
	}
	
	public BigDecimal aplicarDescontoPercentual(Pedido pedido, BigDecimal descontoPercentual)
	{
		BigDecimal descontoMaximo = new BigDecimal("100");
		
		if(descontoPercentual.compareTo(descontoMaximo) > 0)
		{
			throw new IllegalArgumentException("O percentual de desconto não pode ser maior que 100%");
		}
		BigDecimal descontoMatematico = descontoPercentual.multiply(new BigDecimal("0.01"));
		BigDecimal valorParaDesconto = totalPedido(pedido).multiply(descontoMatematico);
		
		return totalPedido(pedido).subtract(valorParaDesconto);
	}
	
	public BigDecimal aplicarAcrescimoPercentual(Pedido pedido, BigDecimal acrescimoPercentual)
	{
		BigDecimal acrescimoMatematico = acrescimoPercentual.multiply(new BigDecimal("0.01"));
		BigDecimal valorParaAcrescimo = totalPedido(pedido).multiply(acrescimoMatematico);
		
		return totalPedido(pedido).subtract(valorParaAcrescimo);
	}

}
