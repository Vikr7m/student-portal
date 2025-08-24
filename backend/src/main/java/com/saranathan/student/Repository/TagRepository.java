package com.saranathan.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.Tags;

@Repository
public interface TagRepository extends JpaRepository<Tags, Integer> {

    @Query(nativeQuery = true, value = "SELECT tagid FROM tags WHERE name = :tag")
    int getIdByTagName(@Param("tag") String tag);
}
