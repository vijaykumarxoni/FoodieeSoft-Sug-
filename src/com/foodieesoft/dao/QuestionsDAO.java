/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.Questions;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface QuestionsDAO {
    public int saveQuestions(Questions questions);
    public ArrayList<Questions> getAllQuestions();
    public int modifyQuestions(Questions questions);
    public int removeQuestions(Questions questions);
    public String getQuestion(int question_id);

}
