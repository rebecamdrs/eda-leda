# Remove Index LinkedList
Escreva um programa que remove um nó de uma LinkedList. O nó a ser removido está no índice passado como parâmetro na entrada padrão.

## Entrada
Seu programa irá ler uma sequência de inteiros que devem ser adicionados (addLast) em uma LinkedList. Depois, deve ler um inteiro representando o índice i do elemento a ser removido.

Você pode assumir que o índice i é válido.

## Saída
Na saída, seu programa deve imprimir a lista depois da remoção do nós.

## Restrições e Observações
Não é permitido usar estruturas auxiliares.
Você deve utilizar a sua implementação de LinkedList. Isto é, o seu addLast, o seu remove, o seu toString etc.
```bash
Exemplo de execução
javac Solucao.java; java Solucao
1 13 3 4 5
1
1 3 4 5

javac Solucao.java; java Solucao
9 7 3 5 4 3
3
9 7 3 4 3
```