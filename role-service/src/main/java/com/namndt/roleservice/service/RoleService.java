package com.namndt.roleservice.service;

import com.namndt.roleservice.dao.RoleRepository;
import com.namndt.roleservice.entity.Role;
import com.namndt.roleservice.response.RoleResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;

    public RoleResponse getRoleByName (String roleName){
        Role role = roleRepository.findRolesByRoleName(roleName);
        RoleResponse roleResponse = modelMapper.map(role, RoleResponse.class);
        return roleResponse;
    }
}
