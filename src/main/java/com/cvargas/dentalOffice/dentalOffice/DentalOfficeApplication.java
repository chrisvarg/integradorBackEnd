package com.cvargas.dentalOffice.dentalOffice;

import com.cvargas.dentalOffice.dentalOffice.utils.H2DBConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DentalOfficeApplication {


	public static void main(String[] args) throws SQLException {
//		H2DBConnection.createH2DB();
		SpringApplication.run(DentalOfficeApplication.class, args);
	}

}
