package com.aptest.repository;

import com.aptest.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

    Role findRoleByName(String name);
}
