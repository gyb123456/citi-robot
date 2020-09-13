package com.example.demo.dao;

import com.example.demo.po.RobotPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository extends ElasticsearchRepository<RobotPo, Long> {

//    @Query("{\"bool\" : {\"must\" : {\"RobotPo\" : {\"label.keyword\" : \"?\"}}}}")
//    @Query("{\"bool\" : {\"must\" : [ {\"field\" : {\"label\" : \"label-1\"}}]}}\"")

    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"label\" : \"?0\"}}}}")
//    @Query("select po from RobotPo where label=?")
    Page<RobotPo> findByLabel(String label, Pageable pageable);

    Page<RobotPo> findByQuestion(String question, Pageable pageable);

    Page<RobotPo> findByLabelContaining(String label, Pageable pageable);


}
