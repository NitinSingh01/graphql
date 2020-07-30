package customer;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class CustomerDataFetcher implements DataFetcher<Customer>{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer get(DataFetchingEnvironment dataFetchingEnvironment) {

        int Cust_ID = dataFetchingEnvironment.getArgument("id");
        
        return customerRepository.getMyDetails(Cust_ID); 
    }
}