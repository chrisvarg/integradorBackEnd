package com.cvargas.dentalOffice.dentalOffice.dao;

import com.cvargas.dentalOffice.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.dentalOffice.models.Address;
import com.cvargas.dentalOffice.dentalOffice.models.Dentist;
import com.cvargas.dentalOffice.dentalOffice.utils.H2DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AddressDaoH2 implements IDaoCrud<Address> {

    private static final Logger logger = Logger.getLogger(String.valueOf(DentistDaoH2.class));

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public Address create(Address address) {

        try {
            connection = H2DBConnection.getConnection();
            logger.info("Creando Address...");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO address(street, number, location, province) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setInt(2, address.getNumber());
            preparedStatement.setString(3, address.getLocation());
            preparedStatement.setString(4, address.getProvince());

            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            while (keys.next()) {
                address.setId(keys.getInt(1));
            }

            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        return address;
    }

    @Override
    public List<Address> readAll() {
        List<Address> addressList = new ArrayList<>();
        try {
            connection = H2DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Address");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String street = resultSet.getString("street");
                int number = resultSet.getInt("number");
                String location = resultSet.getString("location");
                String province = resultSet.getString("province");

                addressList.add(new Address(id, street, number, location, province));
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //TODO: preguntarle al profe que es mejor usar connection.close o preparedStatement.close();
//                if (connection != null &&)
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return addressList;
    }

    @Override
    public Address read(int id) {

        Address address = null;

        try {

            connection =H2DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                address = new Address(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5));
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return address;
    }

    @Override
    public Address update(Address address) {


        try {
            connection = H2DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE address SET street=?, number=?, location=?, province=? WHERE id=?"
            );
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setInt(2, address.getNumber());
            preparedStatement.setString(3, address.getLocation());
            preparedStatement.setString(4, address.getProvince());
            preparedStatement.setInt(5, address.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return address;
    }

    @Override
    public Address delete(int id) {

        Address address = null;

        try {
            address = this.read(id);
            connection = H2DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM address WHERE id=?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return address;
    }
}
