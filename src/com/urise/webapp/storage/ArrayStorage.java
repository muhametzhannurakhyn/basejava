package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;
import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void addElement(Resume r, int i) {
        storage[size] = r;
    }

    protected void deleteElement(int index){
        storage[index] = storage[size - 1];
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
