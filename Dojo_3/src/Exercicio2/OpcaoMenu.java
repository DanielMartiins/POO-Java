/*
================================================================================
Exercício 2

Implemente a classe “Album”, que representa um CD, possuindo um título, artista,
quantidade de músicas e lista de músicas*. Para que um novo álbum seja criado,
ele precisa receber todas essas informações necessárias. Além dessas
características, implemente também métodos para:

- Checar se uma música está no álbum;
- Verificar o nome da n-ésima música do álbum;
- Imprimir os dados do álbum (título, artista e lista de músicas);
- Alterar a posição de uma música na lista;
================================================================================
*/

package Exercicio2;

public enum OpcaoMenu {

    CHECAR_SE_ALBUM_CONTEM_MUSICA(1),
    VERIFICAR_NOME_MUSICA(2),
    IMPRIMIR_DADOS_ALBUM(3),
    ALTERAR_POSICAO_MUSICA(4),
    ADICIONAR_MUSICA(5),
    REMOVER_MUSICA(6),
    SAIR(0);


    final private int valor;

    OpcaoMenu(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
