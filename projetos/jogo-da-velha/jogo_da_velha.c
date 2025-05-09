#include <stdio.h>

char tabuleiro[9] = {'1','2','3','4','5','6','7','8','9'};

void exibir_tabuleiro() {
    printf("\n %c | %c | %c\n", tabuleiro[0], tabuleiro[1], tabuleiro[2]);
    printf("---+---+---\n");
    printf(" %c | %c | %c\n", tabuleiro[3], tabuleiro[4], tabuleiro[5]);
    printf("---+---+---\n");
    printf(" %c | %c | %c\n\n", tabuleiro[6], tabuleiro[7], tabuleiro[8]);
}

int verificar_vitoria() {
    int v[8][3] = {
        {0,1,2},{3,4,5},{6,7,8},
        {0,3,6},{1,4,7},{2,5,8},
        {0,4,8},{2,4,6}
    };
    for (int i = 0; i < 8; i++) {
        if (tabuleiro[v[i][0]] == tabuleiro[v[i][1]] && tabuleiro[v[i][1]] == tabuleiro[v[i][2]])
            return 1;
    }
    return 0;
}

int main() {
    int jogadas = 0;
    char jogador = 'X';

    while (1) {
        exibir_tabuleiro();
        int pos;
        printf("Jogador %c, escolha uma posição (1-9): ", jogador);
        scanf("%d", &pos);
        pos--;

        if (pos < 0 || pos > 8 || tabuleiro[pos] == 'X' || tabuleiro[pos] == 'O') {
            printf("Jogada inválida. Tente novamente.\n");
            continue;
        }

        tabuleiro[pos] = jogador;
        jogadas++;

        if (verificar_vitoria()) {
            exibir_tabuleiro();
            printf("Jogador %c venceu!\n", jogador);
            break;
        }

        if (jogadas == 9) {
            exibir_tabuleiro();
            printf("Empate!\n");
            break;
        }

        jogador = (jogador == 'X') ? 'O' : 'X';
    }

    return 0;
}
