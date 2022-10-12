package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.HelpRequest;
import com.hadicha.zeonshop.dto.HelpResponse;
import com.hadicha.zeonshop.entity.Help;
import org.springframework.stereotype.Component;

@Component
public class HelpMapper extends AbstractMapper<Help, HelpResponse> {

    public HelpMapper() {
        super(Help.class,HelpResponse.class);
    }
    public Help save(HelpRequest helpRequest){
        Help help=new Help();
        help.setAnswer(helpRequest.getAnswer());
        help.setQuestions(helpRequest.getQuestions());
        return help;
    }
}
