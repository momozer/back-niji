package testService;

import com.niji.lille.nijiVerse.NijiVerseApplication;
import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.repositories.UserRepository;
import com.niji.lille.nijiVerse.services.UserService;
import com.niji.lille.nijiVerse.services.serviceImpl.UserServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@SpringBootTest(classes = NijiVerseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserServiceImpl {
    private UserService userService;

    @Spy
    private UserRepository userRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Spy
    private User u1, u2, u3;

    @Before
    public void initialization() {
        u1 = new User("Frodo", "porteur@anneaux.fr", "unique");
        u2 = new User("Samsagace", "porteur@frodo.fr", "MrFrodo");
        u3 = new User("Gollum", "voleur@anneaux.fr", "MonPrecieux");
        u1.setId(0L);
        u2.setId(1L);
        u3.setId(2L);
        this.userRepository = new MockUserRepository();
        this.userService = new UserServiceImpl(this.userRepository);
    }

    @Test
    public void testFindAll() {
        this.userService.save(u1);
        List<User> test = this.userService.findAll();
        assertTrue(test.contains(u1));
        this.userService.save(u2);
        test = this.userService.findAll();
        assertTrue(test.contains(u1));
        assertTrue(test.contains(u2));
        assertFalse(test.contains(u3));
    }

    @Test
    public void testSaveNotNull() {
        User save = this.userService.save(u1);
        assertNotNull(save);
        assertNotNull(save.getId());

    }

    @Test
    public void testSaveGoodSave(){
        User save = this.userService.save(u1);
        assertEquals(u1.getId(), save.getId());
        assertEquals(u1.getUsername(), save.getUsername());
        assertEquals(u1.getEmail(), save.getEmail());
        assertEquals(u1.getPassword(), save.getPassword());
    }

    @Test
    public void testUpdate() {
        try {
            String oldPassword = this.u1.getPassword();
            User test = this.userService.save(u1);
            assertEquals(u1.getPassword(), test.getPassword());
            u1.setPassword("Bilbo");
            test = this.userService.update(u1);
            assertNotEquals(oldPassword, test.getPassword());
            assertEquals(u1.getPassword(), test.getPassword());
        } catch (ResponseStatusException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testUpdateException() {
        assertThrows(ResponseStatusException.class, () ->
                this.userService.update(u1));
    }

    @Test
    public void testFindById() {
        try {
            this.userService.save(u1);
            User user = this.userService.findById(u1.getId());
            assertNotNull(user);
            assertEquals(u1, user.getId());
        } catch (ResponseStatusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFindByIdException() {
        assertThrows(ResponseStatusException.class, () ->
                this.userService.findById(0L));
    }

    @Test
    public void testFindByEmail() {
        assertEquals(Optional.empty(), this.userService.findByEmail(u1.getEmail()));
        this.userService.save(u1);
        assertEquals(Optional.of(u1), this.userService.findByEmail(u1.getEmail()));
    }

    @Test
    public void testFindByUsername() {
        assertEquals(Optional.empty(), this.userService.findByUsername(u1.getUsername()));
        this.userService.save(u1);
        assertEquals(Optional.of(u1), this.userService.findByUsername(u1.getUsername()));
    }

    @Test
    public void testDeleteById() {
        try {
            this.userService.save(u1);
            User user = this.userService.findById(u1.getId());
            assertEquals(u1, user.getId());
            this.userService.deleteById(u1.getId());
            assertNotEquals(u1, this.userService.findById(u1.getId()));
        } catch (ResponseStatusException e) {
            System.out.println(e.getMessage());
        }
    }

}

