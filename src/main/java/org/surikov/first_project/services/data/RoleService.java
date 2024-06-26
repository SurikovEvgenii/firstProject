package org.surikov.first_project.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.data.Role;
import org.surikov.first_project.repository.data.RoleRepository;

import java.util.List;

@Service
public class RoleService {


    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(Long id){
        return roleRepository.findById(id).get();
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

}
