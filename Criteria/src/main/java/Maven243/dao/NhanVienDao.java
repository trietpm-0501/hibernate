package Maven243.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import Maven243.NhanVien;
import Maven243.util.HibernateUtil;

public class NhanVienDao {
    public List<NhanVien> getAllNhanVien() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<NhanVien> nhanVienList = null;

        try {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<NhanVien> criteria = builder.createQuery(NhanVien.class);
            Root<NhanVien> root = criteria.from(NhanVien.class);
            criteria.select(root);

            nhanVienList = session.createQuery(criteria).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nhanVienList;
    }
}
