package persistenceDemo.springBoot.service;

//import org.springframework.data.repository.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import persistenceDemo.springBoot.domain.Account;

public interface AccountRepository extends MongoRepository<Account, Long> {

    public Account findByUsername(String username);
}
