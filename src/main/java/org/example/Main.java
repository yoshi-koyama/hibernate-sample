package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println("START");
        try {
            Transaction transaction = session.beginTransaction();

            List<PlayerScore> scores = session.createNativeQuery("SELECT id, player_name, score, difficulty, registered_at FROM player_score", PlayerScore.class).getResultList();
            for (PlayerScore score : scores) {
                System.out.printf("id: %d, player_name: %s, score: %d, difficulty: %s, registered_at: %s\n", score.getId(), score.getPlayerName(), score.getScore(), score.getDifficulty(), score.getRegisteredAt());
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("END");
    }
}