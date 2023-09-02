package com.vacance.agreement.api.date.data;

import java.util.List;

public interface DateRepositoryCustom {
    List<String> findDatesByMemberId(Long id);
}
