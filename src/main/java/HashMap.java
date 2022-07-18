import java.util.ArrayList;
import java.util.List;

public class HashMap<K,V> {
    Object[] keys;
    Object[] values;
    int size;

    HashMap(){
        keys = new Object[100];
        values = new Object[100];
        int size =0;
    }
    void put( K key,  V value){
        int keyIndex = indexOfKey(key);

        if(keyIndex != -1){
            values[keyIndex]=value;
            return;
        }
        keys[size]=key;
        values[size]=value;
        size++;
    }
    V get( K key){
        int keyIndex = indexOfKey(key);

        if (keyIndex == -1) {
            return null;
        }

        return (V) values[keyIndex];
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }

        return -1;
    }

    void remove(K k){
        //삭제하고 size를 통해서 확인하기
        int check = indexOfKey(k);

        if(check!=-1){
            for(int i = check; i<size-1; i++){
                keys[check-1]=keys[check+1];
            }
            for(int i = check; i<size-1; i++){
                values[check-1]=values[check+1];
            }
            size--;
        }
    }

    public int size() {
        return size;
    }
    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();

        for ( int i = 0; i < size; i++ ) {
            keySet.add((K)keys[i]);
        }

        return keySet;
    }
}
