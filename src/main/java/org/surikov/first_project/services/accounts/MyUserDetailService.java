package org.surikov.first_project.services.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.entities.accounts.UserAccount;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Autowired
    DesignerService designerService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        UserAccount userAccount = userService.findByLogin(login);
        DesignerAccount designerAccount = designerService.findDesignerByLogin(login);
        UserDetails userDetails = null;

        if(userAccount!=null && designerAccount==null){
            userDetails = User.builder().username(userAccount.getLogin()).password(userAccount.getPassword()).roles(userAccount.getRole().getRole()).build();
            return userDetails;
        } else if(designerAccount!=null && userAccount==null){
            userDetails = User.builder().username(designerAccount.getLogin()).password(designerAccount.getPassword()).roles(designerAccount.getRole().getRole()).build();
            System.out.println(designerAccount.getRole().getRole());
            return userDetails;
         } else {
            throw new UsernameNotFoundException("Not found user:" + login);
        }
    }
}
