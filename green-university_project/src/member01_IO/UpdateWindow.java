package member01_IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateWindow extends FrameController {

	public UpdateWindow(String loginID) {
		/* 회원정보수정 Frame */
		getUpdateWindow();
		
		id_label.setText(loginID);
		
		/* text파일에 있는 정보를 가져오기위해 공통 메소드 호출*/
		MemberDTO member = MemberDao.getMemberInfo(loginID);
		
		email_label.setText(member.getMailAddress());
		name_label.setText(member.getMemberName());
		birth_label.setText(member.getBirthDate());
		phone_label.setText(member.getPhoneNum());
		gender_label.setText(member.getGender());
		
		/* 비밀번호 변경 버튼 클릭 시 */
		chgPW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!(pw.getPassword().equals("")))
				{
					String spw = new String(pw.getPassword());		// 비밀번호
					String spwc = new String(pwc.getPassword());		// 비밀번호 재입력
					
					HashMap<String, MemberDTO> members = MemberDao.getAllMemeber();
					MemberDTO member = new MemberDTO();
					if(members.containsKey(loginID))
					{
						member = members.get(loginID);
						members.remove(loginID);
					}
					// password 변경
					member.setPassword(spw);
					// 변경한 password로 hashMap에 put
					members.put(member.getMemberId(), member);
					String data = "";
					for(String s : members.keySet())
					{
						data += members.get(s) + "\r\n";
					}
					
					// 8자리, 비밀번호 대소문자, 특수문자 체크
					String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
					Matcher matcher = Pattern.compile(pwPattern).matcher(spw);
					
					if(!spw.equals(spwc))
					{
						new CommonPopup(8);
					}
					else if (!matcher.matches())
					{
						new CommonPopup(6);		// "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요."
						pw.setText("");
						pwc.setText("");
					}
					else 
					{
						/* 회원정보 수정 메소드 호출*/
						MemberDao.updateMember(data);
						new CommonPopup(10);
						dispose();
					}
				}
				else
				{
					new CommonPopup(7);
				}
			}
		});
		
	}
}
