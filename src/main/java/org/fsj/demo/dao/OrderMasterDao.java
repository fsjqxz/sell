package org.fsj.demo.dao;

import org.fsj.demo.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wxy on 2018-2-5.
 */
public interface   OrderMasterDao extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(Pageable pageable, String buyerOpenid);

}
