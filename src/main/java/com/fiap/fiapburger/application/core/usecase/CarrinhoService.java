/*
 * package com.fiap.fiapburger.adapter.driver.api.services;
 * 
 * import com.fiap.fiapburger.adapter.driver.api.model.CarrinhoDTO; import
 * com.fiap.fiapburger.adapter.driver.api.model.ItensPedidoDTO; import
 * org.springframework.stereotype.Service;
 * 
 * import java.util.*;
 * 
 * @Service public class CarrinhoService {
 * 
 * private static final Map<UUID, CarrinhoDTO> carrinhoMap = new HashMap<>();
 * 
 * public CarrinhoDTO adicionarItemCarrinho (CarrinhoDTO carrinho){ UUID id =
 * UUID.randomUUID(); Long numeroPedido = carrinhoMap.keySet().size() + 1L;
 * carrinho.setId(id); carrinho.setNumeroPedido(numeroPedido);
 * carrinho.setCodigoStatus("1");
 * carrinho.setDescricaoStatus("CARRINHO_ABERTO");
 * 
 * ItensPedidoDTO teste = carrinho.getPedido().getItensPedido().getFirst();
 * System.out.println("math pedido: " + teste.getValor()); float soma = 0;
 * for(int i = 0; i < carrinho.getPedido().getItensPedido().size(); i++ ){ soma
 * += carrinho.getPedido().getItensPedido().get(i).getValor(); }
 * 
 * carrinho.setTotal(soma);
 * 
 * carrinhoMap.put(id, carrinho); return carrinho; }
 * 
 * public CarrinhoDTO consultarCarrinhoById (UUID id){ return
 * carrinhoMap.get(id); }
 * 
 * public CarrinhoDTO atualizarItemCarrinho (UUID id, CarrinhoDTO carrinho){
 * carrinho.setId(id); carrinhoMap.put(id, carrinho); return carrinho; }
 * 
 * public CarrinhoDTO confirmarCarrinho (UUID id){ CarrinhoDTO carrinho = new
 * CarrinhoDTO(); carrinho = carrinhoMap.get(id); carrinho.setCodigoStatus("2");
 * carrinho.setDescricaoStatus("CARRINHO_CONFIRMADO"); carrinhoMap.put(id,
 * carrinho); return carrinho; }
 * 
 * public List<CarrinhoDTO> consultarListaCarrinho (){ return new
 * ArrayList<>(carrinhoMap.values()); }
 * 
 * public CarrinhoDTO deletarCarrinho (UUID id){ return carrinhoMap.remove(id);
 * }
 * 
 * }
 */