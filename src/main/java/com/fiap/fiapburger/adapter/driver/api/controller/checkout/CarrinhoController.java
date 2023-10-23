package com.fiap.fiapburger.adapter.driver.api.controller.checkout;

import com.fiap.fiapburger.adapter.driver.api.model.CarrinhoDTO;
import com.fiap.fiapburger.adapter.driver.api.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/carrinho", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    @ResponseBody
    public CarrinhoDTO criarCarrinho(@RequestBody CarrinhoDTO carrinho){
        return carrinhoService.adicionarItemCarrinho(carrinho);
    }

    @GetMapping
    @ResponseBody
    public CarrinhoDTO consultaCarrinho(@RequestParam UUID id){
        return carrinhoService.consultarCarrinhoById(id);
    }

    @GetMapping("/lista")
    @ResponseBody
    public List<CarrinhoDTO> consultaListaCarrinho(){
        return carrinhoService.consultarListaCarrinho();
    }

    @PutMapping
    @ResponseBody
    public CarrinhoDTO atualizarItemCarrinho(@RequestParam UUID id, @RequestBody CarrinhoDTO carrinho){
        return carrinhoService.atualizarItemCarrinho(id, carrinho);
    }

    @DeleteMapping
    @ResponseBody
    public CarrinhoDTO deletarItemCarrinho(@RequestParam UUID id){
        return carrinhoService.deletarCarrinho(id);
    }

    @PatchMapping
    @ResponseBody
    public CarrinhoDTO confirmarCarrinho(@RequestParam UUID id){
        return carrinhoService.confirmarCarrinho(id);
    }

}
