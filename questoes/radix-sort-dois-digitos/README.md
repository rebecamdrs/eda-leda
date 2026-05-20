# Radix Dois Dígitos
Escreva um programa que ordene uma sequência de números seguindo a estratégia do Radix Sort. Você deve usar o counting sort como rotina de ordenação primária. Contudo, ao invés de ordenar dígito a dígito, você vai ordenar a cada par de dígitos.

## Entrada
Seu programa deve ler duas linhas da entrada padrão. A primeira é uma sequência de inteiros separados por espaço e a segunda um número inteiro d representando a quantidade de dígitos dos elementos lidos.

Importante: Você pode considerar que todos os valores a serem ordenados tem a mesma quantidade d de dígitos. Também pode considerar que d é par. Além disso, para faciliar a implementação, você pode considerar que não haverá nenhum número com 0 em sua composição.

## Saída
Seu programa deve imprimir os resultados parciais da ordenação. Ou seja, imprimir o array sempre que a rotina do counting sort em um determinado par de dígitos terminar. Veja o exemplo da ordenação para o seguinte array [7843, 5374, 2344, 8543].

Na primeira execução do counting sort, ele deve levar em consideração 43, 74, 44 e 43, que são os números formados pela concatenação do dois primeiros dígitos (mais à direita) de cada número.

Depois, deve levar em consideração os números 78, 53, 23 e 85, que são os números formados pela concatenação dos dígitos 3 e 4 (mais à direita) de cada número.

## Exemplos
```bash
javac Solution.java; java Solution
7843 5374 2344 8543
4
[7843, 8543, 2344, 5374]
[2344, 5374, 7843, 8543]
```

### Dica
Utilize Arrays.toString().

## Restrições
Não é permitido usar Arrays.sort ou qualquer método pronto de bibliotecas de ordenação. Caso precise, implemente.

Seu programa deve apenas manipular o array de inteiros. Não pode usar funções como:

- insert
- remove
- pop
- qualquer função de ordenação que não tenha sido feita por você