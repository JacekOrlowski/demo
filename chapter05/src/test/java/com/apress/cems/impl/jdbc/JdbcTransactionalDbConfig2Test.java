package com.apress.cems.impl.jdbc;

import com.apress.cems.dao.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.apress.cems.util.DateProcessor.toDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("ID");
        String username = rs.getString("USERNAME");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");
        String password = rs.getString("PASSWORD");
        String hiringDate = rs.getString("HIRINGDATE");
        Person person = new Person();
        person.setId(id);
        person.setUsername(username);
        person.setFirstName(firstname);
        person.setLastName(lastname);
        person.setPassword(password);
        person.setHiringDate(toDate(hiringDate));
        return person;
    } }

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JdbcTransactionalDbConfig2.class})
public class JdbcTransactionalDbConfig2Test {
    private static final Logger logger = LoggerFactory.getLogger(JdbcTransactionalDbConfig2Test.class);
    private ApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Person> rowMapper = new PersonRowMapper();

    @Autowired
    void setCtx( ApplicationContext ctx ){
        this.ctx = ctx;
    }
    @Autowired
    void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void testApplicationContext(){
        for( String name : ctx.getBeanDefinitionNames()){
            logger.info("Bean :" + name);
        }
    }

    @Transactional
    @Test
    void testDaoLayer(){
        List<Person> people = jdbcTemplate.query("SELECT * FROM PERSON", rowMapper);
        assertEquals( 2, people.size());
        for(Person person : people){
            logger.info("First Name: {} Last Name: {}",person.getFirstName(), person.getLastName());
        }
    }

}
