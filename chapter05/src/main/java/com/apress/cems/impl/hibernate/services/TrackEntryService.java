package com.apress.cems.impl.hibernate.services;

import com.apress.cems.dao.Detective;
import com.apress.cems.dao.Evidence;
import com.apress.cems.dao.TrackEntry;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public interface TrackEntryService {

    Set<TrackEntry> findByDate(LocalDateTime localDate);

    Set<TrackEntry> findByEvidence(Evidence evidence);

    Set<TrackEntry> findByDetective(Detective detective);

    TrackEntry save(TrackEntry entry);
}
