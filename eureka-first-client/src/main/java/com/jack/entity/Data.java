package com.jack.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;

/**
 * @author Jack
 */
@Getter
@Setter
@ToString
public class Data {

    private LinkedList<RadioAnswers> radioAnswers;

    private LinkedList<CheckBoxAnswers> checkBoxAnswers;
}
