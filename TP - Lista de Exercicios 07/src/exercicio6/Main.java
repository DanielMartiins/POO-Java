//6. Faça um programa para ler uma lista de palavras até que o usuário digite uma string vazia. Ao
//final, imprima a lista de palavras digitadas em ordem alfabética. Importante: não podem existir
//palavras duplicadas na lista.

package exercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> palavras = new ArrayList<>();

        String palavra;
        while(true){
            System.out.println("Insira uma palavra(ou string vazia para encerrar)");
            palavra = scanner.nextLine();
            if (palavra.isEmpty())
                break;
            else{
                if (palavraContidaNaLista(palavra, palavras))
                    System.err.printf("ERRO: '%s' já está contido na lista. Insira uma palavra diferente", palavra.toUpperCase());
                else
                    palavras.add(palavra);
            }
        }
        Collections.sort(palavras);
        System.out.println(palavras);
    }

    public static boolean palavraContidaNaLista(String palavra, ArrayList<String> palavras){
        for (String p : palavras){
            if (palavra.equalsIgnoreCase(p))
                return true;
        }
        return false;
    }
}
