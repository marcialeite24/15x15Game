// Construtor do nó juntamente com a matriz
class Node implements Comparable<Node>
{
  Tab matriz;
  Node pai;
  Node[] filho;
  char move;
  int custo;
  int profundidade;
  String chave;

  // Função do nó pai
  Node(){
    this.matriz = null;
    this.pai = null;
    this.filho = new Node[4];
    this.move = 'n';
    this.custo = 0;
    this.profundidade = 0;
    this.chave ="";
  }

  // Função para retornar uma string para evitar correr o mesmo caminho
  public static String stringChave(Tab tab)
  {
    String chave = "";
    for(int i = 0; i < 4; i++)
    {
      for(int j = 0; j < 4; j++)
      {
        chave += tab.matriz[i][j];
      }
    }
    return chave;
  }

  // Nó pai recebe a matriz inicial
  Node(Tab matrizPai)
  {
    this.matriz = matrizPai;
    this.pai = null;
    this.filho = new Node[4];
    this.move = 'n';
    this.custo = 0;
    this.profundidade = 0;
    this.chave = stringChave(matrizPai);
  }

  // Nó filho que recebe a matriz pai juantamente com o movimento que é para fazer e o nó pai
  Node(Tab matrizPai, char move, Node pai)
  {
    matriz = matrizPai;
    matriz.fazermovimento(move);
    this.pai = pai;
    this.filho = new Node[4];
    this.move = move;
    this.profundidade = pai.profundidade + 1;
    this.custo = 0;
    this.chave = stringChave(matriz);
  }

  // Função que cria nós filhos um a um
  Node getChildren(char c)
  {
    Tab tab= new Tab(matriz);
    Node filhos = new Node(tab,c,this);
    return filhos;
  }

  // Caminho feito apartir de um certo nó
  static String Caminho(Node no,String caminho)
  {
    if(no.move == 'n')
    {
      caminho = new StringBuffer(caminho).reverse().toString();
      return caminho;
    }
    else
    {
      caminho += no.move;
      no = no.pai;
      return Caminho(no, caminho);
    }
  }
  @Override
  public int compareTo(Node n)
  {
    if(custo <= n.custo)
      return -1;
    return 1;
  }
}
