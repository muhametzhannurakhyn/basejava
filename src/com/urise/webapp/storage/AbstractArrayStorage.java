package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;
    public final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Такое уже есть");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Хранилище переполнено");
        }else{
            addElement(r, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index < 0){
            System.out.println("Резюме с таким uuid нету в хранилище.");
        }else {
            deleteElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if(index == -1 ) {
            System.out.println("Резюме с uuid " + r.getUuid() + " не найдено.");
        }else{
            storage[index] = r;
        }
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме с таким uuid нету в хранилище.");
            return null;
        }
        return storage[index];
    }



    protected abstract int getIndex(String uuid);

    protected abstract void addElement(Resume r, int index);

    protected abstract void deleteElement(int index);
}
