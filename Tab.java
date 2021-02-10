// Construtor do tabuleiro
class Tab
{
  int[][] matriz;
  int linhaZero;
  int colunaZero;

  // Tab irá representar a matriz usa no jogo
  Tab()
  {
    matriz = new int[4][4];
  }

  // Passar de vetor para matriz guardando a linha e a coluna onde está o 0
  Tab(int[][] in)
  {
  this.matriz = new int[4][4];

  for (int i = 0; i < 4 ; i++)
    for (int j = 0 ; j < 4 ; j++)
    {
      this.matriz[i][j] = in[i][j];

      if (this.matriz[i][j] == 0)
      {
        this.linhaZero = i;   //linha onde esta o 0
        this.colunaZero = j;   //coluna onde esta o 0
      }
    }
  }

  // Guarda um cópia porque alterou-se o tabuleiro
  Tab(Tab m)
  {
    this.matriz = new int[4][4];
    for (int i = 0 ; i < 4 ; i++)
    {
      for (int j = 0; j<4 ; j++)
      {
        matriz[i][j] = m.matriz[i][j];
      }
    }
    this.linhaZero = m.linhaZero;
    this.colunaZero = m.colunaZero;
  }

  // Criar um vetor com os movimentos possiveis
  char[] movesPossiveis()
  {
    char[] movesPossiveis = new char[4];
    for (int i = 0 ; i < 4 ; i++)
      movesPossiveis[i] = 'n';
    char[] moves = new char[4];
    moves[0] = 'b';
    moves[1] = 'c';
    moves[2] = 'e';
    moves[3] = 'd';
    int j= 0;
    for (int i=0 ; i < 4 ; i++)
    {
      if (moves[i] == 'b' && this.linhaZero!=3)
      {
        movesPossiveis[j] = moves[i];
        j++;
      }
      else if (moves[i] == 'c' && this.linhaZero!=0)
      {
        movesPossiveis[j] = moves[i];
        j++;
      }
      else if (moves[i] == 'e' && this.colunaZero!=0)
      {
        movesPossiveis[j] = moves[i];
        j++;
      }
      else if (moves[i] == 'd' && this.colunaZero!=3)
      {
        movesPossiveis[j] = moves[i];
        j++;
      }
    }
    return movesPossiveis;
  }

  // Fazer os movimentos pretendidos
  void fazermovimento(char move)
  {
    switch(move)
    {
      case 'c': // para cima
        this.matriz[linhaZero][colunaZero] = this.matriz[linhaZero-1][colunaZero];
        this.matriz[linhaZero-1][colunaZero] = 0;
        this.linhaZero=linhaZero-1;
        break;
      case 'b': // para baixo
        this.matriz[linhaZero][colunaZero] = this.matriz[linhaZero+1][colunaZero];
        this.matriz[linhaZero+1][colunaZero] = 0;
        this.linhaZero=linhaZero+1;
        break;
      case 'e': // para a esquerda
        this.matriz[linhaZero][colunaZero] = this.matriz[linhaZero][colunaZero-1];
        this.matriz[linhaZero][colunaZero-1] = 0;
        this.colunaZero=colunaZero-1;
        break;
      case 'd': // para a direita
        this.matriz[linhaZero][colunaZero] = this.matriz[linhaZero][colunaZero+1];
        this.matriz[linhaZero][colunaZero+1] = 0;
        this.colunaZero=colunaZero+1;
        break;
    }

  }

  // Comparar duas matrizes(Verificar se são iguais)
  boolean equals(Tab m)
  {
    for(int i= 0; i < 4; i++)
      for(int j = 0; j < 4; j++)
        if(this.matriz[i][j] != m.matriz[i][j])
          return false;
    return true;
  }
}
