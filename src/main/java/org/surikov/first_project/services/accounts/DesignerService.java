package org.surikov.first_project.services.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.repository.accounts.DesignerRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class DesignerService {

    private DesignerRepository designerRepository;

    @Autowired
    public DesignerService(DesignerRepository designerRepository) {
        this.designerRepository = designerRepository;
    }

    public Set<DesignerAccount> findAll(){
        return (Set<DesignerAccount>)designerRepository.findAll();
    }

    public DesignerAccount findById(Long id){
        Optional<DesignerAccount> optionalDesignerAccount = designerRepository.findById(id);
        return optionalDesignerAccount.get();
    }

    public DesignerAccount findDesignerByLogin(String login){
        return designerRepository.findDesignerAccountByLogin(login);
    }

    public void save(DesignerAccount account){
        designerRepository.save(account);
    }

}
