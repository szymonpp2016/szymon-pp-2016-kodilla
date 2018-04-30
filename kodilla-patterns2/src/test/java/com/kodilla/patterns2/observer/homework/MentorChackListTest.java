package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorChackListTest {

    @Test
    public void testUpdate() {
        // Given
        TaskToChack hibernateTaskToChack = new HibernateTaskToChack();
        TaskToChack springTaskToChack = new SpringTaskToChack();
        Mentor marek = new Mentor("Marek Smith");
        Mentor witold = new Mentor("Witoldj Escobar");
        Mentor zdzisiek = new Mentor("Zdzislaw Pinkman");
        hibernateTaskToChack.registerObserver(marek);
        springTaskToChack.registerObserver(marek);
        springTaskToChack.registerObserver(witold);
        hibernateTaskToChack.registerObserver(zdzisiek);
        Student student1 = new Student("Janek Nowak", "20122018JAVA");
        Student student2 = new Student("Jasia Jasinka", "061122017JAVA");

        // When
        hibernateTaskToChack.addTask("`I make new task - can you look!` (modul 1_1) ", student1);
        hibernateTaskToChack.addTask("` I made this! I`m big!!! - can you look' (modul 1_1) ", student2);
        springTaskToChack.addTask("`Help!!! doesn't wont to work :(` (modul 2_2)",student1);
        springTaskToChack.addTask("` Steel  pls, MySql   doesn't wont to work :(' (modul 2_2) ",student1);
        springTaskToChack.addTask("` I made this!!! I`m big!!! - can you look`(modul 2_2) ", student2);

        // Then
        assertEquals(5, marek.getUpdateCount());
        assertEquals(2, zdzisiek.getUpdateCount());
        assertEquals(3, witold.getUpdateCount());
    }
}
