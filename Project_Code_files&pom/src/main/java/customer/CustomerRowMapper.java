package customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer p = new Customer();
    	p.setCust_ID(rs.getInt("Cust_ID"));
        p.setFirst_Name(rs.getString("First_Name"));
        p.setLast_Name(rs.getString("Last_Name"));
        p.setEmail(rs.getString("email"));
        p.setUID(rs.getString("UID"));
        p.setPassword(rs.getString("Password"));
        p.setAddress(rs.getString("Address"));
        p.setState(rs.getString("State"));
        p.setZipcode(rs.getInt("Zipcode"));
        p.setCity(rs.getString("City"));

        return p;


}
}
