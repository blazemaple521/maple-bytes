package com.blazemaple.subject.application.controller;

import com.blazemaple.subject.infra.basic.entity.SubjectCategory;
import com.blazemaple.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author BlazeMaple
 * @description 刷题Controller
 * @date 2024/1/18 17:35
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String getSubject() {
        return subjectCategoryService.queryById(1L).getCategoryName();
    }

}
