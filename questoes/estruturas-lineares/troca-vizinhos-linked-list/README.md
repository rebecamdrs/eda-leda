# Troca Vizinhos LinkedList

Escreva um programa que troca nós vizinhos de uma LinkedList. Você não poderá trocar os valores, deve trocar os nós, isto é, manipular as referências next e prev para a troca.

## Entrada
Seu programa irá ler uma sequência de inteiros que devem ser adicionados (addLast) em uma LinkedList. Depois, deve ler um inteiro representando o índice i do elemento a ser trocado. Você deve trocar os elementos no índice i e i+1 apenas.

Você pode assumir que os índices i e i+1 são índices válidos.

## Saída
Na saída, seu programa deve imprimir a lista depois da troca dos nós nos índices i e i+1.

## Restrições e Observações
Não é permitido usar estruturas auxiliares.
Você deve utilizar a sua implementação de LinkedList.

## Exemplo de execução
```bash
javac Solucao.java; java Solucao
1 13 3 4 5
1
1 3 13 4 5

javac Solucao.java; java Solucao
9 7 3 5 4 3
3
9 7 3 4 5 3
```