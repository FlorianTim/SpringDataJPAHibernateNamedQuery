package de.adesso.example.SpringDataJPAHibernateNamedQuery.repositories;

import de.adesso.example.SpringDataJPAHibernateNamedQuery.dtos.SimpleUserDTO;
import de.adesso.example.SpringDataJPAHibernateNamedQuery.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT NEW de.adesso.example.SpringDataJPAHibernateNamedQuery.dtos.SimpleUserDTO(u.username, u.mail) FROM User u WHERE u.username = :username")
    List<SimpleUserDTO> findWithNamedQuery(@Param("username") String username);

    List<SimpleUserDTO> findWithOrmXML(@Param("username") String username);
}
