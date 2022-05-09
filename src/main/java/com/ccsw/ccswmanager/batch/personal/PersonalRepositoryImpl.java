package com.ccsw.ccswmanager.batch.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author pajimene
 *
 */
@Repository
public class PersonalRepositoryImpl implements PersonalRepository {

   @Autowired
   private JdbcTemplate jdbcTemplate;

   /**
   * {@inheritDoc}
   */
   @Override
   public void deleteAllTemporary() {

      this.jdbcTemplate.update("delete from t_person");
      this.jdbcTemplate.update("delete from t_group");
      this.jdbcTemplate.update("delete from t_members");
   }

   /**
   * {@inheritDoc}
   */
   @Override
   public void persistAllTemporary() {

      this.jdbcTemplate.update("insert into t_person select * from personal.t_person");
      this.jdbcTemplate.update("insert into t_group select * from personal.t_group");
      this.jdbcTemplate.update("insert into t_members select * from personal.t_members");

   }

   @Override
   public void updateLoadDate() {

      this.jdbcTemplate
            .update("update properties set value = (select value from personal.properties where code = 'LOAD_LDAP_PON') where code = 'LOAD_LDAP_PON'");
      this.jdbcTemplate.update("update properties set value = now() where code = 'LOAD_PERSONAL'");

   }

}
