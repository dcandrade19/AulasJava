package edu.lp1.negocio;

import java.util.ArrayList;

import edu.lp1.entidade.Produto;
import edu.lp1.persistencia.ProdutoDAO;

/**
 * Classe de regras de neg�cio para manipular as funcionalidades relacionadas ao
 * Produto.
 * 
 * @author Andre Pimenta
 *
 */
public class ServicoProduto {
	/**
	 * Faz a declara��o da camada de persist�ncia que ser� respons�vel por
	 * armazenar de forma persistente os dados do cadastro do produto.
	 */
	private ProdutoDAO produtoDAO;

	/**
	 * Construtor da classe ServicoProduto. No construtor j� ser� instanciada a
	 * classe de persist�ncia ProdutoDAO.
	 */
	public ServicoProduto() {
		this.produtoDAO = new ProdutoDAO();
	}

	/**
	 * N�o deve ser poss�vel salvar dois produtos com o mesmo c�digo
	 * 
	 * @throws Exception
	 */
	public Produto salvar(Produto produto) throws Exception {
		/**
		 * N�o deve ser poss�vel salvar dois produtos com o mesmo c�digo
		 */
		this.verificaProdutoExistentePorCodigo(produto);
		/**
		 * N�o deve ser poss�vel salvar dois produtos com o mesmo c�digo
		 */
		this.verificaProdutoExistentePorNome(produto);
		/**
		 * Se nenhuma regra anterior lan�ar exce��o, continuar com o processo de
		 * salvar na camada de persist�ncia.
		 */
		this.produtoDAO.salvar(produto);
		/**
		 * Retorna o produto cadastrado.
		 */
		return produto;
	}

        
        public Produto excluirPorCodigo(String codigo) {
            return this.produtoDAO.excluirPorCodigo(codigo);
        }
        
	/**
	 * M�todo de aux�lio com a regra para verificar a exist�ncia de um produto
	 * duplicado no cadastro de produtos.
	 * 
	 * @param produto
	 * @throws Exception
	 */
	private void verificaProdutoExistentePorCodigo(Produto produto)
			throws Exception {
		/**
		 * Verificar se j� existe um produto com o mesmo c�digo
		 */
		Produto jaExiste = this.produtoDAO.buscarProdutoPorCodigo(produto
				.getCodigo());
		if (jaExiste != null) {
			throw new Exception("Já existe um produto com o código "
					+ produto.getCodigo() + ".");
		}
	}

	/**
	 * M�todo de aux�lio com a regra para verificar a exist�ncia de um produto
	 * duplicado no cadastro de produtos.
	 * 
	 * @param produto
	 * @throws Exception
	 */
	private void verificaProdutoExistentePorNome(Produto produto)
			throws Exception {
		/**
		 * Verificar se j� existe um produto com o mesmo nome
		 */
		Produto jaExiste = this.produtoDAO.buscarProdutoPorNome(produto
				.getNome());
		if (jaExiste != null) {
			throw new Exception("Já existe um produto com o nome "
					+ produto.getNome() + ".");
		}
	}

	/**
	 * M�todo que retorna todos os produtos cadastrados no sistema.
	 * 
	 * @return
	 */
	public ArrayList<Produto> listarProdutosTotais() {
		return this.produtoDAO.listarTodosProdutos();
	}

}
