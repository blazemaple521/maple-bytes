package com.blazemaple.subject.domain.handler.subject;

import com.blazemaple.subject.common.enums.IsDeletedFlagEnum;
import com.blazemaple.subject.common.enums.SubjectInfoTypeEnum;
import com.blazemaple.subject.domain.convert.JudgeSubjectConvert;
import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;
import com.blazemaple.subject.infra.basic.entity.SubjectJudge;
import com.blazemaple.subject.infra.basic.service.SubjectInfoService;
import com.blazemaple.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/22 16:45
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectJudgeService.insert(subjectJudge);
    }

    @Override
    public SubjectOptionBO query(long subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(subjectId);
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBoList = JudgeSubjectConvert.INSTANCE.convertJudgeListToAnswerBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBoList);
        return subjectOptionBO;
    }
}
