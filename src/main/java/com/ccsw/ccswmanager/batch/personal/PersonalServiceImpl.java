package com.ccsw.ccswmanager.batch.personal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pajimene
 *
 */
@Service
@Transactional(readOnly = true)
public class PersonalServiceImpl implements PersonalService {

   private static final Logger LOG = LoggerFactory.getLogger(PersonalServiceImpl.class);

   @Autowired
   private PersonalRepository personal;

   /**
   * {@inheritDoc}
   */
   @Override
   @Transactional(readOnly = false)
   public void copyFromPersonalDB() {

      LOG.info("********** CARGA DATOS PERSONAL *************");
      LOG.info("Borramos tablas temporales");
      this.personal.deleteAllTemporary();

      LOG.info("Insertamos tablas temporales");
      this.personal.persistAllTemporary();

      LOG.info("Actualizamos fechas de carga");
      this.personal.updateLoadDate();

      LOG.info("********** CARGA DATOS PERSONAL *************");

   }

}
