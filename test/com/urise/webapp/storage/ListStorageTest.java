package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;


public abstract class AbstractArrayStorageTest {
    protected final Storage storage;

    private static final Resume R1 = new Resume("uuid1");
    private static final Resume R2 = new Resume("uuid2");
    private static final Resume R3 = new Resume("uuid3");

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    private void assertSize(int expected) {
        Assert.assertEquals(expected, storage.size());
    }

    private void assertGet(Resume expected) {
        Assert.assertEquals(expected, storage.get(expected.getUuid()));
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void get() {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void save() {
        Resume r4 = new Resume("uuid4");
        storage.save(r4);
        assertSize(4);
        assertGet(r4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume("uuid1"));
    }

    @Test
    public void update() {
        Resume updated = new Resume("uuid1");
        storage.update(updated);
        assertGet(updated);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("dummy"));
    }

    @Test
    public void delete() {
        storage.delete("uuid1");
        assertSize(2);
        try {
            storage.get("uuid1");
            Assert.fail("Ожидали NotExistStorageException после удаления");
        } catch (NotExistStorageException expected) {
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        Assert.assertArrayEquals(new Resume[]{}, storage.getAll());
    }

    @Test
    public void getAll() {
        Resume[] expected = {R1, R2, R3};
        Assert.assertArrayEquals(expected, storage.getAll());
    }

    @Test
    public void overflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid" + i));
            }
        } catch (StorageException e) {
            Assert.fail("Переполнение произошло раньше времени");
        }
        try {
            storage.save(new Resume("overflow"));
            Assert.fail("Ожидали StorageException при переполнении");
        } catch (StorageException expected) {
        }
    }


}
