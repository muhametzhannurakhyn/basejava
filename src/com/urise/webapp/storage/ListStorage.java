package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer>{
    List<Resume> list = new ArrayList<>();

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) return i;
        }
        return -1;
    }


    protected Resume[] doGetAll() {
        return new Resume[0];
    }

    protected boolean isExist(Integer key) { return key >= 0; }


    protected void doSave(Integer key, Resume r) { list.add(r); }


    protected void doUpdate(Integer key, Resume r) { list.set(key, r); }


    protected Resume doGet(Integer key) { return list.get(key); }


    protected void doDelete(Integer key) { list.remove((int) key); }


    protected void doClear() { list.clear(); }


    protected int doSize() { return list.size(); }
}
