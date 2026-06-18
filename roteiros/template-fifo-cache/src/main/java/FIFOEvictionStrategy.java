import java.util.*;

public class FIFOEvictionStrategy {

    private FIFOCache cache;
    private Set<String> aux;

    // deve ter uma FIFOCache como atributo
    public FIFOEvictionStrategy(int capacidade) {
        this.cache = new FIFOCache(capacidade);
        this.aux = new HashSet<>();
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String valor) {
        if (aux.contains(valor)) return "hit";
        adicionaCache(valor);
        return "miss";
    }

    private void adicionaCache(String valor) {
    	if (cache.isFull()) {
    		String elemento = cache.removeFirst();
    		aux.remove(elemento);
    	}
    	cache.addLast(valor);
    	aux.add(valor);
	}

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    **/
    public String getNextEviction() {
        if (!cache.isFull()) return null;
        return this.cache.getFirst();
    }  

    //retorna a quantidade de elementos no cache.
    public int size() {
        return this.cache.size();
    }

}
