package com.weddingplanner.repositories;

import com.weddingplanner.entity.UserEventRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRoleRepository extends JpaRepository<UserEventRole, Integer> {
}
