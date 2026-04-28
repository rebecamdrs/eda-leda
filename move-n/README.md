# Move N
Escreva um programa que encontra valores consecutivos que quebram uma sequência e os move um a um para suas devidas posições.

A sequência sempre começa ordenada e segue ordenada até o primeiro elemento dos valores consecutivos a serem movidos. Veja um exemplo:
```
1 2 4 90 99 101 7 14 21
```

Perceba que a sequência começou ordenada (1, 2, 4...) até que o primeiro elemento que quebra é encontrado (7). Nesse caso, você deve mover todos os elementos a partir de 7 (incluindo ele) para os seus devidos lugares.

Importante: esses elementos sempre estão ordenados entre si e sempre vão até o final da sequência original.

Outro exemplo. 7 18 33 43 1 12. Os elementos 1 12 devem ser movidos para suas respectivas posições.

Você deve imprimir o estado do array sempre que houver uma troca.

## Entrada
Seu programa deve ler uma sequência de inteiros separados por espaço.

## Saída
Deve imprimir o array sempre que houver uma troca.

## Exemplo
```bash
javac Solution.java; java Solution
1 2 4 90 99 101 7 14 21
[1, 2, 4, 90, 99, 7, 101, 14, 21]
[1, 2, 4, 90, 7, 99, 101, 14, 21]
[1, 2, 4, 7, 90, 99, 101, 14, 21]
[1, 2, 4, 7, 90, 99, 14, 101, 21]
[1, 2, 4, 7, 90, 14, 99, 101, 21]
[1, 2, 4, 7, 14, 90, 99, 101, 21]
[1, 2, 4, 7, 14, 90, 99, 21, 101]
[1, 2, 4, 7, 14, 90, 21, 99, 101]
[1, 2, 4, 7, 14, 21, 90, 99, 101]
```

### Dica
Utilize Arrays.toString()

## Restrições
Você não pode usar métodos prontos de ordenação. Caso precise, implemente.

Seu programa deve apenas manipular o array de inteiros.

- insert
- remove
- pop
- qualquer função de ordenação

