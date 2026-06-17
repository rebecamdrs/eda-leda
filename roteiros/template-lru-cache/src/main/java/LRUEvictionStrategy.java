public class LRUEvictionStrategy {

    private LRUCache cache;

    public LRUEvictionStrategy(int capacidade) {
        this.cache = new LRUCache(capacidade);
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        if (this.cache.get(chave) != null) return "hit";
        this.cache.addLast(chave);
        return "miss";
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    * esse método não altera o estado da fila.
    **/
    public String getNextEviction() {
        if (!cache.isFull()) return null;
        return cache.getFirst();
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return cache.size();
    }

}
