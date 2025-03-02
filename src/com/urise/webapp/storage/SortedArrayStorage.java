package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if(index >= 0){
            System.out.println("Такое уже есть");
        }
        else if(size == storage.length) {
            System.out.println("хранилище переполнено");
        }else{
            int insertIndex = -index - 1;
            System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
            storage[insertIndex] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index < 0){
            System.out.println("Резюме с таким uuid нету в хранилище.");
        }else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            storage[size - 1] = null;
            size--;
        }
    }




    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}

