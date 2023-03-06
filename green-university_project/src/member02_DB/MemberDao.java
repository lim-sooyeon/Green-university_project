package member02_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/** DB 호출하거나, MemberDTO 반환하는 메소드들은 MemberDao로 관리. **/
public class MemberDao {
	
	private static Connection conn;
	private static String sql;
	private static Statement st;
	private static ResultSet rs;
	
	/* DB 연결 */
	public static void getConnection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/cje", "root", "admin");
			st = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* 회원가입 */
	public static void joinMember(MemberDTO member)
	{
		try {
			sql = "insert into memBasic values('" + member.getMemberId() + "', '" + member.getPassword() + "', '" + member.getMailAddress() + "', '" +
				member.getMemberName() + "', '" + member.getBirthDate() + "', '" + member.getPhoneNum() + "', '" + member.getGender() + "', '" + 
				member.getKorGrade() + "', '" + member.getEngGrade() + "', '" + member.getMathGrade() + "', '" + member.getAverage() + "')";
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* 해당 아이디가 존재하는지 체크 */
	public static boolean isExist(String loginID)
	{
		boolean result = false;
		// 로그인한 ID의 회원정보
		try {
			sql = "select * from memBasic where memberId = '" + loginID + "'";
			rs = st.executeQuery(sql);
			
			result = rs.next();		// 데이터가 있으면 true, 없으면 false
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/* text에서 가져온 데이터 전체를 hashMap으로 리턴 */
	public static HashMap<String, MemberDTO> getAllMemeber()
	{
		HashMap<String, MemberDTO> memberHash = new HashMap<String, MemberDTO>();
		// 로그인한 ID의 회원정보
		MemberDTO member = null;
		try {
			sql = "select * from memBasic";
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				member = new MemberDTO();
				String id = rs.getString(1);
				member.setMemberId(id);
				member.setPassword(rs.getString(2));
				member.setMailAddress(rs.getString(3));
				member.setMemberName(rs.getString(4));
				member.setBirthDate(rs.getString(5));
				member.setPhoneNum(rs.getString(6));
				member.setGender(rs.getString(7));
				member.setKorGrade(rs.getString(8));
				member.setEngGrade(rs.getString(9));
				member.setMathGrade(rs.getString(10));
				member.setAverage(rs.getString(11));
				
				memberHash.put(id, member);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberHash;
	}
	
	/* 로그인한 ID로 member정보 리턴 */
	public static MemberDTO getMemberInfo(String loginID) {
		// 로그인한 ID의 회원정보
		MemberDTO member = null;
		try {
			sql = "select * from memBasic where memberId = '" + loginID + "'";
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				member = new MemberDTO();
				member.setMemberId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setMailAddress(rs.getString(3));
				member.setMemberName(rs.getString(4));
				member.setBirthDate(rs.getString(5));
				member.setPhoneNum(rs.getString(6));
				member.setGender(rs.getString(7));
				member.setKorGrade(rs.getString(8));
				member.setEngGrade(rs.getString(9));
				member.setMathGrade(rs.getString(10));
				member.setAverage(rs.getString(11));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	/* 이름, 핸드폰번호로 member정보 리턴 */
	public static MemberDTO getMemberNPInfo(String name, String phone) {
		
		// 로그인한 ID의 회원정보
		MemberDTO member = null;
		try {
			sql = "select * from memBasic where memberName = '" + name + "' and phoneNum = '" + phone + "'";
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				member = new MemberDTO();
				member.setMemberId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setMailAddress(rs.getString(3));
				member.setMemberName(rs.getString(4));
				member.setBirthDate(rs.getString(5));
				member.setPhoneNum(rs.getString(6));
				member.setGender(rs.getString(7));
				member.setKorGrade(rs.getString(8));
				member.setEngGrade(rs.getString(9));
				member.setMathGrade(rs.getString(10));
				member.setAverage(rs.getString(11));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	/* 회원정보 수정 */
	public static void updateMember(MemberDTO member)
	{
		try {
			sql = "update memBasic set password = '" + member.getPassword() + "' where memberId = '" + member.getMemberId() + "'";
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* 회원 삭제 */
	public static void deleteMember(String loginID)
	{
		try {
			sql = "delete from memBasic where memberId = '" + loginID + "'";
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
