package com.example.productCRM.repository;

import com.example.productCRM.model.dto.CustomerAgeDTO;
import com.example.productCRM.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//repository ler interface olmak zorunda
@Repository //context e dahil ediyor.
//hazır olan metotları kullanabilmek için CrudRepository yi extend aldık
public interface CustomerRepository
        extends JpaRepository<Customer,Long> {
    List<Customer> findByName(String name);

    //select * from customer where name='Can' or surname="Demir"
    List<Customer> findByNameOrSurname(String name,String surname);

    //aynı isim varsa sadece birisini döndürün
    List<Customer> findDistinctByName(String name);

    // age 40 dan büyük olan müşterileri döndürün
    List<Customer> findByAgeGreaterThan(Integer age);

    // yaşı 40 dan eşit küçük ve ismi can(ignorecase) olan kayıtları bulun.
    List<Customer> findByAgeLessThanEqualAndNameIgnoreCase(Integer age,String name);

    // tüm müşterileri dönün fakat isme göre alfabetik olsun. Küçük büyüğe doğru
    List<Customer> findAllByAgeGreaterThanOrderByName(Integer age);

    // yaşı 30 ile 50 arasında olan müşteleri veya isminde bur geçenleri getirin.
    List<Customer> findByAgeBetweenAndNameContainingIgnoreCase(Integer startAge,
                                                              Integer endAge,String name);
    @Query(value = "Select c.name from Customer c order by c.name")
    List<Customer> customFindAll();

    List<Customer> findAllByOrderByNameDesc();

    @Query(value = "Select c from Customer c" +
            " where c.name=:name or c.surname=:surname order by c.name") //hql yazdık
    List<Customer> customByNameOrSurname
            (@Param("name") String name,@Param("surname") String surname);

    List<Customer> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase
            (String name, String surname);

    List<Customer> findByAgeBetween(Integer start_age, Integer end_age);

    List<Customer> findByNameContainingIgnoreCaseOrderByNameDesc(String name);

    Long countCustomer();

    // age count
    @Query(name = "Customer.groupByAge", nativeQuery = true)
    List<CustomerAgeDTO> findGroupByAge();

    @Query("select count(c) from Customer c")
    Long findCountWithHql();

    @Query(value = "select count(*) from Customer",nativeQuery = true)
    Long findCountWithoutHql();

    @Query("select c.age,count(c) from Customer c group by c.age")
    List<Object> groupByAgeWithHql();
    @Query(value = "select c.birth_date,count(c) from Customer c group by c.birth_date"
            ,nativeQuery = true)
    List<Object> groupByAgeWithoutHql();

    @Query(value = "select c.birth_date,count(c) from " +
            "(select * from Customer c1 " +
            " where  lower(c1.name) like lower(:name))" +
            " c group by c.birth_date",nativeQuery = true)
    List<Object> groupByAgeFilterByNameWithoutHql
            (@Param("name") String name);
}
