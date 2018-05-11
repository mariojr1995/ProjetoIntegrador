/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mario.mock;

import br.com.mario.modelos.Clientes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Otavio
 */
public class MockCliente {

    //Sequência de IDs para cadastro de clientes    
    private static int sequenciaIdClientes = 0;

    //Armazena a lista de clientes
    private static List<Clientes> listaClientes = new ArrayList<Clientes>();

    //Insere um cliente no mock "clientes"
    public static void inserir(Clientes cliente)
            throws Exception {

        //Configura um ID para o cliente 
        cliente.setId(sequenciaIdClientes++);

        //Adiciona o cliente na lista
        listaClientes.add(cliente);
    }

    //Realiza a atualização dos dados de um cliente
    public static void atualiza(Clientes clienteAtualizacao)
            throws Exception {

        //Verifica se foi fornecido um cliente para atualização 
        if (clienteAtualizacao != null
                && clienteAtualizacao.getId() != null
                && listaClientes.size() > 0) {

            int contador = 0;
            boolean clienteAtualizado = false;
            while (contador < listaClientes.size() && !clienteAtualizado) {

                //Obtém o cliente da posição corrente da lista
                Clientes clienteLista = listaClientes.get(contador);

                //Se há um cliente nesta posição da lista e o ID dele é igual
                //ao ID do cliente fornecido como parâmetro para atualização,
                //atualizamos seus dados e paramos a pesquisa com a flag
                if (clienteLista != null
                        && clienteLista.getId() == clienteAtualizacao.getId()) {

                    //Atualização dos dados no objeto de modelo de cliente
                    clienteLista.setId(clienteAtualizacao.getId());

                    //Atualização do nome
                    clienteLista.setNome(clienteAtualizacao.getNome());

                    //Atualiza o sexo
                    clienteLista.setSexo(clienteAtualizacao.getSexo());

                    //Atualiza o cpf
                    clienteLista.setCpf(clienteAtualizacao.getCpf());

                    //Atualiza o rg
                    clienteLista.setRg(clienteAtualizacao.getRg());

                    //Atualiza a data de nascimento
                    clienteLista.setDataNasc(clienteAtualizacao.getDataNasc());

                    //Atualiza o cep
                    clienteLista.setCep(clienteAtualizacao.getCep());

                    //Atualiza o endereço
                    clienteLista.setEndereco(clienteAtualizacao.getEndereco());

                    //Atualiza o telefone
                    clienteLista.setTelefone(clienteAtualizacao.getTelefone());

                    //Atualiza o celular
                    clienteLista.setCelular(clienteAtualizacao.getCelular());

                    //Configura a flag indicando que a atualização foi realizada
                    clienteAtualizado = true;
                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contador++;
            }

        } //Se não foi fornecido um cliente para atualizar ou não há clientes
        //na lista de clientes, lança um erro.
        else {
            throw new Exception("Não há cliente para atualizar");
        }

    }

    //Realiza a exclusão de um cliente no mock, com ID fornecido
    public static void excluir(int id) throws Exception {

        //Verifica se a lista de clientes não
        //está vazia antes de iniciar a exclusão
        if (listaClientes.size() > 0) {

            int contadorPosicao = 0;
            boolean clienteRemovido = false;
            while (contadorPosicao < listaClientes.size() && !clienteRemovido) {

                //Obtém o cliente da posição corrente da lista
                Clientes clienteLista = listaClientes.get(contadorPosicao);

                //Verifica se há cliente cadastrado corretamente nessa posição
                // Caso verdadeiro, remove o cliente
                if (clienteLista != null && clienteLista.getId() == id) {
                    listaClientes.remove(contadorPosicao);
                    clienteRemovido = true;
                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        } //Se não há clientes na lista de clientes, lança um erro 
        else {

            throw new Exception("Não há cliente para remover");

        }

    }

    //Lista todos os clientes
    public static List<Clientes> listar()
            throws Exception {

        return listaClientes;

    }

    //Procura um cliente no mock
    public static List<Clientes> procurar(String valor)
            throws Exception {

        List<Clientes> listaResultado = new ArrayList<Clientes>();

        //Verifica se foi fornecido um parâmetro para pesquisa e se a
        //lista de clientes não está vazia 
        if (valor != null && listaClientes.size() > 0) {

            int contadorPosicao = 0;
            while (contadorPosicao < listaClientes.size()) {

                //Obtém o cliente da posição corrente da lista
                Clientes clienteLista = listaClientes.get(contadorPosicao);

                //Verifica se há cliente cadastrado corretamente nessa posição
                //da lista e se o mesmo tem nome
                if (clienteLista != null && clienteLista.getNome() != null) {

                    if (clienteLista.getNome().contains(valor)) {

                        listaResultado.add(clienteLista);

                    }

                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        } //Se não há clientes na lista de clientes, lança um erro 
        else {

            throw new Exception("Não há dados para pesquisa");

        }

        //Retorna a lista de clientes encontrados
        return listaResultado;

    }

    //Obtém um cliente da lista
    public static Clientes obter(int id)
            throws Exception {

        //Verifica se a lista de clientes não está vazia antes de
        //tentar iniciar a busca
        if (listaClientes.size() > 0) {

            int contadorPosicao = 0;
            while (contadorPosicao < listaClientes.size()) {

                //Obtém o cliente da posição corrente da lista
                Clientes clienteLista = listaClientes.get(contadorPosicao);

                //Verifica se há clientes cadastrados corretamente nessa posição
                if (clienteLista != null
                        && clienteLista.getId() != null
                        && clienteLista.getId() == id) {

                    //Case seja o cliente desejado, retorna-o a quem chamou
                    return clienteLista;

                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        } //Se não há clientes na lista de clientes, lança um erro 
        else {
            throw new Exception("Não há dados para pesquisa");
        }

        //Se percorreu a lista toda e não achou o cliente desejado, retorna null
        return null;
    }
}
