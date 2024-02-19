package com.lookingprof.lookingProf.service;


import com.lookingprof.lookingProf.model.Role;
import com.lookingprof.lookingProf.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final IRoleRepository iRoleRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Role> findByName(String name) {
        return iRoleRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> listAll() {
        return iRoleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Role> findById(Integer id){
        return iRoleRepository.findById(id);
    }

    @Transactional
    public Role createRole(Role dto) {
        try{
            return iRoleRepository.save(dto);
        }catch (Exception e){
            throw new RuntimeException("Error creating the role");
        }
    }

    @Transactional
    public Role updateRole(Integer id, Role dto) {
        try{
            Role existingRole = iRoleRepository.findById(id).orElse(null);
            if(existingRole!=null){
                existingRole.setName(dto.getName());
                return iRoleRepository.save(existingRole);
            }else{
                throw new RuntimeException("Role not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error updating role");
        }
    }

    @Transactional
    public HashMap<String, String> deleteRole(Integer id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Role was deleted succesfully");
            iRoleRepository.deleteById(id);
            return response;
        }catch (Exception e){
            throw new RuntimeException("Error while delete role");
        }
    }





}
