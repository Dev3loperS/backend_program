package cybersoft.java20.dev3lopers.gear3sproject.repository;

import cybersoft.java20.dev3lopers.gear3sproject.dto.SumTotalOrdersGroupByMonthDTO;
import cybersoft.java20.dev3lopers.gear3sproject.dto.SumTotalOrdersGroupByYearDTO;
import cybersoft.java20.dev3lopers.gear3sproject.entity.Orders;
import cybersoft.java20.dev3lopers.gear3sproject.dto.CountOrdersGroupByMonthDTO;
import cybersoft.java20.dev3lopers.gear3sproject.dto.CountOrdersGroupByYearDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    Orders findById(int id );
    List<Orders >findAll( );

    void deleteById(int id );



    @Query(value = "select new cybersoft.java20.dev3lopers.gear3sproject.dto.CountOrdersGroupByYearDTO (YEAR(o.orderDate)  , COUNT(*))  from orders o GROUP BY YEAR(o.orderDate)")
    List<CountOrdersGroupByYearDTO> countOrdersGroupByYear ();

    @Query(value = "select new cybersoft.java20.dev3lopers.gear3sproject.dto.CountOrdersGroupByMonthDTO (MONTH (o.orderDate)  , COUNT(*))  from orders o GROUP BY MONTH(o.orderDate)")
    List<CountOrdersGroupByMonthDTO> countOrdersGroupByMonth ();

    @Query(value = "select new cybersoft.java20.dev3lopers.gear3sproject.dto.SumTotalOrdersGroupByYearDTO (YEAR(o.orderDate)  , SUM(o.total))  from orders o GROUP BY YEAR(o.orderDate)")
    List<SumTotalOrdersGroupByYearDTO> sumOrdersGroupByYear ();

    @Query(value = "select new cybersoft.java20.dev3lopers.gear3sproject.dto.SumTotalOrdersGroupByMonthDTO (MONTH (o.orderDate)  , SUM(o.total))   from orders o GROUP BY MONTH(o.orderDate)")
    List<SumTotalOrdersGroupByMonthDTO> sumOrdersGroupByMonth ();
}
