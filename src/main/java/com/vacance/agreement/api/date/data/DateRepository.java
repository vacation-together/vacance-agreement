package com.vacance.agreement.api.date.data;

import com.vacance.agreement.api.date.model.Date;
import com.vacance.agreement.api.member.model.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long>, DateRepositoryCustom {
}
