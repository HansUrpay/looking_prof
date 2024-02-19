package com.lookingprof.lookingProf.controller;


import com.lookingprof.lookingProf.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {
        try{
            List<Role> roleList = roleService.listAll();
            return ResponseEntity.ok(roleList);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id){
        try{
            Optional<Role> role = roleService.findById(id);
            return role.map(value -> ResponseEntity.ok().body(value)).orElseGet( () -> ResponseEntity.notFound().build());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Role>> getRoleByName(@PathVariable String name){
        try{
            List<Role> roleList = roleService.findByName(name);
            return ResponseEntity.ok(roleList);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Role> createRole(@RequestBody Role dto){
        try {
            Role createRole = roleService.createRole(dto);
            return new ResponseEntity<>(createRole, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer id, @RequestBody Role dto){
        try{
            Role updatedRole = roleService.updateRole(id, dto);
            if (updatedRole!=null) return new ResponseEntity<>(updatedRole, HttpStatus.OK);
            else return ResponseEntity.notFound().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> deleteUser(@PathVariable Integer id){
        try{
            HashMap<String, String> response = roleService.deleteRole(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
