package com.vacance.agreement.api.group.data;

import com.vacance.agreement.api.group.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
