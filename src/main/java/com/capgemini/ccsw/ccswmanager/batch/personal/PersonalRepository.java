package com.capgemini.ccsw.ccswmanager.batch.personal;

/**
 * @author pajimene
 *
 */
public interface PersonalRepository {

   /**
   * Borra las personas de la tabla temporal
   */
   void deleteAllTemporary();

   /**
   * Guarda el listado de personas la tabla temporal
   */
   void persistAllTemporary();

   /**
    * Actualiza las fechas de carga de PON y de PERSONAL
    */
   void updateLoadDate();

}
