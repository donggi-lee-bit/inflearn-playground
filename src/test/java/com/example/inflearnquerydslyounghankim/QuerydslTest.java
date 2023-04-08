package com.example.inflearnquerydslyounghankim;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.inflearnquerydslyounghankim.entity.Member;
import com.example.inflearnquerydslyounghankim.entity.QMember;
import com.example.inflearnquerydslyounghankim.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class QuerydslTest {

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void before() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamA);
        Member member3 = new Member("member3", 10, teamB);
        Member member4 = new Member("member4", 10, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    void jpqlTest() {
        // find member entity
        String query = "select m from Member m " + "where m.username = :username";

        Member findMember = em.createQuery(query, Member.class)
            .setParameter("username", "member1")
            .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void queryDslTest() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QMember member = new QMember("m");

        Member findMember = jpaQueryFactory.select(member)
            .from(member)
            .where(member.username.eq("member1"))
            .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }
}
