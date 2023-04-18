package testService;


import com.niji.lille.nijiVerse.NijiVerseApplication;
import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NijiVerseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserServiceImpl {
    @Autowired
    private UserService service;

    private User u1, u2, u3;
    private List<User> all;

    @Before
    public void initialization() {
        /*u1 = User.builder()
                .username("Frodo")
                .email("porteur@anneaux.fr")
                .password("unique")
                .build();
        u2 = User.builder()
                .username("Samsagace")
                .email("porteur@frodo.fr")
                .password("MrFrodo")
                .build();
        u3 = User.builder()
                .username("Gollum")
                .email("voleur@anneaux.fr")
                .password("MonPrecieux")
                .build();*/
        u1 = new User("Frodo", "porteur@anneaux.fr", "unique");
        u2 = new User("Samsagace", "porteur@frodo.fr", "MrFrodo");
        u3 = new User("Gollum", "voleur@anneaux.fr", "MonPrecieux");

        all = new ArrayList<>();
        all.add(u1);
        all.add(u2);
    }

    @Test
    public void testFindAll() {
        service.save(u1);
        service.save(u2);
        List<User> test = service.findAll();
        //assertEquals(all, test);
        //assertTrue(test.containsAll(all));
        assertTrue(test.contains(u1));
        assertTrue(test.contains(u2));
        assertFalse(test.contains(u3));
    }

    @Test
    public void testSaveNotNull() {
        User save = service.save(u1);
        assertNotNull(save);
        assertNotNull(save.getId());
    }

    @Test
    public void testSaveGoodSave(){
        User save = service.save(u1);
        assertEquals(u1.getId(), save.getId());
        assertEquals(u1.getUsername(), save.getUsername());
        assertEquals(u1.getEmail(), save.getEmail());
        assertEquals(u1.getPassword(), save.getPassword());
    }

    @Test
    public void testUpdate() {}

    @Test
    public void testFindById() {}

    @Test
    public void testFindByEmail() {}

    @Test
    public void testFindByUsername() {}

    @Test
    public void testDeleteById() {}

}

