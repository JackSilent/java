package com.jack.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Map;

@Getter
@Setter
public class CheckBoxAnswers {

    private Map<String, LinkedList<String>> checkBoxAnswers;
}
