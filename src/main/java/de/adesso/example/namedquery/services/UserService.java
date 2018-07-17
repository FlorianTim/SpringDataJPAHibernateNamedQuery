package de.adesso.example.SpringDataJPAHibernateNamedQuery.services;

import de.adesso.example.SpringDataJPAHibernateNamedQuery.dtos.SimpleUserDTO;
import de.adesso.example.SpringDataJPAHibernateNamedQuery.entities.User;
import de.adesso.example.SpringDataJPAHibernateNamedQuery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public SimpleUserDTO findByUsername(String username) {
        List<SimpleUserDTO> users = userRepository.findWithNamedQuery(username);
        return users.get(0);
    }

    public SimpleUserDTO findByUsernameOrmXML(String username) {
        List<SimpleUserDTO> users = userRepository.findWithOrmXML(username);
        return users.get(0);
    }

    public User createUser(String firstname, String lastname) {
        String username = firstname + lastname;
        String mail = firstname + "." + lastname + "@testmail.com";
        return userRepository.save(new User(firstname, lastname, username, mail));
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
