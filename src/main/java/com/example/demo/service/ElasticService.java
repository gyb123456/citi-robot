package com.example.demo.service;

import com.example.demo.dao.ElasticRepository;
import com.example.demo.po.RobotPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ElasticService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private static Pageable pageable = PageRequest.of(0,10);

    public void createIndex() {
        elasticsearchTemplate.createIndex(RobotPo.class);
    }

    public void save(RobotPo robotPo) {
        elasticRepository.save(robotPo);
    }

    public Optional<RobotPo> findById(Long id) {
        return elasticRepository.findById(id);
    }

    public Page<RobotPo> findByLabel(String label){
        return elasticRepository.findByLabel(label, pageable);
    }

    public Page<RobotPo> findByLabelContaining(String label){
        return elasticRepository.findByLabelContaining(label,pageable);
    }

    public Page<RobotPo> findByQuestion(String question){
        return elasticRepository.findByQuestion(question, pageable);
    }

    public void saveAll(List<RobotPo> list) {
        elasticRepository.saveAll(list);
    }

    public Iterator<RobotPo> findAll() {
        return elasticRepository.findAll().iterator();
    }
}
