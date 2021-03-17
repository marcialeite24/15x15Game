import java.util.*;
import java.lang.*;

// Algoritmos de Busca (Pesquisa não guida e Pesquisa guiada)
class Busca extends Node
{
  // Pesquisa em Largura
  public static void BFS(Tab matriz, Tab matrizF)
  {
    long tempoInicial = System.currentTimeMillis(); // Calcular o tempo de execução
    long usedMemory = Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory(); // Calcular a memória usada para executar o programa
    HashMap <String,Node > map = new HashMap < String , Node > ();

    Node inicio = new Node(matriz);
    Queue<Node> lista = new LinkedList<Node>();
    int nosGerados=0, profundidade=0;
    String caminho= "";
    lista.offer(inicio);

    while(!lista.isEmpty())
    {
      Node estado = lista.poll(); //retorna o valor da primeira posicao da lista

      if(estado.matriz.equals(matrizF))
      {
        profundidade = estado.profundidade;
        System.out.println("Encontrou a solução!\n");
        long tempoFinal = (long) (System.currentTimeMillis());
        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
        System.out.println("Espaço de memória: " + ((finalMemory-usedMemory)/1000000) + "  MB");
        System.out.println("Nível de Profundidade: " + profundidade);
        System.out.println("Caminho: " + Caminho(estado,caminho));
        System.out.println("Nós gerados: " + nosGerados);
        return;
      }

      char[] moves = estado.matriz.movesPossiveis();
      for(int i=0; i<estado.matriz.movesPossiveis().length; i++){
        if(moves[i]!='n')
          {
            Node kid = estado.getChildren(moves[i]);
            if(!map.containsKey(kid.chave))
              lista.add(kid);
            nosGerados++;
          }
      }
      map.put(estado.chave,estado);
    }
    System.out.println("Não há nenhuma solução!");

  }

  // Pesquisa em Profundidade
  public static void DFS(Tab matriz, Tab matrizF)
  {
    long tempoInicial = System.currentTimeMillis(); // Calcular o tempo de execução
    long usedMemory = Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory(); // Calcular a memória usada para executar o programa
    Node inicio = new Node(matriz);
    Stack<Node> stack = new Stack<Node>();
    int nosGerados=0, profundidade=0;
    String caminho = "";
    stack.push(inicio);
    ++nosGerados;

    while(!stack.isEmpty())
    {
      Node estado = stack.pop();

      if(estado.matriz.equals(matrizF))
      {
        profundidade = estado.profundidade;
        System.out.println("Encontrou a solução!\n");
        long tempoFinal = (long) (System.currentTimeMillis());
        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
        System.out.println("Espaço de memória: " + ((finalMemory-usedMemory)/1000000) + "  MB");
        System.out.println("Nível de Profundidade: " + profundidade);
        System.out.println("Caminho: " + Caminho(estado,caminho));
        System.out.println("Nós gerados: " + nosGerados);
        return;
      }
      if(estado.profundidade<80)
      {
        char[] moves = estado.matriz.movesPossiveis();
        for(int i=0; i<estado.matriz.movesPossiveis().length ; i++)
        {
          if(moves[i]!='n')
          {
            Node kid = estado.getChildren(moves[i]);
            if((kid.pai.move != 'c' && kid.move == 'b') || (kid.pai.move != 'b' && kid.move == 'c') )
            {
              stack.push(kid);
              nosGerados++;
            }
            else if((kid.pai.move != 'd' && kid.move == 'e') || (kid.pai.move != 'e' && kid.move == 'd'))
            {
              stack.push(kid);
              nosGerados++;
            }
          }
        }
      }
    }
    System.out.println("Não há nenhuma solução!");
    return;
  }

  // Pesquisa Iterativa em Profundidade
  public static void IDFS(Tab matriz, Tab matrizF,int profmax)
  {
    long tempoInicial = System.currentTimeMillis(); // Calcular o tempo de execução
    long usedMemory = Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory(); // Calcular a memória usada para executar o programa
    Node inicio = new Node(matriz);
    Stack<Node> stack = new Stack<Node>();
    int nosGerados=0, profundidade=0;
    String caminho = "";

    for(int j=0; j<profmax; j++)
    {
      stack.push(inicio);
      ++nosGerados;

      while(!stack.isEmpty())
      {
        Node estado = stack.pop();

        if(estado.matriz.equals(matrizF))
        {
          profundidade = estado.profundidade;
          System.out.println("Encontrou a solução!\n");
          long tempoFinal = (long) (System.currentTimeMillis());
          long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
          System.out.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
          System.out.println("Espaço de memória: " + ((finalMemory-usedMemory)/1000000) + "  MB");
          System.out.println("Nível de Profundidade: " + profundidade);
          System.out.println("Caminho: " + Caminho(estado,caminho));
          System.out.println("Nós gerados: " + nosGerados);
          return;
        }
        if(estado.profundidade<j)
        {
          char[] moves = estado.matriz.movesPossiveis();
          for(int i=0; i<estado.matriz.movesPossiveis().length ; i++)
          {
            if(moves[i]!='n')
            {
              Node kid = estado.getChildren(moves[i]);
              if((kid.pai.move != 'c' && kid.move == 'b') || (kid.pai.move != 'b' && kid.move == 'c') )
              {
                stack.push(kid);
                nosGerados++;
              }
              else if((kid.pai.move != 'd' && kid.move == 'e') || (kid.pai.move != 'e' && kid.move == 'd'))
              {
                stack.push(kid);
                nosGerados++;
              }
            }
          }
        }
      }
    }
    System.out.println("Não há nenhuma solução!");
  }

  // Pesquisa Greedy(usar heurística para avaliar os nós(f(x) = h(x)))
  public static void Greedy(Tab matriz, Tab matrizF, int escolha)
  {
    long tempoInicial = System.currentTimeMillis(); // Calcular o tempo de execução
    long usedMemory = Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory();
    HashMap <String,Node > map = new HashMap < String , Node > ();
    Node inicio = new Node(matriz);
    PriorityQueue<Node> lista = new PriorityQueue<Node>();
    int nosGerados=0, profundidade=0;
    String caminho = "";
    lista.offer(inicio);
    ++nosGerados;

    while(!lista.isEmpty())
    {
      Node estado = lista.poll(); // retorna e remove o valor da primeira posicao da lista

      if(estado.matriz.equals(matrizF))
      {
        profundidade = estado.profundidade;
        System.out.println("\nEncontrou a solução!\n");
        long tempoFinal = (long) (System.currentTimeMillis());
        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
        System.out.println("Espaço de memória: " + ((finalMemory-usedMemory)/1000000) + "  MB");
        System.out.println("Nível de Profundidade: " + profundidade);
        System.out.println("Caminho: " + Caminho(estado,caminho));
        System.out.println("Nós gerados: " + nosGerados);
        return;
      }
      char[] moves = estado.matriz.movesPossiveis();
      for(int i=0; i<estado.matriz.movesPossiveis().length; i++){
        if(moves[i]!='n')
          {
            Node kid = estado.getChildren(moves[i]);
            if(!map.containsKey(kid.chave)){
              Heuristicas.menuH(kid, matrizF, escolha);
              lista.add(kid);
            }
            nosGerados++;
          }
      }
      map.put(estado.chave,estado);
    }
    System.out.println("Não há nenhuma solução!");
  }

  // Pesquisa A*(f(x) = g(x) + h(x))
  public static void AStar(Tab matriz, Tab matrizF, int escolha)
  {
    long tempoInicial = System.currentTimeMillis(); // Calcular o tempo de execução
    long usedMemory = Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory();
    Node inicio = new Node(matriz);
    PriorityQueue<Node> lista = new PriorityQueue<Node>();
    int nosGerados=0, profundidade=0;
    String caminho = "";
    lista.offer(inicio);
    ++nosGerados;

    while(!lista.isEmpty())
    {
      Node estado = lista.poll(); // retorna e remove o valor da primeira posicao da lista

      if(estado.matriz.equals(matrizF))
      {
        profundidade = estado.profundidade;
        System.out.println("\nEncontrou a solução!\n");
        long tempoFinal = (long) (System.currentTimeMillis());
        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
        System.out.println("Espaço de memória: " + ((finalMemory-usedMemory)/1000000) + "  MB");
        System.out.println("Nível de Profundidade: " + profundidade);
        System.out.println("Caminho: " + Caminho(estado,caminho));
        System.out.println("Nós gerados: " + nosGerados);
        return;
      }
      char[] moves = estado.matriz.movesPossiveis();
      for(int i=0; i<estado.matriz.movesPossiveis().length; i++){
        if(moves[i]!='n')
          {
            Node kid = estado.getChildren(moves[i]);
              Heuristicas.menuH(kid, matrizF, escolha);
              lista.add(kid);

            nosGerados++;
          }
      }
    }
    System.out.println("Não há nenhuma solução!");
  }
}
