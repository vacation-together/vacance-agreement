package com.vacance.agreement.api.date.data;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vacance.agreement.api.date.model.QDate;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DateRepositoryCustomImpl implements DateRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<String> findDatesByMemberId(Long memberId) {
        return jpaQueryFactory.select(QDate.date.selectedDate)
            .from(QDate.date)
            .where(QDate.date.memberId.eq(memberId))
            .fetch();
    }
}
