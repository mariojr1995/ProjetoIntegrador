/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mario.mock;

import br.com.mario.modelos.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rubens.huneke
 */
public class MockProduto {

    //Sequência de IDs para cadastro de produtos    
    private static int sequenciaIdProdutos = 0;
    
    //Armazena a lista de produtos inseridos para manipulação em memória
    //PRINCIPAL ITEM DA FONTE DE DADOS
    private static List<Produto> listaProdutos = new ArrayList<Produto>();

    //Insere um produto no mock "produto"
    public static void inserir(Produto produto)
            throws Exception {

        //Configura um ID para o produto usando a variável de sequência de
        //produtos e a incrementando em seguida
        produto.setId(sequenciaIdProdutos++);
        
        //Adiciona o produto na lista em memória
        listaProdutos.add(produto);

    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produtoAtualizacao)
            throws Exception {

        //Verifica se foi fornecido um produto para atualização (é diferente de
        //de null e tem um ID fornecido) e se a lista de produtos em memória
        //não está vazia antes de tentar iniciar a atualização
        if (produtoAtualizacao != null
                && produtoAtualizacao.getId() != null
                && listaProdutos.size() > 0) {

            //Se há um produto a atualizar e a lista não está vazia, percorremos
            //a lista até encontrar o produto com o mesmo ID do cliente
            //fornecido para atualização. Quando o encontrar-mos, atualizamos
            //seus dados (menos o ID) e configuramos a flag adequada para sair
            //do while
            int contador = 0;
            boolean produtoAtualizado = false;
            while (contador < listaProdutos.size() && !produtoAtualizado) {
                
                //Obtém o produto da posição corrente da lista
                Produto produtoLista = listaProdutos.get(contador);

                //Se há um produto nesta posição da lista e o ID dele é igual
                //ao ID do produto fornecido como parâmetro para atualização,
                //atualizamos seus dados e paramos a pesquisa com a flag
                if (produtoLista != null
                        && produtoLista.getId() == produtoAtualizacao.getId()) {

                    //Atualização dos dados no objeto de modelo de produto
                    produtoLista.setNome(
                            produtoAtualizacao.getNome()
                    );

                    produtoLista.setPrecoVenda(
                            produtoAtualizacao.getPrecoVenda()
                    );
                    
                    produtoLista.setPrecoCusto(
                            produtoAtualizacao.getPrecoCusto()
                    );
                    
                    produtoLista.setEan(
                            produtoAtualizacao.getEan()
                    );
                    
                    produtoLista.setQuantidade(
                            produtoAtualizacao.getQuantidade()
                    );
                    
                    produtoLista.setDescricao(
                            produtoAtualizacao.getDescricao()
                    );
                    
                    produtoLista.setFornecedor(
                            produtoAtualizacao.getFornecedor()
                    );
                    
                    produtoLista.setCnpj(
                            produtoAtualizacao.getCnpj()
                    );
                    
                    produtoLista.setNivel1(
                            produtoAtualizacao.getNivel1()
                    );
                    
                    produtoLista.setNivel2(
                            produtoAtualizacao.getNivel2()
                    );
                    
                    produtoLista.setNivel3(
                            produtoAtualizacao.getNivel3()
                    );

                    //Configura a flag indicando que a atualização foi realizada
                    produtoAtualizado = true;
                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contador++;
            }

        }
        //Se não foi fornecido um produto para atualizar ou não há produtos
        //na lista de produtos, lança um erro (outra classe que usar esse
        //método terá que usar um try/catch para tratar isso)
        else {
            throw new Exception("Não há produto para atualizar");
        }

    }

    //Realiza a exclusão de um produto no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(int id) throws Exception {

        //Verifica se a lista de produtos em memória não está vazia antes de
        //tentar iniciar a exclusão
        if (listaProdutos.size() > 0) {

            //Se há um id de produto para remoção e a lista não está vazia,
            //percorremos a lista até encontrar o produto com o mesmo ID do
            //produto fornecido para remoção. Quando o encontrar-mos, removemos
            //esse produto da lista de produtos e paramos a pesquisa com a flag
            int contadorPosicao = 0;
            boolean produtoRemovido = false;
            while (contadorPosicao < listaProdutos.size() && !produtoRemovido) {
                //Obtém o produto da posição corrente da lista
                Produto produtoLista = listaProdutos.get(contadorPosicao);

                //Verifica se há produto cadastrado corretamente nessa posição
                //da lista e se o mesmo tem ID igual ao ID do cliente a ser
                //removido (parâmetro deste método). Caso verdadeiro, remove o
                //produto daquela posição da lista e pára a procura
                if (produtoLista != null && produtoLista.getId() == id) {
                    listaProdutos.remove(contadorPosicao);
                    produtoRemovido = true;
                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }
            
        }
        //Se não há produtos na lista de produtos, lança um erro (outra classe
        //que usar esse método terá que usar um try/catch para tratar isso)
        else {
            
            throw new Exception("Não há produto para remover");
            
        }
        
    }

    //Lista todos os produtos
    public static List<Produto> listar()
            throws Exception {
        
        //Simplesmente retorna a lista de produtos
        return listaProdutos;
        
    }

    //Procura um produto no mock, de acordo com o nome
    //ou com o cnpj, passados como parâmetro
    public static List<Produto> procurar(String valor)
            throws Exception {
        
        //Primeiro, montamos uma lista de resultados que irá armazenar todos os
        //produtos encontrados que atendem o critério de pesquisa especificado
        //Começa vazia, mas instanciada
        List<Produto> listaResultado = new ArrayList<Produto>();

        //Verifica se foi fornecido um parâmetro para pesquisa e também se a
        //lista de produtos em memória não está vazia antes de tentar iniciar
        //a busca
        if (valor != null && listaProdutos.size() > 0) {

            //Se há valor para pesquisa e a lista não está vazia, vamos
            //percorrer a lista toda e encontrar produtos cujo nome e/ou
            //cnpj contenham o parâmetro de valor informado no método.
            //Quando um produto atender a estes critérios, o adicionamos na
            //lista auxiliar de resultados de pesquisa (listaResultado).
            //A busca deve ir até o final aqui, por isso não há flag de controle
            int contadorPosicao = 0;
            while (contadorPosicao < listaProdutos.size()) {
                
                //Obtém o produto da posição corrente da lista
                Produto produtoLista = listaProdutos.get(contadorPosicao);

                //Verifica se há produto cadastrado corretamente nessa posição
                //da lista e se o mesmo tem nome e/ou cnpj
                if (produtoLista != null
                        && produtoLista.getNome() != null
                        && produtoLista.getCnpj() != null) {

                    //Caso o produto desta posição tenha dados cadastrados 
                    //corretamente, verifica se este possui nome ou
                    //cnpj que contenham o valor fornecido como
                    //parâmetro no método. Caso uma das afirmações seja
                    //verdadeira, adiciona este produto na lista de
                    //resultados.
                    //OBS.: Não está ignorando maiúsculas ou
                    //minúsculas, pode ser interessante implementar este
                    //comportamente para evitar a necessidade do usuário
                    //digitar a pesquisa EXATAMENTE como está cadastrado
                    //para conseguir encontrar o cliente
                    if (produtoLista.getNome().contains(valor)
                            || produtoLista.getCnpj().contains(valor)) {

                        listaResultado.add(produtoLista);

                    }

                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        }
        //Se não há produtos na lista de clientes, lança um erro (outra classe
        //que usar esse método terá que usar um try/catch para tratar isso)
        else {
            
            throw new Exception("Não há dados para pesquisa");
            
        }

        //Retorna a lista de produtos encontrados
        return listaResultado;
        
    }

    //Obtém um produto da lista
    public static Produto obter(int id)
            throws Exception {
        
        //Verifica se a lista de clientes em memória não está vazia antes de
        //tentar iniciar a busca
        if (listaProdutos.size() > 0) {

            //Se a lista não está vazia, vamos percorrer a lista toda até
            //encontrar o produto com aquele ID e retorná-lo
            int contadorPosicao = 0;
            while (contadorPosicao < listaProdutos.size()) {
                //Obtém o cliente da posição corrente da lista
                Produto produtoLista = listaProdutos.get(contadorPosicao);

                //Verifica se há produtos cadastrados corretamente nessa posição
                //da lista e se o mesmo tem nome e/ou sobrenome
                if (produtoLista != null
                        && produtoLista.getId() != null
                        && produtoLista.getId() == id) {

                    //Case seja o produto desejado, retorna-o a quem chamou
                    return produtoLista;

                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        }
        //Se não há produtos na lista de produtos, lança um erro (outra classe
        //que usar esse método terá que usar um try/catch para tratar isso)
        else {
            throw new Exception("Não há dados para pesquisa");
        }

        //Se percorreu a lista toda e não achou o produto desejado, retorna null
        return null;
    }
}