import java.util.ArrayList;
import java.util.Queue;

public class LRUCache<T> {
    T item;
    int size=0;
    int arrLength;
    Object[] array;
    LRUCache(int arrLength){
        this.size = size;
        this.arrLength = arrLength;
        array = new Object[arrLength];
    }

    void addElement(T item){
        if(size==arrLength){
            int count = 0;
            while(count<size-1){
                array[count]=array[count+1];
                count++;
            }
            array[arrLength-1] =item;
        }
        else {
            array[size] = item;
            size++;
        }
    }

    T getElement(int index){
        if(index>size-1)
            return null;
        item = (T)array[index];
        return item;
    }

    void printAll(){
        int count = 0;
        while(count<size){
            System.out.println(array[count]);
            count++;
        }
    }


}
