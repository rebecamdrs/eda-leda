# Move três
Escreva um programa que encontra três valores consecutivos que quebram uma sequência e os move um a um para suas devidas posições.

A sequência sempre começa ordenada e segue ordenada até o primeiro elemento dos trio. Veja um exemplo:
```
1 2 4 90 99 101 7 14 21
```

Perceba que a sequência começou ordenada (1, 2, 4...) até que o primeiro elemento que quebra é encontrado (7). Nesse caso, você deve mover o trio 7, 14, e 21 para os seus devidos lugares.

> [!IMPORTANT]
> esses 3 elementos sempre estão ordenados entre si.

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
Seu programa deve apenas manipular o array de inteiros.

- insert
- remove
- pop
- qualquer função de ordenação
