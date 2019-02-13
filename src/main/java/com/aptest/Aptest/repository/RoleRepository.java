package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

    Role findRoleByName(String name);
}
