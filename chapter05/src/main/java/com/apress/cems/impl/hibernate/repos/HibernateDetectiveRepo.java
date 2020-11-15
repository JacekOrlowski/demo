package com.apress.cems.impl.hibernate.repos;

import com.apress.cems.dao.Detective;
import com.apress.cems.dao.Person;
import com.apress.cems.repos.DetectiveRepo;
import com.apress.cems.util.Rank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class HibernateDetectiveRepo implements DetectiveRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateDetectiveRepo(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Key method for obtaining a session
     * @return
     */
    protected Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Set<Detective> findAll() {
        List<Detective> detectives = (List<Detective>)session().createQuery("FROM Detective ").list();
        return detectives.isEmpty()? new HashSet<>() : new HashSet<>(detectives);
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        Detective detective = (Detective)session()
                .createQuery("from Detective d where d.badgeNumber = :bn")
                .setParameter("bn",badgeNumber).uniqueResult();
        return detective == null ? Optional.empty() : Optional.of(detective);
    }

    @Override
    public Set<Detective> findbyRank(Rank rank) {
        return null;
    }

    @Override
    public void save(Detective detective) {
        session().persist(detective);
    }

    @Override
    public void delete(Detective entity) {
    }

    @Override
    public Detective update(Detective entity) {
        return null;
    }

    @Override
    public int deleteById(Long entityId) {
        return 0;
    }

    @Override
    public Optional<Detective> findById(Long entityId) {
        Detective detective = session().get(Detective.class, entityId);
        return detective == null? Optional.empty() : Optional.of(detective);
    }
}
