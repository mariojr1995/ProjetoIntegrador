/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mario.modelos;

/**
 *
 * @author Mario
 */
public class Venda {
    private Clientes cliente;
    private ItemDeVenda itemVenda;

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ItemDeVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemDeVenda itemVenda) {
        this.itemVenda = itemVenda;
    } 
    
}
