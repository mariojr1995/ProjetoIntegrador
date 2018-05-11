
package br.com.mario.validador;

import br.com.mario.modelos.Produto;

// rubens.huneke
// Validador de dados do produto
public class ValidadorProduto {

    public static String validar(Produto produto) {
        //Realização de validações de negócio
        //Verifica se foi especificado um produto
        if (produto == null) {
            return "Não foi informado um produto";
        }

        //Verifica se o produto tem nome definido
        if (produto.getNome() == null || "".equals(produto.getNome())) {
            return "É necessário informar um nome de produto";
        }

        //Verifica se o produto tem preço de venda
        if (Float.toString(produto.getPrecoVenda()) == null
                || "".equals(produto.getPrecoVenda())
                || (produto.getPrecoVenda())<=0) {
            return "É necessário informar o preço de venda do produto e não pode ser ZERO";
        }
        
        //Verifica se o produto tem preço de custo
        if (Float.toString(produto.getPrecoCusto()) == null
                || "".equals(produto.getPrecoCusto())
                || (produto.getPrecoCusto())<=0) {
            return "É necessário informar o preço de custo do produto e não pode ser ZERO";
        }
        
        //Verifica se o produto tem quantidade informada
        if (String.valueOf(produto.getQuantidade()) == null
                || "".equals(produto.getQuantidade())
                || produto.getQuantidade()<=0) {
            return "É necessário informar a quantidade do produto e não pode ser ZERO";
        }
        
        //Verifica se o produto tem descrição
        if (produto.getDescricao() == null || "".equals(produto.getDescricao())) {
            return "É necessário informar a descrição do produto";
        }
        
        //Verifica se o produto tem fornecedor
        if (produto.getFornecedor() == null || "".equals(produto.getFornecedor())) {
            return "É necessário informar a descrição do produto";
        }
        
        //Verifica se o produto descrição
        if (produto.getCnpj() == null || "".equals(produto.getCnpj())) {
            return "É necessário informar a descrição do produto";
        }
       

        //Retorna "null" indicando que todas as validações foram feitas e o
        //produto é um produto válido de acordo com as necessidades do negócio
        return null;
    }
    
}

