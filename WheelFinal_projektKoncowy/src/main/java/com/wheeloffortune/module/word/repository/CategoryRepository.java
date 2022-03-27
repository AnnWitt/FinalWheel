package com.wheeloffortune.module.word.repository;

import com.wheeloffortune.module.word.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>, JpaSpecificationExecutor<CategoryEntity> {
    public CategoryEntity findOneByUuid(String uuid);
    @Query(value = "select * from category order by RAND() LIMIT 1", nativeQuery = true)
    public CategoryEntity findRandomCategory();
}
