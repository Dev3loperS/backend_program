package cybersoft.java20.dev3lopers.gear3sproject.repository;

import cybersoft.java20.dev3lopers.gear3sproject.entity.Roles;
import cybersoft.java20.dev3lopers.gear3sproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    @Query(value = "select u.password from users as u where u.email = ?1",nativeQuery = false)
    String getPassByEmail(String email);

    /*@Query(value = "select u.id,u.email,u.password,u.fullname,u.birthday,u.phone,u.address,u.avatar,u.lastPayment," +
                    "s.name as sex,r.name as role from users u" +
                    " left join u.sex s left join u.roles r",nativeQuery = false)
    List<Users> getAllUser();*/

    List<Users> findAll();
    Users findById(int id);
    Users findByEmail(String email);
    Integer countByEmail(String email);

    Users findByPhone(String phone ) ;

    @Query(value = "select u from orders o inner join user_card uc on uc.id = o.user_card.id inner join users u on o.user_card.id = u.id where u.phone = ?1")
    List<Users> findUserByPhone (String  phone  );
}
