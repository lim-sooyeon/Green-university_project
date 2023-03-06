package member03_Mybatis;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/** Mybatis DB 호출하거나, MemberDTO 반환하는 메소드들은 MemberDao로 관리. **/
public class MemberDao {
	
	static SqlSessionFactory factory;
	
	/* DB 연결 */
	public static void getConnection() 
	{
		try {
			Reader reader = Resources.getResourceAsReader("memberConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 회원가입 */
	public static void joinMember(MemberDTO member)
	{
		SqlSession session = factory.openSession();
		session.insert("insert", member);
		session.commit();
		session.close();
	}
	
	/* text에서 가져온 데이터 전체를 hashMap으로 리턴 */
	public static HashMap<String, MemberDTO> getAllMemeber()
	{
		SqlSession session = factory.openSession();
		List<MemberDTO> list = session.selectList("selectAll");
		session.close();
		
		HashMap<String, MemberDTO> memberHash = new HashMap<String, MemberDTO>();
		if(!list.isEmpty())
		{
			for(MemberDTO m : list)
			{
				memberHash.put(m.getMemberId(), m);
			}
		}
		
		return memberHash;
	}
	
	/* 로그인한 ID로 member정보 리턴 */
	public static MemberDTO getMemberInfo(String loginID) {
		SqlSession session = factory.openSession();
		List<MemberDTO> list = session.selectList("searchID", loginID);
		session.close();
		
		// 로그인한 ID의 회원정보
		MemberDTO member = null;
		if(!list.isEmpty())
			member = list.get(0);
		
		return member;
	}
	
	/* 이름, 핸드폰번호로 member정보 리턴 */
	public static MemberDTO getMemberNPInfo(String name, String phone) {
		// 로그인한 ID의 회원정보
		MemberDTO member = new MemberDTO();
		member.setMemberName(name);
		member.setPhoneNum(phone);
		
		SqlSession session = factory.openSession();
		List<MemberDTO> list = session.selectList("searchNP", member);
		session.close();
		
		if(!list.isEmpty())
			member = list.get(0);
		
		return member;
	}
	
	/* 회원정보 수정 */
	public static void updateMember(MemberDTO member)
	{
		SqlSession session = factory.openSession();
		session.update("update", member);
		session.commit();
		session.close();
	}
	
	/* 회원 삭제 */
	public static void deleteMember(String loginID)
	{
		SqlSession session = factory.openSession();
		session.delete("delete", loginID);
		session.commit();
		session.close();
	}
	
}
