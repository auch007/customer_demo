package com.auch.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.auch.entity.CustomerNote;

public interface CustomerNoteRepository extends CrudRepository<CustomerNote, Long> {
    List<CustomerNote> findByCustUid(Long custUid);
}