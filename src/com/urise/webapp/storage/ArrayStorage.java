package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[100];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0; // Сбрасываем размер
    }

    public void save(Resume r) {
        if (storage.length <= size) {
            System.out.println("хранилище переполнено");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Такое уже есть");
                return;
            }
        }

        if (r == null) {
            System.out.println("Пустое резюме");
            return;
        }

        storage[size++] = r;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме с таким uuid нету в хранилище.");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Резюме с таким uuid нету в хранилище.");
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }


    public int size() {
        return size;
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                storage[i] = r;
                return;
            }
        }
        System.out.println("Резюме с uuid " + r.getUuid() + " не найдено.");
    }
}


//public void update(Resume r){
//        for(int i = 0; i < size; i++) {
//            if(storage[i].getUuid().equals(r.getUuid())) {
//                storage[i] = r;
//            }else{
//                System.out.println("Резюме с таким uuid не найдено.");
//            }
//        }
//    }

// почему у ууид проверям