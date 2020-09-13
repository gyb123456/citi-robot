package com.example.demo.ctrl;

import com.example.demo.nlp.tools.CBTokenizer;
import com.example.demo.po.RobotPo;
import com.example.demo.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("robot")
public class RobotCtrl {
    @Autowired
    private ElasticService elasticService;


    @GetMapping("testNlp")
    public String testNlp(){
        String[] tokens = CBTokenizer.tokens("Would you please help to grant permission.");
        for (String s : tokens) {
            System.out.println(s);
        }
        return "okkkkkkk";
    }

    @GetMapping("/init")
    public void init(){
        elasticService.createIndex();

//        List<RobotPo> list = new ArrayList<>();
//        list.add(new RobotPo(1L,"question1","answer1","label-1"));
//        list.add(new RobotPo(2L,"question2","answer2","label-2"));
//        list.add(new RobotPo(3L,"question3","answer3","label-3"));
//        elasticService.saveAll(list);
    }

    @GetMapping("/testSave")
    public void testSave(Long id) {
        RobotPo robotPo = new RobotPo(id,"question"+id,"answer"+id,"label-"+id+", rain");
        elasticService.save(robotPo);
    }

    @GetMapping("/findById")
    public Optional<RobotPo> findById(Long id) {
        return elasticService.findById(id);
    }

    @GetMapping("/findByLabel")
    public Iterator<RobotPo> findByLabel(String label){
        return elasticService.findByLabel(label).iterator();
    }

    @GetMapping("/findByLabelContaining")
    public Iterator<RobotPo> findByLabelContaining(String label){
        return elasticService.findByLabelContaining(label).iterator();
    }

    @GetMapping("/findByQuestion")
    public Iterator<RobotPo> findByQuestion(String question){
        return elasticService.findByQuestion(question).iterator();
    }

    @GetMapping("/findAll")
    public Iterator<RobotPo> findAll(){
        return elasticService.findAll();
    }

}
