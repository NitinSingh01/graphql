package customer;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import graphql.ExecutionResult;

@RestController
public class CustomerRestController {
	@Autowired
	CustomerRepository userRepository;
	@Autowired
	GraphQLService graphQLService;
	@RequestMapping("/microbank/v1/customers/{Cust_ID}")
	public Customer viewProfile(@PathVariable int Cust_ID)
	{return userRepository.getMyDetails(Cust_ID);
		}
	@RequestMapping(method=RequestMethod.POST, value="/microbank/v1/customers")
	public String registerCustomer(@RequestBody Customer db) throws URISyntaxException, JsonMappingException, JsonProcessingException {
		System.out.println(db.getUID());
		int k = userRepository.createCustomer(db);
		if(k==1)
		 {return "You have been registered successfully. Login details are sent to registered email id "+db.getEmail();}
		else
		{
			return "Registration Failed. You UID is either not registered or invalid. Please Try Again.";
		}
		 
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/microbank/v1/customer/{Cust_ID}/delete/{Password}")
	public void deleteCustomer(@PathVariable int Cust_ID,@PathVariable String Password) throws URISyntaxException {
		userRepository.deleteCustomer(Cust_ID, Password);
	}
	@RequestMapping("/microbank/v1/customers")
	public List<Customer> AllCustomer()
	{return userRepository.detailsCustomer();
		}
	
	@RequestMapping("/graphql/customers")
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
	}
