package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;
import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if(getIndex(r.getUuid()) != -1){
            System.out.println("Такое уже есть");
        }
        else if(size == storage.length) {
            System.out.println("хранилище переполнено");
        }else{
            storage[size++] = r;
        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index == -1){
            System.out.println("Резюме с таким uuid нету в хранилище.");
        }else{storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
        }
    }


    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++){
            if(storage[i].getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;
    }


}
