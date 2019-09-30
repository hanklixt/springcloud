package com.tensquare.spit.service;

import com.tensquare.spit.entity.Spit;
import com.tensquare.spit.mapper.SpitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpitService {

    @Autowired
    private SpitMapper spitMapper;
    @Autowired
    private IdWorker idWorker;

    public List<Spit> findAll(){
        return spitMapper.findAll();
    }
    public Optional<Spit> findById(String id){
        return spitMapper.findById(id);
    }

    public void  save(Spit spit){
        spit.set_id(idWorker.nextId()+"");
        spitMapper.save(spit);
    }
    public  void update(Spit spit){
        spitMapper.save(spit);
    }
    public void removeById(String id){
        spitMapper.deleteById(id);
    }
}
