package com.wheeloffortune.module.game.repository;

import com.wheeloffortune.module.game.entity.WOTEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WOTRepository extends JpaRepository<WOTEntity,Long>, JpaSpecificationExecutor<WOTEntity> {
    public WOTEntity findOneByUuid(String uuid);
}
