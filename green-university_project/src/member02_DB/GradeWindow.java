package member02_DB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class GradeWindow extends FrameController {
	
	static int memberRank = 0;	// 회원 등수
	
	public GradeWindow(String loginID) {
		/* 성적관리 Frame */
		getGradeWindow();
		
		id_label.setText(loginID);
		
		/* 로그인한 ID로 회원의 정보 가져오기 */
		MemberDTO loginMember = getLoginMember(loginID);
		if(!Objects.isNull(loginMember))
		{
			name_label.setText(loginMember.getMemberName());
			korGrade.setText(String.valueOf(loginMember.getKorGrade()));
			engGrade.setText(String.valueOf(loginMember.getEngGrade()));
			mathGrade.setText(String.valueOf(loginMember.getMathGrade()));
			average.setText(String.valueOf(loginMember.getAverage()));
			rank.setText(Integer.toString(memberRank));
		}
		else
		{
			new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
		}
	}
	
	/* 로그인한 ID로 회원의 정보 가져오기 위한 메소드*/
	public MemberDTO getLoginMember(String loginID) {
		HashMap<String, MemberDTO> members = MemberDao.getAllMemeber();
		
		// 로그인한 ID의 회원정보
		MemberDTO member = null;
		if(members.containsKey(loginID))
		{
			member = members.get(loginID);
		}
		
		// 회원 전체를 ArrayList로 저장
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		for(String key : members.keySet())
		{
			memberList.add(members.get(key));
		}
		// MemberDTO에 Comparable 구현했기때문에 가능함. 
		Collections.sort(memberList, Collections.reverseOrder());
		// 로그인한 ID의 등수 계산
		for(int i=0; i<memberList.size(); i++)
			if((memberList.get(i).getMemberId()).equals(loginID))
				memberRank = i+1;
		
		return member;
	}
}
