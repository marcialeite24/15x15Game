import java.util.*;
import java.lang.*;

// Definição das heurísticas(1 ou 2) para a pesquisa Greedy e A*
class Heuristicas extends Tab
{
  // Menu das heurísticas(heuristica ou heuristica+profundidade)
  static void menuH(Node no, Tab end, int escolha)
  {
    switch (escolha)
    {
      // Heurísticas usadas para a pesquisa Greedy
      case 1: // aplica a heurística 1(determinar o número de nós fora do lugar em relação á matriz correspondente à solução)
        no.custo = heuristica_1(no, end);
        break;
      case 2: // aplica a heurística 2(manhattan distance, determina a distância de cada nó para o seu lugar correto)
        no.custo = heuristica_2(no, end);
        break;
      // Heurísticas usadas para a pesquisa A*
      case 3: // aplica a heurística 1 + profundidade
        no.custo = heuristica_1(no, end) + no.profundidade;
        break;
      case 4: // aplica a heurística 2 + profundidade
        no.custo = heuristica_2(no, end) + no.profundidade;
        break;
    }
  }

  // Retorna o número de peça fora do sítio
  static int heuristica_1(Node no, Tab end)
  {
    int peças_fora = 0;
    for(int i = 0; i < 4; i++)
    {
      for(int j = 0; j < 4; j++)
      {
        if(no.matriz.matriz[i][j] != end.matriz[i][j])
          peças_fora++;
      }
    }
    return peças_fora;
  }

  // Manhattan distance
  static int heuristica_2(Node no, Tab end)
  {
    int numero = 0, distance = 0, valor = 0;
    int[] pos = new int[2];
    for(int i = 0; i < 4; i++)
    {
      for(int j = 0; j < 4; j++)
      {
        valor = no.matriz.matriz[i][j];
        for(int k = 0; k < 4; k++)
        {
          for(int l = 0; l < 4; l++)
          {
            if(end.matriz[k][l] == valor)
            {
              pos[0] = k;
              pos[1] = l;
            }
          }
        }
        numero++;
        if(valor != 0 && valor != numero)
          distance += Math.abs((int) i - pos[0]) + Math.abs((int) j - pos[1]);
      }
    }
    return distance;
  }
}
