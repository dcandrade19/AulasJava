package edu.lp1.persistencia;

import java.util.ArrayList;

import edu.lp1.entidade.Produto;

/**
 * Classe que representa a camada de persist�ncia do sistema para os produtos do
 * sistema.
 * 
 * @author Andre Pimenta
 *
 */
public class ProdutoDAO {

	/**
	 * Lista que representa a persist�ncia de Produtos do sistema. Faz a
	 * simula��o de um banco de dados.
	 */
	private ArrayList<Produto> produtos;
	/**
	 * Campo inteiro sequencial que auxilia na identifica��o dos elementos
	 * cadastrados no sistema.
	 */
	private Integer sequencial;

	/**
	 * Construtor da classe ProdutoDAO. No construtor a lista de produtos �
	 * instanciada e o n�mero sequencial � inicializada com zero.
	 */
	public ProdutoDAO() {
		this.produtos = new ArrayList<Produto>();
		this.sequencial = 0;
	}

	/**
	 * M�todo da persist�ncia que salva o produto na camada de persist�ncia.
	 * 
	 * @param produto
	 * @return
	 */
	public Produto salvar(Produto produto) {
		produto.setId(this.sequencial++);
		this.produtos.add(produto);
		return produto;
	}

	/**
	 * M�todo da persist�ncia que busca um produto cadastrado pelo c�digo do
	 * produto.
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto buscarProdutoPorCodigo(String codigo) {
		for (Produto produto : this.produtos) {
			if (produto.getCodigo().equalsIgnoreCase(codigo)) {
				return produto;
			}
		}
		return null;
	}

	/**
	 * M�todo da persist�ncia que busca um produto cadastrado pelo nome do
	 * produto.
	 * 
	 * @param nome
	 * @return
	 */
	public Produto buscarProdutoPorNome(String nome) {
		for (Produto produto : this.produtos) {
			if (produto.getNome().equalsIgnoreCase(nome)) {
				return produto;
			}
		}
		return null;
	}

	/**
	 * M�todo da persist�ncia que recupera a lista de todos os produtos
	 * cadastrados no sistema.
	 * 
	 * @return
	 */
	public ArrayList<Produto> listarTodosProdutos() {
		return this.produtos;
	}

        public Produto excluirPorCodigo(String codigo) {
            Produto paraExcluir = this.buscarProdutoPorCodigo(codigo);
            if(paraExcluir != null) {
               this.produtos.remove(paraExcluir);
            } 
            return paraExcluir;
        }
        
        public Produto editarProdutoporCodigo(String Codigo) {
            Produto paraEditar = this.buscarProdutoPorCodigo(Codigo);
            if(paraEditar != null) {
                
            }
            return paraEditar;
        }
        
        public Produto editarPorOp(int op, String novo, Produto produto) {
            switch(op) {
                case 1:
                    produto.setCodigo(novo);
                    break;
                    
                case 2:
                    produto.setNome(novo);
                    break;
                    
                case 3:
                    Double novoD = Double.parseDouble(novo);
                    produto.setPreco(novoD);
                    break;
            }
            return produto;
        }
}
