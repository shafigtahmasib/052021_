public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.addElement(1);
        cache.addElement(2);
        cache.addElement(3);
        cache.addElement(4);
        cache.addElement(5);
        cache.addElement(6);



        System.out.println(cache.getElement(9));
        cache.printAll();
    }
}
