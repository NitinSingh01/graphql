package customer;



import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class AllCustomerDataFetcher implements DataFetcher<List<Customer>>{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return customerRepository.detailsCustomer();
    }
}

