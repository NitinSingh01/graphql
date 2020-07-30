package customer;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;





@Service
@Repository
public class CustomerRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Customer getMyDetails(int Cust_ID) {
		return jdbcTemplate.queryForObject("select * from Customer where Cust_ID=?;", new Object[]{Cust_ID}, new CustomerRowMapper());
	}
	
	
	public int createCustomer(Customer cust) throws URISyntaxException, JsonMappingException, JsonProcessingException
	{	
		
		
		String a=alphaNumericString();
		cust.setPassword(a);
		jdbcTemplate.execute("INSERT INTO Customer(First_Name,Last_Name,Email,UID,Password,Address,City,State,zipcode) values(\""+cust.getFirst_Name()+"\",\""+
		cust.getLast_Name()+"\",\""+cust.getEmail()+"\",\""+cust.getUID()+"\",\""+cust.getPassword()+"\",\""+cust.getAddress()+"\",\""+cust.getCity()+"\",\""+cust.getState()+"\","+cust.getZipcode()+");");
		return 1;
		
	
					}
public void deleteCustomer(int Cust_ID, String Password) throws URISyntaxException
{	jdbcTemplate.execute("DELETE From Customer where Cust_ID="+Cust_ID+" and Password=\""+Password+"\";");
	
	}

public String alphaNumericString() {
    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    Random rnd = new Random();

    StringBuilder sb = new StringBuilder(10);
    for (int i = 0; i < 10; i++) {
        sb.append(AB.charAt(rnd.nextInt(AB.length())));
    }
    return sb.toString();
}


public List<Customer> detailsCustomer() {
	return jdbcTemplate.query("select * from Customer;",new RowMapper<Customer>(){
	      public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
	
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
	
	        return p;}}
);
	 
}			
}
