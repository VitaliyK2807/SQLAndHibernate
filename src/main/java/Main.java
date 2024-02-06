import ConnectFiles.RegistrySqlDataBase;
import MyDataBase.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final String RESOURCE_NAME = "hibernate.cfg.xml";
    private static final String URL = "jdbc:mysql://localhost:3306/skillbox";
    private static final String USER = "root";
    private static final String PASS = "12345Qwer4321";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:" + "\n" +
                    "1. Выполнить практическую работу 16.12" + "\n" +
                    "2. Выполнить практическую работу 16.13" + "\n" +
                    "0. Выход");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
           switch (input) {
               case "1" -> practicVariant1612();
               case "2" -> creatingTables();
               };

        }

    }
    private static void practicVariant1612 () {
        ConnectFiles.ConnectVariantOne conn = new ConnectFiles.ConnectVariantOne(URL, USER, PASS);
        System.out.println(conn.toString());
    }

    private static void creatingTables () {
        List<PurchaseList> listPurchase;

        RegistrySqlDataBase registrySqlDataBase = new RegistrySqlDataBase(RESOURCE_NAME);
        Session session = registrySqlDataBase.getSessionFactory().openSession();

        listPurchase = getPurchaseList(session);
        setLinkedPurchaseList(session, getIdCourse(session, listPurchase),
                getIdStudent(session, listPurchase), getDataPurchase(listPurchase));

        session.close();
        registrySqlDataBase.getSessionFactory().close();
    }

    private static void setLinkedPurchaseList (Session session, List<Integer> idCourse,
                                               List<Integer> idStudent, List<Date> date) {
        if (idCourse.size() == idStudent.size() && idCourse.size() == date.size()) {
            for (int i = 0; i < idCourse.size(); i++) {
                Transaction transaction = session.beginTransaction();
                LinkedPurchaseList purchaseList = new LinkedPurchaseList();
                purchaseList.setId(new LinkedPurchaseListKey(idCourse.get(i), idStudent.get(i)));
                purchaseList.setSubscriptionDate(date.get(i));
                session.save(purchaseList);
                transaction.commit();
            }
        }

    }

    private static List<Date> getDataPurchase (List<PurchaseList> listPurchase) {
        List<Date> date = new ArrayList<>();
        listPurchase.forEach(line -> date.add(line.getSubscriptionDate()));
        return date;
    }
    private static List<Integer> getIdStudent (Session session, List<PurchaseList> list) {
        List<Integer> listId = new ArrayList<>();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> getList = query.from(Student.class);
        query.select(getList);
        List<Student> listStudent = session.createQuery(query).getResultList();
        for (PurchaseList purchaseList: list) {
            listStudent.forEach(line -> {
                if (line.getName().equals(purchaseList.getStudentName())) {
                    listId.add(line.getId());
                }
            });
        }
        return listId;
    }
    private static List<Integer> getIdCourse (Session session, List<PurchaseList> list) {
        List<Integer> listId = new ArrayList<>();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> getList = query.from(Course.class);
        query.select(getList);
        List<Course> listCourse = session.createQuery(query).getResultList();
        for (PurchaseList purchaseList: list) {
            listCourse.forEach(line -> {
                if (line.getName().equals(purchaseList.getCourseName())) {
                    listId.add(line.getId());
                }
            });
        }
        return listId;
    }
    private static List<PurchaseList> getPurchaseList (Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> getList = query.from(PurchaseList.class);
        query.select(getList);
        List<PurchaseList> list = session.createQuery(query).getResultList();
        return list;
    }

}



