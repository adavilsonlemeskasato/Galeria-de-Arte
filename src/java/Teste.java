
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import Modelo.ObraDeArte;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author davi
 */
public class Teste {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("obras");
        EntityManager em = factory.createEntityManager();

        ObraDeArte obra = new ObraDeArte();
        obra.setAutor("Adir Sodré");
        obra.setTitulo("Caminho de São Francisco");
        obra.setProcedencia("Museu da Caia D'Agua");
        obra.setTipo("Quadro");
        obra.setDataObra(parseData("25/11/1988"));
        obra.setTecnica("Óleo sobre Tela");
        obra.setDimensoes("154cm x 154cm");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obra);
        tx.commit();
        em.close();
        factory.close();

    }

    private static Calendar parseData(String data) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;

        } catch (ParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

}
