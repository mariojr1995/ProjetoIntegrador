/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mario.validador;

import br.com.mario.modelos.Clientes;

/**
 *
 * @author Mario
 */
public class ValidadorVenda {
    
    public static String validar (Clientes cliente){
        
        if (cliente == null){
            return "Não foi informado um cliente";
        }
        
        
        return null;
    }
    
}
