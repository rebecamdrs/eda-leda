import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanho = sc.nextInt();
        TabelaHash th = new TabelaHash(tamanho);

        while (sc.hasNext()) {
            String comando = sc.next();

            if (comando.equals("end")) break;

            switch (comando) {
                case "put":
                    int putKey = sc.nextInt();
                    String putValue = sc.next();
                    th.put(putKey, putValue);
                    break;

                case "remove":
                    int removeKey = sc.nextInt();
                    th.remove(removeKey);
                    break;

                case "keys":
                    th.keys();
                    break;

                case "values":
                    th.values();
                    break;
            }
        }
        sc.close();
    }
    
}

class TabelaHash {
    private int M;
    private ArrayList<Tupla>[] tabela;

    public TabelaHash(int M) {
        this.M = M;
        this.tabela = new ArrayList[M];
    }

    public int hash(int key) {
        return key % this.M;
    }

    public void put(int key, String value) {
        int indice = hash(key);
        ArrayList<Tupla> lista = this.tabela[indice];

        // se não tiver uma lista na célula cria e adiciona a tupla
        if (lista == null) {
            lista = new ArrayList<>();
            lista.add(new Tupla(key, value));
            this.tabela[indice] = lista;
        } 

        // caso já tenha uma lista checa se o elemento já existe e atualiza o valor, ou adiciona a nova tupla
        else {
            boolean atualizou = false;
            for (Tupla t : tabela[indice]) {
                if (t.key == key) {
                    t.value = value;
                    atualizou = true;
                    break;
                }
            }
            if (!atualizou) {
                lista.add(new Tupla(key, value));
            }
        }
        print();
    }

    public void remove(int key) {
        int indice = hash(key);
        ArrayList<Tupla> lista = this.tabela[indice];

        if (lista != null) {
            Iterator<Tupla> it = lista.iterator();
            Tupla atual;

            while (it.hasNext()) {
                atual = it.next();
                if (atual.key == key) {
                    it.remove();
                }
            }
        }

        print();
    }

    public void keys() {
        // conta quantos elementos no total existem na tabela
        int totalElementos = 0;
        for (int i = 0; i < this.M; i++) {
            if (tabela[i] != null) {
                totalElementos += tabela[i].size();
            }
        }

        int[] keys = new int[totalElementos];
        
        // percorre a tabela preenchendo o array
        int index = 0;
        for (int i = 0; i < this.M; i++) {
            if (tabela[i] != null) {
                for (Tupla t : tabela[i]) {
                    keys[index] = t.key;
                    index++;
                }
            }
        }

        Arrays.sort(keys);
        System.out.println(Arrays.toString(keys));
    }

    public void values() {
        // conta quantos elementos no total existem na tabela
        int total = 0;
        for (int i = 0; i < this.M; i++) {
            if (tabela[i] != null) {
                total += tabela[i].size();
            }
        }

        String[] values = new String[total];
        
        // percorre a tabela preenchendo o array
        int index = 0;
        for (int i = 0; i < this.M; i++) {
            if (tabela[i] != null) {
                for (Tupla t : tabela[i]) {
                    values[index] = t.value;
                    index++;
                }
            }
        }

        Arrays.sort(values);
        System.out.println(Arrays.toString(values));
    }


    public void print() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < M; i++) {
            if (tabela[i] == null) {
                sb.append("[]");
            } else {
                sb.append(tabela[i].toString());
            }
            if (i < M - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        System.out.println(sb.toString());
    }

}

class Tupla {
    int key;
    String value;

    public Tupla(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + key + ", " + value + ">";
    }
}