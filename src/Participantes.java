import java.util.*;

public class Participantes {
    public Participantes() {
        Set<String> participantes = new HashSet<>();
        List<String> menus = Arrays.asList("Adicionar Participante", "Verificar Participante", "Remover Participante", "Listar Participantes", "Sair");
        int escolha = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("O que quer fazer (digite uma opção da lista)?: ");
            int opcaoNr = 1;
            for (String opcao : menus) {
                System.out.println(opcaoNr +". "+opcao);
                opcaoNr++;
            }

            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            String nome;
            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do participante: ");
                    nome = scanner.nextLine();
                    if (!participantes.add(nome)) {
                        System.out.println("Participante já existe, tente novamente.");
                    } else {
                        System.out.println("Participante adicionado com sucesso!");
                    }
                break;
                case 2:
                    System.out.println("Digite o nome do participante: ");
                    nome = scanner.nextLine();
                    if (participantes.contains(nome)) {
                        System.out.println("Participante existe!");
                    } else {
                        System.out.println("Participante não encontrado!");
                    }

                break;
                case 3:
                    System.out.println("Digite o nome do participante: ");
                    nome = scanner.nextLine();
                    if (participantes.remove(nome)) {
                        System.out.println("Participante removido com sucesso!");
                    } else {
                        System.out.println("Participante não encontrado!");
                    }
                break;
                case 4:
                    System.out.println("Listar Participantes: ");
                    for(String participante : participantes) {
                        System.out.println(participante);
                    }
                break;
                    case 5:
                        System.out.println("Sair");
            }


        } while (escolha != 5);


    }
}
