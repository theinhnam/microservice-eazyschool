package com.namndt.roleservice.dao;

import com.namndt.roleservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findRolesByRoleName(String roleName);
}
