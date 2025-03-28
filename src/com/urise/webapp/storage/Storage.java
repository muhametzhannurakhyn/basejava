package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public interface Storage {

    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    public int size();

    public void update(Resume r);

 }
