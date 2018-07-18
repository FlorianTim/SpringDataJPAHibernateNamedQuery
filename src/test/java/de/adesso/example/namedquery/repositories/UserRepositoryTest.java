package de.adesso.example.namedquery.repositories;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import de.adesso.example.namedquery.dbtest.hsql.HSQLAbstractRepositoryTest;
import de.adesso.example.namedquery.dtos.SimpleUserDTO;
import de.adesso.example.namedquery.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DatabaseSetup("/UserRepositoryTest.xml")
public class UserRepositoryTest extends HSQLAbstractRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAll() {
        List<User> all = userRepository.findAll();
        Assert.assertEquals(all.size(), 1);
    }

    @Test
    public void findWithNamedQuery() {
        List<SimpleUserDTO> users = userRepository.findWithNamedQuery("JanJedermann");
        Assert.assertEquals(users.get(0).getMail(), "Jan.Jedermann@testmail.com");
    }

    /**
     * This fails with "org.hibernate.QueryException: ResultTransformer is not allowed for 'select new' queries"
     * for spring-data-jpa 2.0.x.RELEASE > 2.0.3.RELEASE
     */
    @Test
    public void findWithOrmXML() {
        List<SimpleUserDTO> users = userRepository.findWithOrmXML("JanJedermann");
        Assert.assertEquals(users.get(0).getMail(), "Jan.Jedermann@testmail.com");
    }
}