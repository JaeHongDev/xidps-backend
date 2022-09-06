import domain.Member;
import domain.Team;

import javax.persistence.*;

public class JpaApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager        em  = emf.createEntityManager();
        EntityTransaction    tx  = em.getTransaction();
        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

    }

    private static void logic(EntityManager em) {
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("member1","회원");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);


    }
}
