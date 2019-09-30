package com.tensquare.spit.mapper;

import com.tensquare.spit.entity.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpitMapper extends MongoRepository<Spit,String> {

}
