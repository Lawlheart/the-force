package com.lawlietblack.theforce.repository;

import com.lawlietblack.theforce.model.Device;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.Arrays;
import java.util.List;

public class DeviceRepositoryImpl implements DeviceRepository {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    @Override
    public Device create(Device device) {
        // TODO:krb save to database
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(device);
        System.out.println("CREATING");
        System.out.println(device);
        session.getTransaction().commit();
        session.close();
        return device;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Device> findAllDevices() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Device.class);
        List<Device> devices = criteria.list();
        session.close();
        return devices;
    }

    @Override
    public Device findDeviceById(Integer id) {
        Session session = sessionFactory.openSession();
        Device device = session.get(Device.class, id);
        session.close();
        return device;
    }


    @Override
    public Device update(Device device) {
        // TODO:krb update database
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(device);
        session.getTransaction().commit();
        session.close();
        return device;
    }

    @Override
    public void delete(Integer id) {
        // TODO: delete from database
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(findDeviceById(id));
        } catch(Error e) {
            System.out.println(e);
        }
        session.getTransaction().commit();
        session.close();
    }
}
