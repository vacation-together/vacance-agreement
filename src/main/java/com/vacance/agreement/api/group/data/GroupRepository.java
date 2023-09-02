package com.vacance.agreement.api.group.data;

import com.vacance.agreement.api.group.model.Group;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g FROM Group g " +
            "WHERE g.id = :groupId")
    @EntityGraph(attributePaths = {"memberList"})
    Optional<Group> findByIdWithMember(@Param("groupId") long groupId);
}
