package com.capgemini.ccsw.ccswmanager.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.ccswmanager.batch.personal.PersonalService;

@SpringBootApplication
public class CCSwmanagerBatchApplication implements CommandLineRunner {

   @Autowired
   PersonalService ldapService;

   public static void main(String[] args) {

      SpringApplication.run(CCSwmanagerBatchApplication.class, args);
   }

   @Override
   @Transactional(readOnly = false)
   public void run(String... args) throws Exception {

      this.ldapService.copyFromPersonalDB();
   }

}
