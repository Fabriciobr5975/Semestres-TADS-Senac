package banco;

import java.util.Scanner;

public class TestarVetorConta {
	public static void main(String[] args) {
		Cliente[] cliente = null;
		ContaCorrente[] contas = null;
		int posicao = 0;

		Scanner scanner = new Scanner(System.in);
		int opcao = 0;

		do {
			menu();
			opcao = scanner.nextInt();
			switch (opcao) {
			case 1 -> {
				System.out.println("Quantas contas deseja criar?");
				int qtdContas = scanner.nextInt();

				contas = new ContaCorrente[qtdContas];
				ContaCorrente.inicializarContas(contas);

			}
			case 2 -> {
				System.out.println("Quantos clientes deseja criar?");
				int qtdClientes = scanner.nextInt();

				cliente = new Cliente[qtdClientes];
				Cliente.inicializarClientes(cliente);

			}
			case 3 -> {
				System.out.println("Qual posição do cliente deseja associar");
				posicao = scanner.nextInt();

				System.out.println("Digite o nome do cliente");
				String nomeCliente = scanner.next();

				Cliente c = cliente[posicao];
				c.nome = nomeCliente;

				System.out.println("A qual conta (posição) deseja associar o cliente?");
				posicao = scanner.nextInt();
				contas[posicao].titular = c;

			}
			case 4 -> {
				System.out.println("Qual valor deseja depositar:");
				double valor = scanner.nextDouble();

				System.out.println("Qual conta você deseja depositar?");
				posicao = scanner.nextInt();
				contas[posicao].depositar(valor);
			}
			case 5 -> {
				System.out.println("Qual conta de destino para realizar a tranferência");
				posicao = scanner.nextInt();

				System.out.println("Para qual conta deseja realizar a tranferência?");
				int posicao2 = scanner.nextInt();

				System.out.println("Digite o valor para a transferência:");
				double valor = scanner.nextDouble();

				if(contas[posicao].transferir(valor, contas[posicao2])) {
					System.out.println("Tranferência realizada com sucesso");
				
				} else {
					System.err.println("NÃO FOI POSSÍVEL REALIZAR A TRANSFÊRENCIA");
				}
			}
			case 6 -> {
				System.out.println("De qual cliente (posição) deseja visualizar os dados");
				posicao = scanner.nextInt();

				System.out.println(cliente[posicao].nome + " " + cliente[posicao].cpf);
			}
			case 7 -> {
				System.out.println("De qual conta (posicao) deseja visualizar os dados");
				posicao = scanner.nextInt();

				System.out.println(contas[posicao].toString());
			}
			case 8 -> {
				break;
			}
			default -> {
				System.out.println("Opção Inválida, digite novamente!");
			}
			}
		} while (opcao != 8);
	}

	public static void menu() {
		System.out.println("1. Criar Contas\n2. Criar Clientes\n3. Associar clientes a contas"
				+ "\n4. Realizar Deposito\n5. Realizar Transferência\n6. Exibir dados do cliente"
				+ "\n7. Exibir dados da conta\n8. Sair");
	}

}
