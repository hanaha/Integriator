package net.integriator.data;

import net.integriator.data.entity.CustomEntity;
import net.integriator.hibernateTest.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class SessionManager {
    private SessionFactory sessionFactory;

    private static SessionManager instance = new SessionManager();

    public SessionManager() {
        instance = this;
        this.setUp();
    }

    private Session currentSession = null;

    public static <E extends CustomEntity> void saveEntity(E entity) {
        Session session = startSession();
        session.save(entity);
        SessionManager.stopSession();
    }

    public static Session startSession() {
        if (instance.currentSession != null) {
            instance.currentSession.close();
            instance.currentSession = null;
        }

        instance.currentSession = instance.sessionFactory.openSession();

        instance.currentSession.beginTransaction();

        return instance.currentSession;
    }

    public static void stopSession() {
        instance.currentSession.getTransaction().commit();
        instance.currentSession.close();
    }

    public void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void tearDown() throws Exception {
        instance.sessionFactory.close();
//        if (sessionFactory != null) {
//            sessionFactory.close();
//        }
    }

    @SuppressWarnings({"unchecked"})
    public void testBasicUsage() {
        // Create a couple of events...
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Event("Our very first event!", new Date()));
        session.save(new Event("A follow up event", new Date()));
        session.getTransaction().commit();
        session.close();

        // Now let's pull events from the database and list them.
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        for (Event event : (List<Event>) result) {
            System.out.println("Event (" + event.getDate() + ") : " + event.getTitle());
        }
        session.getTransaction().commit();
        session.close();

        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
