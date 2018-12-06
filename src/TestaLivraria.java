import javax.swing.JOptionPane;

public class TestaLivraria {

	public static void main(String[] args) {

		int opcao1 = 0;
		int opcao2 = 0;
		int opcao3 = 0;
		int opcao4 = 0;
		boolean senhaGerente;
		boolean senhaCaixa;

		Livraria livraria = new Livraria();
		Gerente gerente = new Gerente();
		Caixa caixa = new Caixa();
		Atendente atendente = new Atendente();

		// CADASTRO LIVRARIA
		livraria.setNome("Sereiva");
		livraria.setLocal("S�o Paulo");
		livraria.criaLivros(2000);

		// CADASTRO GERENTE
		gerente.setNome("Arthur");
		gerente.setCpf("123456789");
		gerente.setSalario(5000.0);
		gerente.setSenha(123);

		// CADASTRO CAIXA
		caixa.setNome("Leonardo");
		caixa.setCpf("192837465");
		caixa.setSalario(2600.0);
		caixa.setSenha(456);

		// CADASTRO ATENDENTE
		atendente.setNome("Bruna");
		atendente.setCpf("987654321");
		atendente.setSalario(3200.0);

		String opcoes1 = "Livraria: " + livraria.getNome() + "\nLocaliza��o: " + livraria.getLocal()
				+ "\n\n***Op��es*** " + "\n1. Gerente" + "\n2. Caixa" + "\n3. Atendente" + "\n4. Sair"
				+ "\n\nSelecione a op��o: ";

		Livro livro;
		// MENU FUNCION�RIO
		while (opcao1 != 4) {
			opcao1 = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes1, "Livraria " + livraria.getNome(),
					JOptionPane.QUESTION_MESSAGE));
			switch (opcao1) {
			// OP��O GERENTE
			case 1:
				do {
					senhaGerente = gerente.autentica(Integer.parseInt(JOptionPane.showInputDialog("Senha:")));
				} while (senhaGerente != true);

				if (senhaGerente == true) {
					String opcoes2 = "Gerente: " + gerente.getNome() + "\nCPF: " + gerente.getCpf() + "\nSal�rio: "
							+ (gerente.getSalario() + gerente.getBonificacao()) + "\n\n***Op��es*** "
							+ "\n1. Cadastrar Livro" + "\n2. Pesquisar Livro (c�digo)" + "\n3. Pesquisar Livro (t�tulo)"
							+ "\n4. Listar Livros" + "\n5. Informa��es" + "\n6. Sair" + "\n\nSelecione a op��o: ";

					// MENU LIVRARIA
					while (opcao2 != 6) {
						opcao2 = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes2,
								"Livraria " + livraria.getNome(), JOptionPane.QUESTION_MESSAGE));

						switch (opcao2) {
						// CADASTRAR LIVRO
						case 1:
							livraria.incluirLivro(digitarLivro());
							JOptionPane.showMessageDialog(null,
									"Livro Cadastrado!\nTotal: " + livraria.getQuantidade() + " livro(s)");
							break;
						// PROCURAR LIVRO (C�DIGO)
						case 2:
							livro = livraria.obterLivro(
									Integer.parseInt(JOptionPane.showInputDialog("Digite c�digo para pesquisar:")));
							if (livro != null)
								mostrarLivro(livro, livraria.getNome());
							else
								JOptionPane.showMessageDialog(null, "Livro n�o localizado!");
							break;
						// PROCURAR LIVRO (T�TULO)
						case 3:
							livro = livraria.obterLivro(
									JOptionPane.showInputDialog("Digite o t�tulo do livro para pesquisar:"));
							if (livro != null)
								mostrarLivro(livro, livraria.getNome());
							else
								JOptionPane.showMessageDialog(null, "Livro n�o localizado!");
							break;
						// LISTA DE LIVROS
						case 4: {
							StringBuffer lista = new StringBuffer();
							lista.append("Lista de livros cadastrados:\n");
							for (int i = 0; i < livraria.getQuantidade(); i++) {
								livro = livraria.getLivro(i);
								lista.append(
										"C�digo: " + livro.getCodigo() + "\nT�tulo: " + livro.getTitulo() + "\nAutor: "
												+ livro.getAutor() + "\nPre�o: " + livro.getValorVenda() + "\n\n");
							}
							lista.append("Total: " + livraria.getQuantidade() + " livro(s)");
							JOptionPane.showMessageDialog(null, lista.toString());
							break;
						}
						// INFORMA��ES DA LIVRARIA
						case 5:
							JOptionPane.showMessageDialog(null,
									"Informa��es da Livraria\n" + "Nome da Livraria: " + livraria.getNome() + "\n"
											+ "Localiza��o: " + livraria.getLocal() + "\n" + "Capacidade de Livros: "
											+ livraria.getCapacidade() + "\n" + "Existem at� o momento\n"
											+ livraria.getQuantidade() + " livro(s) cadastrado(s)");
							break;
						}
					}
					break;
				} else {
					System.exit(0);
				}
				// OP��O CAIXA
			case 2:
				do {
					senhaCaixa = caixa.autentica(Integer.parseInt(JOptionPane.showInputDialog("Senha:")));
				} while (senhaCaixa != true);

				if (senhaCaixa == true) {
					String opcoes3 = "Caixa: " + caixa.getNome() + "\nCPF: " + caixa.getCpf() + "\nSal�rio: "
							+ (caixa.getSalario() + caixa.getBonificacao()) + "\n\n***Op��es*** "
							+ "\n1. Cadastrar Livro" + "\n2. Pesquisar Livro (c�digo)" + "\n3. Pesquisar Livro (t�tulo)"
							+ "\n4. Listar Livros" + "\n5. Informa��es" + "\n6. Sair" + "\n\nSelecione a op��o: ";

					while (opcao3 != 6) {
						opcao3 = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes3,
								"Livraria " + livraria.getNome(), JOptionPane.QUESTION_MESSAGE));

						switch (opcao3) {
						// CADASTRAR LIVRO
						case 1:
							livraria.incluirLivro(digitarLivro());
							JOptionPane.showMessageDialog(null,
									"Livro Cadastrado!\nTotal: " + livraria.getQuantidade() + " livro(s)");
							break;
						// PROCURAR LIVRO (C�DIGO)
						case 2:
							livro = livraria.obterLivro(
									Integer.parseInt(JOptionPane.showInputDialog("Digite c�digo para pesquisar:")));
							if (livro != null)
								mostrarLivro(livro, livraria.getNome());
							else
								JOptionPane.showMessageDialog(null, "Livro n�o localizado!");
							break;
						// PROCURAR LIVRO (T�TULO)
						case 3:
							livro = livraria.obterLivro(
									JOptionPane.showInputDialog("Digite o t�tulo do livro para pesquisar:"));
							if (livro != null)
								mostrarLivro(livro, livraria.getNome());
							else
								JOptionPane.showMessageDialog(null, "Livro n�o localizado!");
							break;
						// LISTA DE LIVROS
						case 4: {
							StringBuffer lista = new StringBuffer();
							lista.append("Lista de livros cadastrados:\n");
							for (int i = 0; i < livraria.getQuantidade(); i++) {
								livro = livraria.getLivro(i);
								lista.append(
										"C�digo: " + livro.getCodigo() + "\nT�tulo: " + livro.getTitulo() + "\nAutor: "
												+ livro.getAutor() + "\nPre�o: " + livro.getValorVenda() + "\n\n");
							}
							lista.append("Total: " + livraria.getQuantidade() + " livro(s)");
							JOptionPane.showMessageDialog(null, lista.toString());
							break;
						}
						// INFORMA��ES DA LIVRARIA
						case 5:
							JOptionPane.showMessageDialog(null,
									"Informa��es da Livraria\n" + "Nome da Livraria: " + livraria.getNome() + "\n"
											+ "Localiza��o: " + livraria.getLocal() + "\n" + "Capacidade de Livros: "
											+ livraria.getCapacidade() + "\n" + "Existem at� o momento\n"
											+ livraria.getQuantidade() + " livro(s) cadastrado(s)");
							break;
						}
					}
					break;
				} else {
					System.exit(0);
				}
				// OP��O ATENDENTE
			case 3:
				String opcoes4 = "Atendente: " + atendente.getNome() + "\nCPF: " + atendente.getCpf() + "\nSal�rio: "
						+ (atendente.getSalario() + atendente.getBonificacao()) + "\n\n***Op��es*** "
						+ "\n1. Pesquisar Livro (c�digo)" + "\n2. Pesquisar Livro (t�tulo)" + "\n3. Listar Livros"
						+ "\n4. Sair" + "\n\nSelecione a op��o: ";

				while (opcao4 != 4) {
					opcao4 = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes4,
							"Livraria " + livraria.getNome(), JOptionPane.QUESTION_MESSAGE));

					switch (opcao4) {
					// PROCURAR LIVRO (C�DIGO)
					case 1:
						livro = livraria.obterLivro(
								Integer.parseInt(JOptionPane.showInputDialog("Digite c�digo para pesquisar:")));
						if (livro != null)
							mostrarLivro(livro, livraria.getNome());
						else
							JOptionPane.showMessageDialog(null, "Livro n�o localizado!");
						break;
					// PROCURAR LIVRO (T�TULO)
					case 2:
						livro = livraria
								.obterLivro(JOptionPane.showInputDialog("Digite o t�tulo do livro para pesquisar:"));
						if (livro != null)
							mostrarLivro(livro, livraria.getNome());
						else
							JOptionPane.showMessageDialog(null, "Livro n�o localizado!");
						break;
					// LISTA DE LIVROS
					case 3: {
						StringBuffer lista = new StringBuffer();
						lista.append("Lista de livros cadastrados:\n");
						for (int i = 0; i < livraria.getQuantidade(); i++) {
							livro = livraria.getLivro(i);
							lista.append("C�digo: " + livro.getCodigo() + "\nT�tulo: " + livro.getTitulo() + "\nAutor: "
									+ livro.getAutor() + "\nPre�o: " + livro.getValorVenda() + "\n\n");
						}
						lista.append("Total: " + livraria.getQuantidade() + " livro(s)");
						JOptionPane.showMessageDialog(null, lista.toString());
						break;
					}

					}
				}
				break;
			}
		}
		System.out.println("# Programa Finalizado #");
		System.exit(0);
	}

	static Livro digitarLivro() {
		Livro livro = new Livro();
		livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("C�digo do Livro:")));
		livro.setTitulo(JOptionPane.showInputDialog("T�tulo do Livro:"));
		livro.setAutor(JOptionPane.showInputDialog("Autor do Livro:"));
		livro.setISBN(JOptionPane.showInputDialog("N�mero ISBN do Livro:"));
		livro.setNumPaginas(Integer.parseInt(JOptionPane.showInputDialog("Numero de P�ginas do Livro:")));
		livro.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Valor de Venda:")));
		return livro;
	}

	static void mostrarLivro(Livro x, String bib) {
		String texto = "Livro:\n" + "\nC�digo: " + x.getCodigo() + "\nT�tulo: " + x.getTitulo() + "\nAutor: "
				+ x.getAutor() + "\nISBN: " + x.getISBN() + "\nP�ginas: " + x.getNumPaginas() + "\nValor: "
				+ x.getValorVenda();
		JOptionPane.showMessageDialog(null, texto, "Livraria: " + bib, JOptionPane.WARNING_MESSAGE);
	}

}
