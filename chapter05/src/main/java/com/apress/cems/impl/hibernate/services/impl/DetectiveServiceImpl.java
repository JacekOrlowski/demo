package com.apress.cems.impl.hibernate.services.impl;

import com.apress.cems.dao.Detective;
import com.apress.cems.impl.hibernate.services.DetectiveService;
import com.apress.cems.repos.DetectiveRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DetectiveServiceImpl implements DetectiveService {

    DetectiveRepo detectiveRepo;

    public DetectiveServiceImpl(DetectiveRepo detectiveRepo){
        this.detectiveRepo = detectiveRepo;
    }

    @Transactional
    @Override
    public Set<Detective> findAll() {
        return detectiveRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Detective> findById(Long id) {
        return detectiveRepo.findById(id);
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        return detectiveRepo.findByBadgeNumber(badgeNumber);
    }

    @Transactional
    @Override
    public Detective save(Detective detective) {
        detectiveRepo.save(detective);
        return detective;
    }
}
