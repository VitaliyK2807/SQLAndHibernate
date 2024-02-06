package ConnectFiles;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class RegistrySqlDataBase {
    private SessionFactory sessionFactory;
    public RegistrySqlDataBase(String resourceName) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
