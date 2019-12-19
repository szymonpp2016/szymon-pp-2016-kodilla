package com.kodilla.hibernate.triggerTestEntitty;

import com.kodilla.hibernate.triggerTestEntitty.dao.TriggerEntityDao;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(NAME_ASCENDING)
public class TriggerEntityTest {

    @Autowired
    private TriggerEntityDao triggerEntityDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private final String WARTOSC = "cos 1111";

    @Test
    public void shouldWriteSomethingToEntitty() {
        //Given
        TriggerEntity triggerEntity = new TriggerEntity(WARTOSC, 1);
        triggerEntityDao.save(triggerEntity);
        int id = triggerEntity.getId();
        //When

        List<TriggerEntity> task = new LinkedList<>();

        task.add(triggerEntityDao.findOne(id));

        //Them
        Assert.assertEquals(WARTOSC,  task.get(0).getThings());

    }
}