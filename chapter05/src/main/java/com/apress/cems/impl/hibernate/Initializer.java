/*
Freeware License, some rights reserved

Copyright (c) 2019 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.cems.impl.hibernate;

import com.apress.cems.dao.Detective;
import com.apress.cems.dao.Person;
import com.apress.cems.dao.TrackEntry;
import com.apress.cems.impl.hibernate.services.DetectiveService;
import com.apress.cems.impl.hibernate.services.PersonService;
import com.apress.cems.impl.hibernate.services.TrackEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
@Service
@Transactional
public class Initializer {

    private Logger logger = LoggerFactory.getLogger(Initializer.class);
    private PersonService personService;
    private DetectiveService detectiveService;
    private TrackEntryService trackEntryService;

    @Autowired
    public Initializer(PersonService personService, DetectiveService detectiveService, TrackEntryService trackEntryService) {
        this.personService = personService;
        this.detectiveService = detectiveService;
        this.trackEntryService = trackEntryService;
    }

    @PostConstruct
    public void init() {
        logger.info(" -->> Starting database initialization...");

        /* persons */
        Person person1 = new Person();
        person1.setUsername("sherlock.holmes");
        person1.setFirstName("Sherlock");
        person1.setLastName("Holmes");
        person1.setPassword("dudu");
        person1.setHiringDate(LocalDateTime.now());
        personService.save(person1);

        Person person2 = new Person();
        person2.setUsername("jackson.brodie");
        person2.setFirstName("Jackson");
        person2.setLastName("Brodie");
        person2.setPassword("bagy");
        person2.setHiringDate(LocalDateTime.now());
        personService.save(person2);

        /* detectives */
        Detective detective = new Detective();
        detective.setPerson(person1);
        detective.setBadgeNumber("1");
        detectiveService.save(detective);

        /* track entries */
        TrackEntry trackEntry1 = new TrackEntry();
        trackEntry1.setDate(LocalDateTime.now());
        trackEntry1.setDetective(detective);
        trackEntry1.setReason("track reason");
        trackEntryService.save(trackEntry1);

        TrackEntry trackEntry2 = new TrackEntry();
        trackEntry2.setDate(LocalDateTime.now());
        trackEntry2.setDetective(detective);
        trackEntry2.setReason("track reason");
        trackEntryService.save(trackEntry2);

        logger.info(" -->> Database initialization finished.");
    }
}
