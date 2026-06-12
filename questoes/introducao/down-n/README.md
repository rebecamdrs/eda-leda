# Down-n
Escreva um programa que imprima os n menores elementos de uma sequência.

## Entrada
Seu programa deve ler duas linhas da entrada padrão. A primeira é uma sequência de inteiros separados por espaço e a segunda um número inteiro n representando a quantidade de elementos a serem impressos.

Importante: você pode considerar que n sempre é maior ou igual a 1 e menor ou igual ao número de elementos da sequência.

## Saída
Seu programa deve imprimir de forma crescente o n menores elementos da sequência lida.

## Exemplo

```bash
java Solution.java; java Solution
9 3 1 7 34 22 101 7 300 1 45
3
1 1 3

javac Solution.java; java Solution
9 3 1 7 34 22 101 7 300 1 45
4
1 1 3 7
```

### Dica
Utilize Arrays.toString().

## Restrições
Não é permitido usar arrays auxiliares.

Não é permitido usar Arrays.sort ou qualquer método pronto de bibliotecas de ordenação. Caso precise, implemente.

Seu programa deve apenas manipular o array de inteiros. Não pode usar funções como:

- insert
- remove
- pop
- qualquer função de ordenação
