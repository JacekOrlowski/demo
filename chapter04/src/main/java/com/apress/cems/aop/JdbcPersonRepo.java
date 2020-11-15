package com.apress.cems.aop;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcPersonRepo implements PersonRepo<String> {
    public Optional<String> findById( Long id){
        return Optional.of("Jacek Orłowski");
    }
}
