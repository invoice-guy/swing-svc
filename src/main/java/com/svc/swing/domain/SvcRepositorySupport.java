package com.svc.swing.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.svc.swing.domain.QSvc.svc;


@Repository
public class SvcRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public SvcRepositorySupport(JPAQueryFactory queryFactory) {
        super(Svc.class);
        this.queryFactory = queryFactory;
    }

    public List<Svc> findBySvcnum(String svcnum) {
        return queryFactory.selectFrom(svc)
                .where(svc.svcnum.eq(svcnum))
                .fetch();
    }


}