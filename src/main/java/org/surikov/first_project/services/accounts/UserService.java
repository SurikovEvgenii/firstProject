package org.surikov.first_project.services.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.accounts.UserAccount;
import org.surikov.first_project.repository.accounts.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<UserAccount> findAll(){
        return (Set<UserAccount>) userRepository.findAll();
    }

    public void save(UserAccount userAccount){
        userRepository.save(userAccount);
    }

    public UserAccount findByLogin(String login){
        return userRepository.findUserAccountByLogin(login);
    }
}
