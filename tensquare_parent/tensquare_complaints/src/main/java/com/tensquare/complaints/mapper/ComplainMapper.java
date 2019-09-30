package com.tensquare.complaints.mapper;

import com.tensquare.complaints.entity.Complain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainMapper extends MongoRepository<Complain,String> {
    /**
     * 根据父级id查询列表
     * @param parentId
     * @param pageable
     * @return
     */
   Page<Complain> findByParentid(String parentId, Pageable pageable);
}
