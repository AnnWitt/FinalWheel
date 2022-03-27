package com.wheeloffortune.module.word.repository;

import com.wheeloffortune.module.word.entity.CategoryEntity;
import com.wheeloffortune.module.word.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Long>, JpaSpecificationExecutor<WordEntity> {
    public WordEntity findOneByUuid(String uuid);
    @Query(value = "select * from word order by RAND() LIMIT 1", nativeQuery = true)
    public WordEntity findRandomWord();
    @Query(value = "select * from word by RAND() LIMIT 1", nativeQuery = true)
    public WordEntity findRandomWordWithExactCategory(CategoryEntity category);
}
