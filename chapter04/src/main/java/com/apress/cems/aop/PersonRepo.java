package com.apress.cems.aop;

import java.util.Optional;

public interface PersonRepo<T> {
    Optional<T> findById(Long id);
}
