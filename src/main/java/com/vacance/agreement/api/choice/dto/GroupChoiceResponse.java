package com.vacance.agreement.api.choice.dto;

import com.vacance.agreement.api.choice.model.Choice;
import com.vacance.agreement.api.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@AllArgsConstructor
public class GroupChoiceResponse {
    private static final int CHOICE_COUNT = 5;
    private List<MemberChoiceInfo> choiceResult;

    public static GroupChoiceResponse toDto(List<Member> memberList, List<Choice> choiceList) {
        List<MemberChoiceInfo> result = new ArrayList<>();
        memberList.sort(Comparator.comparing(Member::getId));

        for (int i = 0; i < memberList.size(); i++) {
            String nickname = memberList.get(i).getNickname();
            List<Boolean> choices = new ArrayList<>();
            for (int y = CHOICE_COUNT*i; y < CHOICE_COUNT*(i+1) && y < choiceList.size(); y++) {
                choices.add(choiceList.get(y).getChoice());
            }
            result.add(new MemberChoiceInfo(nickname, choices));
        }

        return new GroupChoiceResponse(result);
    }

    @Getter
    @AllArgsConstructor
    private static class MemberChoiceInfo {
        private String nickname;
        private List<Boolean> choices;
    }
}
