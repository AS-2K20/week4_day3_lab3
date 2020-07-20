package  dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	
	public List <Skill> listAllSkills () throws ClassNotFoundException, IOException, SQLException
	{
		List<Skill> listSkills= new ArrayList<Skill>(); 
		Long Id = null;
		String Name = null;
		Skill skill = new Skill(Id,Name);
		try {
		
		Connection con = ConnectionManager.getConnection();
		String selectSql = "SELECT SKILLID,SKILLNAME FROM SKILL";
		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(selectSql);
		while(resultSet.next()) {
			Long skillId = resultSet.getLong("skillId");
			String skillName= resultSet.getString("skillName");
			System.out.println(skillId+". "+skillName);
			skill.setSkillId(skillId);
			skill.setSkillName(skillName);
			listSkills.add(skill);
		}
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listSkills;
	
	}
}
