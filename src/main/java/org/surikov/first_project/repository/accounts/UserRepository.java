package org.surikov.first_project.repository.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.accounts.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findUserAccountByLogin(String login);
}
