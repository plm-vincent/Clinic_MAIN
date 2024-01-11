package MainAPP;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static Connection Connect() {
        Connection con = null;
        try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); //Driver name
        con = DriverManager.getConnection ("jdbc:derby://localhost:1527/CLINIC_FinalProject", "clinicadmin", "clinicadmin");
        System.out.println("Connection Established Successfully");
        }
        
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
