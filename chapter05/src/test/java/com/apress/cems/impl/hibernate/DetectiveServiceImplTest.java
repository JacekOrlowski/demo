package com.apress.cems.impl.hibernate;

import com.apress.cems.dao.Detective;
import com.apress.cems.dao.Person;
import com.apress.cems.dao.TrackEntry;
import com.apress.cems.impl.hibernate.services.DetectiveService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HibernateDbConfig.class, AppConfig.class})
public class DetectiveServiceImplTest {

    @Autowired
    DetectiveService detectiveService;

    @Test
    void testDetective(){
        Optional<Detective> det = detectiveService.findByBadgeNumber("1");
        assertEquals(false, det.isEmpty());
        Detective detective = det.get();
        Person person = detective.getPerson();
        assertNotNull(person);
        Set<TrackEntry> trackEntries = detective.getTrackEntries();
        assertNotNull(trackEntries);
        assertEquals(2, trackEntries.size());
    }
}
