package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;
import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] STORAGE_LIMIT = new Resume[10000];
    private int size = 0;


    public void clear() {
        Arrays.fill(STORAGE_LIMIT, 0, size, null);
        size = 0;
    }


    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (STORAGE_LIMIT.length <= size) {
            System.out.println("хранилище переполнено");
            return;
        }

        if (index >= 0) {
            System.out.println("Такое уже есть");
            return;
        }

        if (r == null) {
            System.out.println("Пустое резюме");
            return;
        }

        STORAGE_LIMIT[size++] = r;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return STORAGE_LIMIT[index];
        }
        System.out.println("Резюме с таким uuid нету в хранилище.");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            STORAGE_LIMIT[index] = STORAGE_LIMIT[size - 1];
            STORAGE_LIMIT[size - 1] = null;
            size--;
        }
        System.out.println("Резюме с таким uuid нету в хранилище.");
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = STORAGE_LIMIT[i];
        }
        return result;
    }


    public int size() {
        return size;
    }



    public void update(Resume r) {
        int index = getIndex(r.getUuid());

        if(index >= 0 ) {
            STORAGE_LIMIT[index] = r;
            return;
        }
        System.out.println("Резюме с uuid " + r.getUuid() + " не найдено.");
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++){
            if(STORAGE_LIMIT[i].getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;
    }


}


// почему у ууид проверям