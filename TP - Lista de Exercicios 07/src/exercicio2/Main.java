//2. Ler duas listas de inteiros positivos a e b (sem repetições) e gerar uma terceira lista c com a união
//de a e b. A lista c não pode ter números duplicados. Imprima a lista c.

package exercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("============ Criando a primeira lista... ============");
        ArrayList<Integer> listaA = criarListaPeloUsuario();

        System.out.println("\n\n============ Criando a segunda lista... ============");
        ArrayList<Integer> listaB = criarListaPeloUsuario();

        ArrayList<Integer> listaC = juntarDuasListas(listaA, listaB);

        System.out.println("Numeros adicionados: " + listaC);
        scanner.close();
    }

    public static ArrayList<Integer> criarListaPeloUsuario(){
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        String numero;

        while(true){
            System.out.println("Insira algum inteiro(ou deixe em branco para concluir): ");
            numero = scanner.nextLine();
            if (numero.isEmpty()){
                System.out.println("Lista criada com sucesso!");
                break;
            } else {
                try{
                    if (lista1.contains(Integer.parseInt(numero)))
                        System.out.println("ERRO: A lista já possui o número! Insira outro. ");
                    else
                        lista1.add(Integer.parseInt(numero));
                } catch (NumberFormatException erro){
                    System.err.println("ERRO: Verifique o formato da sua entrada. " + erro);
                }
            }
        }
        return lista1;
    }


    /**
     * Funcionamento:
     *  Adiciona-se todos os itens da lista A e, posteriormente, adiciona-se o conteúdo da lista B se ainda não
     *  estiver
     *  contido na lista nova
     * @return Uma lista nova que representa a junção de todos os elementos das duas listas, sem repetições.
     */
    public static ArrayList<Integer> juntarDuasListas(ArrayList<Integer> listaA, ArrayList<Integer> listaB){
        ArrayList<Integer> listaNova = new ArrayList<Integer>(listaA);

        for(int i : listaB){
            if (!listaNova.contains(i))
                listaNova.add(i);
        }

        Collections.sort(listaNova); //ordena do menor para o maior
        return listaNova;
    }
}
