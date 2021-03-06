package KHMJ.DataLayer;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class MemberDL extends BaseDL {

	public List<Member> GetMembers() {
		List<Member> allMembers = null;

		try {
			Statement sqlStatement = GetSqlStatement();
			ResultSet memebersSet = sqlStatement
					.executeQuery("SELECT * FROM Member");
			
			allMembers = extractFromResultSet(memebersSet);

			memebersSet.close();
			sqlStatement.close();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
		return allMembers;
	}

	private List<Member> extractFromResultSet(ResultSet memberSet) {
		List<Member> liMember = new ArrayList<Member>();
		try {
			while (memberSet.next()) {
				Member khmjMember = new Member();
				khmjMember.Member_Id = memberSet.getInt("Member_Id");
				khmjMember.Member_First_Name = memberSet.getString("Member_First_Name");
				khmjMember.Member_Last_Name = memberSet.getString("Member_Last_Name");
				khmjMember.Member_Qualification = memberSet.getInt("Member_Qualification");
				khmjMember.Member_DOB = memberSet.getTimestamp("Member_DOB");
				khmjMember.Income_Level_Category = memberSet.getInt("Member_Income_Category");
				
				liMember.add(khmjMember);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return liMember;
	}

}
