package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SkillDAO;
import model.Skill;

public class Main{
	static List<Skill> listSkills= new ArrayList<Skill>(); 
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		System.out.println("List of all Skills");
		SkillDAO skillDao = new SkillDAO();
		listSkills=skillDao.listAllSkills();
		}
	}
