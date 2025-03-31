import java.util.*;

public class CatalogoProdutos {
    private Map<String, String> catalogo;
    private List<String> menu;
    private int opcaoEscolhida;
    private Scanner entrada;
    public CatalogoProdutos() {
      this.catalogo = new HashMap<>();
      this.menu = Arrays.asList("1. Adicionar Produto", "2. Editar Produto", "3. Remover Produto", "4. Listar Produtos", "5. Sair");
    }

    public void showMenu() {
        System.out.println("\nMenu Principal");
        for (String m : this.menu) {
            System.out.println(m);
        }
        System.out.println("Escolha uma opcao: ");
        this.entrada = new Scanner(System.in);
        this.opcaoEscolhida = this.entrada.nextInt();
        this.entrada.nextLine(); //Clean buffer

        if (this.opcaoEscolhida < 1 || this.opcaoEscolhida > this.menu.size()) {
            System.out.println("Opção Inválida, tente novamente.");
        }
    }

    public void processarOpcao() {
        do {
            switch (this.opcaoEscolhida) {
                case 1:
                    this.adicionaProduto();
                    break;
            }
        } while (this.opcaoEscolhida != 5);
    }

    public void adicionaProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = this.entrada.nextLine();
        String id = UUID.randomUUID().toString();
        if (this.catalogo.containsKey(id)) {
            System.out.println("Produto já cadastrado!");
        } else {
            this.catalogo.put(id, nome);
        }
    }
    public void getCatalogo() {
        for (Map.Entry<String, String> entry : this.catalogo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public void removerProduto(String id) {}
    public void updateProduto(String id, String nome, String descricao, double preco) {}
}
