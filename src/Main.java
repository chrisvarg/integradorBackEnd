import com.cvargas.dentalOffice.dao.DentistDaoH2;
import com.cvargas.dentalOffice.models.Dentist;
import com.cvargas.dentalOffice.service.DentistService;
import com.cvargas.dentalOffice.utils.H2DBConnection;
import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        Connection conn = null;
        System.out.println(H2DBConnection.createH2DB());

        Dentist dentist = new Dentist("Santiago", "Marquez", "1234567843");
        DentistDaoH2 dentistDaoH2 = new DentistDaoH2();

        dentistDaoH2.create(dentist);

        DentistService service = new DentistService(dentistDaoH2);


        List<Dentist> dentistList = service.readAll();

        dentistList.forEach(System.out::println);

        System.out.println(service.read(3));

        Dentist dentist2 = new Dentist(1, "Marcos", "Triana", "1234567843");

        service.update(dentist2);

        /*Class.forName("org.h2.Driver");

        try {

            conn = DriverManager.getConnection(H2DBConnection.DB_URL, H2DBConnection.USER, H2DBConnection.PASSWORD );
            Statement statement = conn.createStatement();
            statement.execute("DROP SCHEMA HOLA");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
           conn.close();
        }*/

//        H2DBConnection.createH2DB();
//        try {
//
//        }catch (Exception  e) {
//            H2DBConnection.logger.error("Error al conectar la db");
//        }
//        finally {
//            try {
//                conn.close();
//                H2DBConnection.logger.info("Cerrando la db...");
//            } catch (Exception ne) {
//                H2DBConnection.logger.error("Error al cerrar la db", ne);
//            }
//        }
    }
}