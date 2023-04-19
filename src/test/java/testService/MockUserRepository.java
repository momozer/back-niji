package testService;

import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.repositories.UserRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@TestConfiguration
public class MockUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();
    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> save = Optional.empty();
        int i = 0;
        while (i < this.users.size() && save.equals(Optional.empty())) {
            if (this.users.get(i).getUsername().equals(username)) {
                save = Optional.of(this.users.get(i));
            }
        }
        return save;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> save = Optional.empty();
        int i = 0;
        while (i < this.users.size() && save.equals(Optional.empty())) {
            if (this.users.get(i).getEmail().equals(email)) {
                save = Optional.of(this.users.get(i));
            }
        }
        return save;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) { return false;}

    @Override
    public void flush() {

    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Long aLong) {
        return null;
    }

    @Override
    public User getById(Long aLong) {
        return null;
    }

    @Override
    public User getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends User> S save(S entity) {
        this.users.add(entity);
        return entity;
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        boolean save = false;
        int i = 0;
        while (i < this.users.size() && !save) {
            if (this.users.get(i).getId() == aLong) {save = true;}
            i++;
        }
        return save;
    }

    @Override
    public List<User> findAll() {return this.users;}

    @Override
    public List<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        for(int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getId() == aLong) {
                this.users.remove(i);
            }
        }
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findAll(Sort sort) {
        return this.users;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {return null;}
}
