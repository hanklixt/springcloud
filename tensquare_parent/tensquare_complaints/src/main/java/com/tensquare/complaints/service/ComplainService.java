package com.tensquare.complaints.service;

import com.tensquare.complaints.entity.Complain;
import com.tensquare.complaints.mapper.ComplainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import util.IdWorker;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainService {

    @Autowired
    private ComplainMapper spitMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Complain> findAll(){
        return spitMapper.findAll();
    }
    public Optional<Complain> findById(String id){
        return spitMapper.findById(id);
    }

    public void  save(Complain spit){
        spit.set_id(idWorker.nextId()+"");
        spit.setComment(0);
        spit.setThumbup(0);
        spit.setShare(0);
        spit.setVisits(0);
        spit.setState("1");
        spit.setPublishtime(LocalDate.now());
        //如果存在父吐槽节点,父节点评论加一
        if (!StringUtils.isEmpty(spit.getParentid())){
            Query query=new Query();
            query.addCriteria(Criteria.where("id").is(spit.getParentid()));
            Update update=new Update();
            update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"complain");
        }
        spitMapper.save(spit);
    }
    public  void update(Complain spit){
        spitMapper.save(spit);
    }
    public void removeById(String id){
        spitMapper.deleteById(id);
    }

    public Page<Complain> findByParentId(String parentId,Integer pageNo,Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo = 1, pageSize);
        Page<Complain> byParentid = spitMapper.findByParentid(parentId, pageable);
        return byParentid;
    }

    /**
     * 点赞加一 //普通方式
     * @param id
     */
    public  void updateThump(String id){
        Optional<Complain> byId = spitMapper.findById(id);
        Complain complain = byId.get();
        complain.setThumbup(complain.getThumbup()+1);
        spitMapper.save(complain);
    }

    public  void updateThumpBetter(String id){
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update();
        //字段值加一
        update.inc("thumbup",1);
      mongoTemplate.updateFirst(query,update,"complain");
    }


}
