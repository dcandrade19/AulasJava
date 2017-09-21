package edu.lp1.apresentacao;

import java.util.ArrayList;

import edu.lp1.entidade.Produto;
import edu.lp1.negocio.ServicoProduto;

/**
 * Representa a camada de apresenta��o do sistema. Nessa classe as entradas de
 * dados do usu�rio ser�o realizadas.
 *
 * @author Andre Pimenta
 *
 */
public class Principal {

    public static void main(String[] args) {
        /**
         * Instancia a classe de Servi�o, classe de regra de neg�cio, para
         * manipular produtos.
         */
        ServicoProduto servicoProduto = new ServicoProduto();
        /**
         * Cria as op��es de menu.
         */
        String[] opcoes = {"Cadastrar Produto", "Listar Produtos", "Remover Produto por Código", "Editar Produto por Código"};
        /**
         * Vari�vel que mantem o programa funcionando.
         */
        boolean continua = true;
        do {
            /**
             * Recolhe a op��o de menu do teclado do usu�rio.
             */
            int escolha = Console.mostrarMenu(opcoes, "Escolha uma opção:");
            switch (escolha) {
                case 1:
                    /**
                     * Faz a opera��o de cria��o de um produto. Chama a
                     * funcionalidade de salvar da camada de neg�cio.
                     */
                    Produto paraCadastrar = criarProduto();
                    /**
                     * Faz o tratamento de exce��es com o bloco try catch.
                     */
                    try {
                        servicoProduto.salvar(paraCadastrar);
                        System.out.println("Produto cadastrado com sucesso!\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 2:
                    /**
                     * Faz a opera��o de listagem dos produtos cadastrados no
                     * sistema.
                     */
                    ArrayList<Produto> produtos = servicoProduto
                            .listarProdutosTotais();
                    if (produtos.size() > 0) {
                        System.out.println("Produtos cadastrados:");
                        for (Produto produto : produtos) {
                            System.out.println(produto);
                        }
                    } else {
                        System.out.println("Não há produtos cadastrados!");
                    }
                    System.out.println();
                    break;

                case 3:
                    String codigo = Console.recuperaTexto("Informe o código do produto: ");
                    Produto produtoExcluido = servicoProduto.excluirPorCodigo(codigo);
                    if(produtoExcluido != null) {
                        System.out.println("O produto: " + produtoExcluido + "Foi excluido.");
                    } else {
                        System.out.println("O produto código: " + codigo + " não existe.");
                    }
                    break;
                    
                case 4:
                    String codigo = Console.recuperaTexto("Informe o código do produto: ");
                    Produto produtoParaEditar = servicoProduto.editarProdutoPorCodigo(codigo);
                    // Produto produtoEditado = 
                    
                case -1:
                    System.out.println("###################");
                    System.out.println("Sistema finalizado.");
                    System.out.println("###################");
                    continua = false;
                    break;
            }

        } while (continua);

    }

    /**
     * M�todo auxiliar para realizar a cria��o de um novo objeto produto com os
     * dados informados pelo usu�rio pelo teclado.
     *
     * @return
     */
    public static Produto criarProduto() {
        String codigo = Console.recuperaTexto("Digite o código do produto:");
        String nome = Console.recuperaTexto("Digite o nome do produto:");
        Double preco = Console.recuperaDecimal("Digite o preço do produto:");
        Produto paraCadastrar = new Produto(codigo, nome, preco);
        return paraCadastrar;
    }

}
