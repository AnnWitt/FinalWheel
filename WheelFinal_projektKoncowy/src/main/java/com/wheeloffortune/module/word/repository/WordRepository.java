package com.wheeloffortune.module.word.repository;

import com.wheeloffortune.module.word.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Long>, JpaSpecificationExecutor<WordEntity> {
    public WordEntity findOneByUuid(String uuid);
}
