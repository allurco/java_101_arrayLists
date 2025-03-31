import java.util.*;

public class CatalogoProdutos {
    private Map<String, String> catalogo;
    private List<String> menu;
    private int opcaoEscolhida;
    private Scanner entrada;
    public CatalogoProdutos() {
      this.catalogo = new HashMap<>();
      this.menu = Arrays.asList("1. Adicionar Produto", "2. Editar Produto", "3. Remover Produto", "4. Listar Produtos", "5. Sair");
      this.opcaoEscolhida = 0;
      this.showMenu();
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
        } else {
            this.processarOpcao();
        }
    }

    public void processarOpcao() {
        do {
            switch (this.opcaoEscolhida) {
                case 1:
                    this.adicionaProduto();
                    break;
                case 2:
                    System.out.println("Digite o ID do produto que quer Editar: ");
                    String editId = this.entrada.nextLine();
                    System.out.println("Digite o novo nome do produto: ");
                    String nome = this.entrada.nextLine();
                    this.updateProduto(editId, nome);
                break;
                case 3:
                    System.out.println("Digite o ID do produto a remover: ");
                    String deleteId = this.entrada.nextLine();
                    this.removerProduto(deleteId);
                break;
                case 4:
                    System.out.println("Lista de Produtos: ");
                    this.getCatalogo();
                break;
                case 5:
                    System.out.println("Saindo...");
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
            System.out.println("Produto adicionado com sucesso!");
        }

        this.opcaoEscolhida = 0;
        this.showMenu();
    }
    public void getCatalogo() {
        System.out.print("\n--------\n");
        for (Map.Entry<String, String> entry : this.catalogo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        this.opcaoEscolhida = 0;
        this.showMenu();
    }
    public void removerProduto(String id) {
        if (this.catalogo.containsKey(id)) {
            this.catalogo.remove(id);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }

        this.opcaoEscolhida = 0;
        this.showMenu();
    }
    public void updateProduto(String id, String nome) {
        if (this.catalogo.containsKey(id)) {
            this.catalogo.put(id, nome);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
        this.opcaoEscolhida = 0;
        this.showMenu();
    }
}
