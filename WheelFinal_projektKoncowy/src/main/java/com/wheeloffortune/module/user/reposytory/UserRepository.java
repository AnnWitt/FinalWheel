package com.wheeloffortune.module.user.reposytory;

import com.wheeloffortune.module.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    public UserEntity findOneByUuid(String uuid);

   public UserEntity findOneByUsername(String username);
}
