package member01_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/** FileIO 호출하거나, MemberDTO 반환하는 메소드들은 MemberDao로 관리. **/
public class MemberDao {
	
	final static String FILE_NAME = "memberDTO.txt";
	
	/* 회원가입 */
	public static void joinMember(String[] memberInfo)
	{
		FileOutputStream fo = null;
		
		try {
			fo = new FileOutputStream(FILE_NAME,true);
			
			// TextField에서 받아온 회원정보를 text파일로 내보내기위해 dummy로 묶음
			String concatInfo = "";
			for(int i=0; i<memberInfo.length; i++)
			{
				concatInfo += memberInfo[i];
				
				if(i == memberInfo.length-1)
					concatInfo += "\r\n";
				else
					concatInfo += "/";
			}
			// String을 byte배열로.
			byte[] outputInfo = concatInfo.getBytes();
			// byte를 text파일로 내보냄
			fo.write(outputInfo);
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/* text에서 가져온 데이터 전체를 hashMap으로 리턴 */
	public static HashMap<String, MemberDTO> getAllMemeber()
	{
		FileInputStream fi = null;
		HashMap<String, MemberDTO> memberHash = new HashMap<String, MemberDTO>();
		File file = new File(FILE_NAME);
		
		try {
			// 파일이 존재하면
			if(file.exists()) {
				
				fi = new FileInputStream(FILE_NAME);
				
				byte[] allByte = new byte[fi.available()];
				
				while(fi.read(allByte) != -1) {}
				
				String allMember = new String(allByte);
				
				String[] splitRN = allMember.split("\r\n");
				for(int i=0; i<splitRN.length; i++)
				{
					MemberDTO member = new MemberDTO();
					String[] splitSlash = splitRN[i].split("/");
					for(int j=0; j<splitSlash.length; j++)
					{
						if(j==0) member.setMemberId(splitSlash[j]);
						else if(j==1) member.setPassword(splitSlash[j]);
						else if(j==2) member.setMailAddress(splitSlash[j]);
						else if(j==3) member.setMemberName(splitSlash[j]);
						else if(j==4) member.setBirthDate(splitSlash[j]);
						else if(j==5) member.setPhoneNum(splitSlash[j]);
						else if(j==6) member.setGender(splitSlash[j]);
						else if(j==7) member.setKorGrade(splitSlash[j]);
						else if(j==8) member.setEngGrade(splitSlash[j]);
						else if(j==9) member.setMathGrade(splitSlash[j]);
						else if(j==10) member.setAverage(splitSlash[j]);
					}
					memberHash.put(member.getMemberId(), member);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return memberHash;
	}
	
	/* 로그인한 ID로 member정보 리턴 */
	public static MemberDTO getMemberInfo(String loginID) {
		HashMap<String, MemberDTO> members = getAllMemeber();
		
		// 로그인한 ID의 회원정보
		MemberDTO member = null;
		if(members.containsKey(loginID))
		{
			member = members.get(loginID);
		}
		
		return member;
	}
	
	/* 이름, 핸드폰번호로 member정보 리턴 */
	public static MemberDTO getMemberNPInfo(String name, String phone) {
		/* 전체 member 가져오기 */
		HashMap<String, MemberDTO> members = MemberDao.getAllMemeber();
		
		// MemberDTO 객체 ArrayList로 저장
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		for(String key : members.keySet())
		{
			memberList.add(members.get(key));
		}
		
		// 입력받은 이름, 핸드폰번호와 일치하는 member가 있는지 체크
		MemberDTO member = null;
		for(int i=0; i<memberList.size(); i++)
		{
			if(name.equals(memberList.get(i).getMemberName()) 
					&& phone.equals(memberList.get(i).getPhoneNum()))
			{
				member = memberList.get(i);
			}
		}
		
		return member;
	}
	
	/* 회원정보 수정 */
	public static void updateMember(String data)
	{
		FileOutputStream fo = null;
		
		try {
			fo = new FileOutputStream(FILE_NAME);
			
			// String을 byte배열로.
			byte[] outputInfo = data.getBytes();
			// byte를 text파일로 내보냄
			fo.write(outputInfo);
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
