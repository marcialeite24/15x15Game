# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
#                                                                       #
#             TRABALHO PRÁTICO 1 DE INTELIGÊNCIA ARTIFICIAL             #
#                                                                       #
#                       _______________________                         #
#                      |                       |                        #
#                      |      JOGO DOS 15      |                        #
#                      |_______________________|                        #
#                                                                       #
#     Jogo dos 15: apresenta algoritmos de busca para a resolução       #
#                  do problema (BFS, DFS, IDFS, Greedy, A*).            #
#                                                                       #
# _____________________________________________________________________ #
#                                                                       #
#     Executáveis: Na pasta que contém os códigos-fonte, ao digitar     #
#                  no terminal o seguinte comando:                      #
#                  'javac Jogo15x15.java && javac Heuristicas.java'     #
#                  os ficheiros executáveis serão criados               #
#                  automaticamente e poderá executar o programa         #
#                  criando um ficheiro .txt(input.txt, por exemplo)     #
#                  na mesma pasta com 16 números diferentes de 0 a      #
#                  15 duas vezes para definir a configuração inicial    #
#                  final e depois digitar o número da opção pretendida. #
#                  Exemplo:                                             #
#                  13 11 15 4 8 9 1 5 12 14 0 2 7 10 3 6                #
#                  13 11 4 5 8 0 14 15 12 1 3 2 7 9 10 6                #
#                  1                                                    #
#                  A seguir basta digitar no terminal o seguinte        #
#                  comando: 'javac Jogo15x15 < input.txt' para          #
#                  executar o programa.                                 #
# _____________________________________________________________________ #
#                                                                       #
#      BFS(Breadth-First Search): Pesquisa em Largura                   #
#      DFS(Depth-First Search): Pesquisa em Profundidade                #
#      IDFS(Interative Depth Search): Pesquisa Interativa em            #
#                                     Profundidade                      #
#      Greedy: Pesquisa Gulosa, usa uma heurística para avaliar os      #
#              nós(f(N) = h(N))                                         #
#      A*: Pesquisa resultante da junção do BFS com o Dikstra           #
#          (f(N) = g(N) + h(N))                                         #
# _____________________________________________________________________ #
#                                                                       #
#                  Márcia Leite, up2017059510@fc.up.pt                  #
#                  Mariana Valadares, up201705875@fc.up.pt              #
#                                                                       #
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
