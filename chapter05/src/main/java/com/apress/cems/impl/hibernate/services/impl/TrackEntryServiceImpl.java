package com.apress.cems.impl.hibernate.services.impl;

import com.apress.cems.dao.Detective;
import com.apress.cems.dao.Evidence;
import com.apress.cems.dao.TrackEntry;
import com.apress.cems.impl.hibernate.services.TrackEntryService;
import com.apress.cems.repos.TrackEntryRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TrackEntryServiceImpl implements TrackEntryService {

    TrackEntryRepo trackEntryRepo;

    public TrackEntryServiceImpl(TrackEntryRepo trackEntryRepo){
        this.trackEntryRepo = trackEntryRepo;
    }

    @Override
    public Set<TrackEntry> findByDate(LocalDateTime localDate) {
        return null;
    }

    @Override
    public Set<TrackEntry> findByEvidence(Evidence evidence) {
        return null;
    }

    @Override
    public Set<TrackEntry> findByDetective(Detective detective) {
        return trackEntryRepo.findByDetectiveId(detective.getId());
    }

    @Override
    public TrackEntry save(TrackEntry entry) {
        trackEntryRepo.save(entry);
        return entry;
    }
}
