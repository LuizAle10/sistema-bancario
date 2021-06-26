package SistemaBancario;

import java.util.List;

//Classe de negocio para realizar operaçoes sobre os clientes do banco.

public class GerenciadoraClientes {

	private List<Cliente> clientesDoBanco;

	public GerenciadoraClientes(List<Cliente> clientesDoBanco) {
		this.clientesDoBanco = clientesDoBanco;
	}

	// Retorna uma lista com todos os clientes do banco.

	public List<Cliente> getClientesDoBanco() {
		return clientesDoBanco;
	}

	/**
	 * Pesquisa por um cliente a partir do seu ID.
	 * 
	 * @param idCliente id do cliente a ser pesquisado
	 * @return o cliente pesquisado ou null, caso n�o seja encontrado
	 */

	public Cliente pesquisaCliente(int IdCliente) {

		for (Cliente cliente : clientesDoBanco) {
			if (cliente.getId() == IdCliente)
				return cliente;
		}
		return null;
	}

	// Adiciona um novo cliente na lista de clientes do banco.

	public void adicionaCliente(Cliente novoCliente) {
		clientesDoBanco.add(novoCliente);
	}

	// lista de clientes do banco.
	public boolean removeCliente(int idCliente) {
		boolean clienteRemovido = false;

		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if (cliente.getId() == idCliente) {
				clientesDoBanco.remove(i);
				clienteRemovido = true;
				break;
			}
		}

		return clienteRemovido;
	}

	// Informa se um determinado cliente está ativo ou não.

	public boolean clienteAtivo(int idCliente) {
		boolean clienteAtivo = false;

		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if (cliente.getId() == idCliente)
				if (cliente.isAtivo()) {
					clienteAtivo = true;
					break;
				}
		}

		return clienteAtivo;
	}

	// Limpa a lista de clientes, ou seja, remove todos eles.

	public void limpa() {
		this.clientesDoBanco.clear();
	}

	// Valida se a idade do cliente est� dentro do intervalo permitido (18 - 65).

	public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {

		if (idade < 18 || idade > 65)
			throw new IdadeNaoPermitidaException(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);

		return true;
	}

}
