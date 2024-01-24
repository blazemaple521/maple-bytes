package com.blazemaple.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.blazemaple.subject.application.convert.SubjectLabelDTOConvert;
import com.blazemaple.subject.application.dto.SubjectLabelDTO;
import com.blazemaple.subject.common.entity.Result;
import com.blazemaple.subject.domain.entity.SubjectLabelBO;
import com.blazemaple.subject.domain.service.SubjectLabelDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BlazeMaple
 * @description 题目标签Controller
 * @date 2024/1/21 15:34
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     *
     * @param subjectLabelDTO 标签信息
     * @return Result<Boolean>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("add subject label, subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()),
                "标签名称不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("add subject label error, error: {}", e.getMessage(), e);
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新标签
     *
     * @param subjectLabelDTO 标签信息
     * @return Result<Boolean>
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("update subject label, subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            Boolean update = subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(update);
        } catch (Exception e) {
            log.error("update subject label error, error: {}", e.getMessage(), e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     *
     * @param subjectLabelDTO 标签信息
     * @return Result<Boolean>
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("delete subject label, subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            Boolean delete = subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(delete);
        } catch (Exception e) {
            log.error("delete subject label error, error: {}", e.getMessage(), e);
            return Result.fail("删除标签失败");
        }
    }

    /**
     * 根据分类id查询分类下标签
     *
     * @param subjectLabelDTO 标签信息
     * @return Result<List < SubjectLabelDTO>>
     */
    @GetMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("query label by category id, subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            List<SubjectLabelDTO> subjectLabelDTOList = SubjectLabelDTOConvert.INSTANCE.convertBoListToLabelDtoList(
                subjectLabelBOList);
            return Result.ok(subjectLabelDTOList);
        } catch (Exception e) {
            log.error("query label by category id error, error: {}", e.getMessage(), e);
            return Result.fail("查询标签失败");
        }
    }
}
