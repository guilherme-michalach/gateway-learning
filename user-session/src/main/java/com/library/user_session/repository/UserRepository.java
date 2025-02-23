package com.library.user_session.repository;

import com.library.user_session.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public boolean existByUsernameOrMail(String username, String mail);
}
