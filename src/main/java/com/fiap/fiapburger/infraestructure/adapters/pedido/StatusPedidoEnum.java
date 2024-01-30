package com.fiap.fiapburger.infraestructure.adapters.pedido;

public enum StatusPedidoEnum {

	PEDIDO_ABERTO("Pedido aberto"),
	PEDIDO_CONFIRMADO("Pedido confirmado"),
	PAGAMENTO_EFETUADO("Pagamento efetuado"),
	PEDIDO_RECEBIDO("Pedido recebido"),
	PEDIDO_EM_PREPARO("Pedido em preparo"),
	PEDIDO_PRONTO("Pedido pronto!"),
	PEDIDO_ENTREGUE("Pedido entregue ao cliente");


	private String value;

	private StatusPedidoEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}

}
