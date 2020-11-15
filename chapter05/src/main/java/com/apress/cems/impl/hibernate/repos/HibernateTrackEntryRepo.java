package com.apress.cems.impl.hibernate.repos;

import com.apress.cems.dao.TrackEntry;
import com.apress.cems.repos.TrackEntryRepo;
import com.apress.cems.util.TrackAction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Repository
public class HibernateTrackEntryRepo implements TrackEntryRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateTrackEntryRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Set<TrackEntry> findByDetectiveId(Long detectiveId) {
        Set<TrackEntry> trackEntries = (Set<TrackEntry>) session()
                .createQuery("from TrackEntry t where detective = :id")
                .setParameter("id",detectiveId);

        return trackEntries;
    }

    @Override
    public Set<TrackEntry> findByEvidenceId(Long evidenceId) {
       return null;
    }

    @Override
    public Set<TrackEntry> findByDate(Date date) {
        return null;
    }

    @Override
    public Set<TrackEntry> findByDateAndAction(Date date, TrackAction action) {
        return null;
    }

    @Override
    public void save(TrackEntry trackEntry) {
        session().persist(trackEntry);
    }

    @Override
    public void delete(TrackEntry entity) {
    }

    @Override
    public TrackEntry update(TrackEntry entity) {
        return null;
    }

    @Override
    public int deleteById(Long entityId) {
        return 0;
    }

    @Override
    public Optional<TrackEntry> findById(Long entityId) {
        return Optional.empty();
    }
}
