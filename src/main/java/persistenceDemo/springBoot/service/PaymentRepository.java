package persistenceDemo.springBoot.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import persistenceDemo.Entity.City;
import persistenceDemo.Entity.Payment;

import java.util.List;

/**
 * Created by Student on 23.06.2016.
 */
@RepositoryRestResource(collectionResourceRel = "Payments", path = "payments")
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>
{
    public Payment findByPaymentId(@Param("id2") String id3);
    public List<Payment> findAll();

}
