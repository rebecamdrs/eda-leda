# Particionamento utilizando a estratégia de Lomuto
A estratégia de Lomuto para o particionamento é simples. Escolhe-se como o pivot o primeiro elemento e utiliza-se duas variáveis de controle: i, que representa a posição final do pivot e j que varre o array da posição 1 até o seu final. Sempre que o valor na posição j for menor que o valor do pivot, atualiza-se i e troca-se os valores das posições i e j. No fim, troca-se a posição do pivot com o valor na posição i.

Neste exercício, você deve seguir uma estratégia muito parecida, mas considerando o último elemento com o pivot e o comparando e trocando com os elementos anteriores a ele.

Importante. Você não pode pegar o último elemento, colocar na primeira posição e executar o particionamento que já conhecemos. Você deve compará-lo com os anteriores e seguir a estratégia.

Implemente um programa que leia da entrada padrão uma sequência de inteiros e particiona essa sequência utilizando a estratégia de Lomuto, mas considerando o último elemento como pivot.

## Restrições

Todos os elementos à esquerda do pivot são menores ou iguais ao pivot e todos os elementos à direita são maiores que ele;

## Entrada
Seu programa deve uma linha contendo uma sequência de inteiros separados por espaço.

## Saída
Seu programa deve imprimir o estado do array a cada troca efetuada (mesmo quando se troca um elemento por ele mesmo). Além disso, deve imprimir o estado do array ao fim da execução.

### Dica
Use Arrays.toString() para formatar a saída.

## Exemplos de execução
```bash
javac MinhaSolucao.java; java MinhaSolucao
9 5 1 8 2 6
[9, 5, 1, 2, 8, 6]
[2, 5, 1, 9, 8, 6]
[2, 5, 1, 6, 8, 9]
[2, 5, 1, 6, 8, 9]

javac MinhaSolucao.java ; java MinhaSolucao
9 -1 2 3 7 11 -3
[9, -1, 2, 3, 7, 11, -3]
[9, -1, 2, 3, 7, 11, -3]
[9, -1, 2, 3, 7, 11, -3]
[9, -1, 2, 3, 7, 11, -3]
[9, -1, 2, 3, 7, 11, -3]
[9, -1, 2, 3, 7, 11, -3]
[-3, -1, 2, 3, 7, 11, 9]
[-3, -1, 2, 3, 7, 11, 9]
```