package com.sl.jwt.service;

import com.sl.jwt.domain.Address;
import com.sl.jwt.domain.Major;
import com.sl.jwt.domain.Student;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class APIService  {
    @CacheEvict(value="twenty-second-cache", key = "'StudentInCache'+#studentId",
            condition = "#isCacheable == null || !#isCacheable", beforeInvocation = true)
    @Cacheable(value="twenty-second-cache", key = "'StudentInCache'+#studentId",
            condition = "#isCacheable != null && #isCacheable")
    public Optional<Student> fetchStudent(String studentId, boolean isCacheable) throws InterruptedException {
        Thread.sleep(4000);
        return Arrays
                .asList(new Student("19VC21", "John", "Wayne", "11",
                                new Address("12A", "Bay Avenue", "SanFrancisco", "CA", "91234"), Major.MATHS),
                        new Student("19VC22", "Mary", "Jane", "11",
                                new Address("10A", "Cross Avenue", "SanFrancisco", "CA", "91238"), Major.CHEMISTRY),
                        new Student("19VC23", "Peter", "Parker", "11",
                                new Address("1A", "First Avenue", "SanFrancisco", "CA", "91934"), Major.PHYSICS))
                .stream().filter(t -> t.getId().equalsIgnoreCase(studentId)).findFirst();
    }
}
