import java.util.*;

public class Jogo15x15 extends Busca
{
  // Verifica se tem solução
  public static boolean possivel(int matriz[][])
  {
    int zero_linha = 0, paridade = 0;
    for(int i = 0; i < 4; i++)
    {
      for(int j = 0; j < 4; j++)
      {
        if(matriz[i][j] == 0)
        zero_linha = i;
      }
    }
    int[] vec = new int[16];
    int k = 0;
    for(int i = 0; i < 4; i++)
    {
      for(int j = 0; j < 4; j++)
      {
        vec[k] = matriz[i][j];
        k++;
      }
    }
    for(int i = 0; i < 16; i++)
    {
      for(int j = i+1; j<16; j++)
      {
        if((vec[i] > vec[j]) && (vec[j] != 0))
        {
          paridade++;
        }
      }
    }
    // Quando o 0 está numa linha ímpar, a sua paridade tem de ser par
    // Quando o 0 está numa linha par, a sua paridade tem de ser ímpar
    if(((zero_linha==3 || zero_linha==1) && (paridade%2 == 0)) || ((zero_linha==2 || zero_linha==0) && (paridade%2 != 0)))
    {
      return true;
    }
    else return false;
  }

  // Imprime a matriz
  public static void print_matriz(int v[][])
  {
    for(int i=0; i<4; i++)
    {
      for(int j=0; j<4; j++)
      {
        System.out.print(" " + v[i][j] + " ");
      }
      System.out.println();
    }
  }

  // Limpa o terminal
  public static void clear()
  {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  // Atrasa um segundo
  public static void atraso()
  {
    try
    {
       Thread.sleep(1000);
    }
    catch (Exception e)
    {
       e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    System.out.println("\t _______________________________");
    System.out.println("\t|                               |");
    System.out.println("\t|         SEJA BEM VINDO        |");
    System.out.println("\t|         AO JOGO DOS 15        |");
    System.out.println("\t|_______________________________|");
    System.out.println();
    int[][] matriz = new int [4][4]; // Matriz Inicial
    int[][] matrizF = new int [4][4]; // Matriz Final
    Scanner entrada = new Scanner(System.in);
    System.out.println("Configuração Inicial: ");
    for(int i=0; i<4; i++)
    {
      for(int j=0; j<4; j++)
      {
        matriz[i][j] = entrada.nextInt();
      }
    }
    print_matriz(matriz);
    System.out.println();

    System.out.println("Configuração Final: ");
    for(int i=0; i<4; i++)
    {
      for(int j=0; j<4; j++)
      {
        matrizF[i][j] = entrada.nextInt();

      }
    }
    print_matriz(matrizF);
    System.out.println();

    if(!possivel(matriz) || !possivel(matrizF))
    {
      System.out.println("Não existe solução");
      return;
    }
    Tab matrizIni = new Tab(matriz);
    Tab matrizFin = new Tab(matrizF);

    // Menu das Buscas
    atraso();
    clear();

    System.out.println("\t _________________________________________________");
    System.out.println("\t|                                                 |");
    System.out.println("\t|    Escolha o tipo de busca que pretende usar    |");
    System.out.println("\t|_________________________________________________|");
    System.out.println();
    System.out.println(" 1 - Busca em Largura(BFS)");
    System.out.println(" 2 - Busca em Profundidade(DFS)");
    System.out.println(" 3 - Busca Iterativa em Profundidade(IDFS)");
    System.out.println(" 4 - Busca Gulosa(Greedy)");
    System.out.println(" 5 - Busca A*");
    System.out.println();
    System.out.print("Opção: ");

    int escolher = entrada.nextInt();

    switch(escolher)
    {
      case 1:
        atraso();
        clear();
        System.out.println("\t**BFS**\n");
        Busca.BFS(matrizIni, matrizFin);
        break;
      case 2:
        atraso();
        clear();
        System.out.println("\t**DFS**\n");
        Busca.DFS(matrizIni, matrizFin);
        break;
      case 3:
        atraso();
        clear();
        System.out.println("\t**IDFS**\n");
        Busca.IDFS(matrizIni, matrizFin, 99);
        break;
      case 4:
        atraso();
        clear();
        System.out.println("\tGreedy\n");
        System.out.println("Qual das heuristicas pretende usar?");
        System.out.println();
        System.out.println(" 1 - Somatório do número de peças fora do lugar");
        System.out.println(" 2 - Manhattan distance");
        System.out.println();
        System.out.print("Opção: ");
        int escolha1 = entrada.nextInt();
        System.out.println(escolha1);
        Busca.Greedy(matrizIni, matrizFin, escolha1);
        break;
      case 5:
        atraso();
        clear();
        System.out.println("\tA*\n");
        System.out.println("Qual das heuristicas pretende usar?");
        System.out.println();
        System.out.println(" 3 - Somatório do número de peças fora do lugar");
        System.out.println(" 4 - Manhattan distance");
        System.out.println();
        System.out.print("Opção: ");
        int escolha2 = entrada.nextInt();
        System.out.println(escolha2);
        Busca.AStar(matrizIni, matrizFin, escolha2);
        break;
    }
  }
}
