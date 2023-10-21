package com.example.tpintegrador3.Factory;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityFactory {

        private final EntityManagerFactory emf;

        private EntityFactory() {

            emf = Persistence.createEntityManagerFactory("integrador3");

        }

        private static class SingletonHelper {
            private static final EntityFactory INSTANCE = new EntityFactory();
        }

        public static EntityFactory getInstance() {

            return SingletonHelper.INSTANCE;
        }

        public EntityManager createEntityManager() {

            return emf.createEntityManager();
        }

}