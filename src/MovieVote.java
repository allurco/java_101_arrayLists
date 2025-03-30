import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieVote {

    public MovieVote() {
        List<String> filmes = Arrays.asList("O Poderoso Chefão", "A Origem", "Clube de Luta", "Forrest Gump");
        List<Integer> votos = new ArrayList<Integer>(Arrays.asList(0,0,0,0));

        Scanner scanner = new Scanner(System.in);
        int amigo = 1;
        int voto;
        do {
            System.out.println("Aqui está a lista de filmes?");
            int filmeNumber = 1;
            for (String filme : filmes) {
                System.out.println(filmeNumber + ". " + filme);
                filmeNumber++;
            }
            System.out.println("Qual o voto do amigo " + amigo + "?");
            voto = scanner.nextInt();
            if (voto > 0 && voto < filmes.size()) {
                int filmeKey = voto - 1;
                votos.set(filmeKey, votos.get(filmeKey) + 1);
                amigo++;
            } else if (voto != 0) {
                System.out.println("Opção inválida!");
            }
        } while (voto != 0);

        int anterior = 0;
        int key = 0;
        for(int i = 0; i < votos.size(); i++) {
            if(votos.get(i) >= anterior) {
                anterior = votos.get(i);
                key = i;
            }
        }


        System.out.println("O Filme1" +
                " mais votado foi: " + filmes.get(key));
    }
}
