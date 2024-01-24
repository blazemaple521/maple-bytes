package com.blazemaple.subject.application.convert;

import com.blazemaple.subject.application.dto.SubjectAnswerDTO;
import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T14:49:41+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class SubjectAnswerDTOConvertImpl implements SubjectAnswerDTOConvert {

    @Override
    public List<SubjectAnswerDTO> convertBoListToAnswerDtoList(List<SubjectAnswerBO> subjectAnswerBOList) {
        if ( subjectAnswerBOList == null ) {
            return null;
        }

        List<SubjectAnswerDTO> list = new ArrayList<SubjectAnswerDTO>( subjectAnswerBOList.size() );
        for ( SubjectAnswerBO subjectAnswerBO : subjectAnswerBOList ) {
            list.add( subjectAnswerBOToSubjectAnswerDTO( subjectAnswerBO ) );
        }

        return list;
    }

    @Override
    public List<SubjectAnswerBO> convertDtoListToAnswerBoList(List<SubjectAnswerDTO> subjectAnswerDTOList) {
        if ( subjectAnswerDTOList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectAnswerDTOList.size() );
        for ( SubjectAnswerDTO subjectAnswerDTO : subjectAnswerDTOList ) {
            list.add( convertDtoToAnswerBo( subjectAnswerDTO ) );
        }

        return list;
    }

    @Override
    public SubjectAnswerBO convertDtoToAnswerBo(SubjectAnswerDTO subjectAnswerDTO) {
        if ( subjectAnswerDTO == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setOptionType( subjectAnswerDTO.getOptionType() );
        subjectAnswerBO.setOptionContent( subjectAnswerDTO.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectAnswerDTO.getIsCorrect() );

        return subjectAnswerBO;
    }

    protected SubjectAnswerDTO subjectAnswerBOToSubjectAnswerDTO(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectAnswerDTO subjectAnswerDTO = new SubjectAnswerDTO();

        subjectAnswerDTO.setOptionType( subjectAnswerBO.getOptionType() );
        subjectAnswerDTO.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectAnswerDTO.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectAnswerDTO;
    }
}
