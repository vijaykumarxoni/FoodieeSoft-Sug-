/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.Questions;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.QuestionsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class QuestionsDAOImpl implements QuestionsDAO{
    @Override
    public int saveQuestions(Questions questions) {

        int i = 0;
        String query = "INSERT INTO questions(question, created_by, created_date) VALUES (?,?,?) ";
        try {
            
Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, questions.getQuestions());
            ps.setInt(2, questions.getCreated_by());
            ps.setString(3, questions.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving Questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Questions> getAllQuestions() {
        ArrayList<Questions> questions_list = new ArrayList<>();
        try {
            
Connection con = DBConnection.load();
            String query = "SELECT * FROM questions WHERE active=1 ORDER BY question_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int question_id = rs.getInt("question_id");
                String question = rs.getString("question");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                questions_list.add(new Questions(question_id, active, created_by, modified_by,
                        created_date, modification_date, question));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return questions_list;
    }

    @Override
    public int modifyQuestions(Questions questions) {
        int i = 0;
        String query = "UPDATE questions SET question = ? ,modified_by = ? , modification_date = ? WHERE question_id = ?";
        try {
Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, questions.getQuestions());
            ps.setInt(2, questions.getModified_by());
            ps.setString(3, questions.getModification_date());
            ps.setInt(4, questions.getQuestion_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeQuestions(Questions questions) {
        int i = 0;
        String query = "UPDATE questions SET active=0 WHERE `question_id` =? ";
        try {
Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, questions.getQuestion_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of questions");
            e.printStackTrace();
        }
        return i;
    }

     @Override
    public String getQuestion(int question_id) {
        String question = "";
        try {
Connection con = DBConnection.load();
            String query = "SELECT question FROM questions WHERE question_id=" + question_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                question = rs.getString("question");

            }
        } catch (Exception e) {
            System.out.println("Error in getting question ");
            e.printStackTrace();
        }

        return question;

    }

}
