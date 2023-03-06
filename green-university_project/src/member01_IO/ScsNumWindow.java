package member01_IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScsNumWindow extends FrameController {

	public ScsNumWindow(String kubun, String id) {
		/* 인증번호확인 성공 화면 */
		getScsNumWindow(kubun, id);
		
		chgPW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String spw = new String(pw.getPassword());		// 비밀번호
				String spwc = new String(pwc.getPassword());	// 비밀번호 재입력
				
				if (spw.equals("") || spwc.equals(""))
				{
					new CommonPopup(1);			// "빈값은 입력할 수 없습니다."
				}
				else
				{
					HashMap<String, MemberDTO> members = MemberDao.getAllMemeber();
					MemberDTO member = new MemberDTO();
					if(members.containsKey(id))
					{
						member = members.get(id);
						members.remove(id);
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
					
					if(spw.equals(spwc))
					{
						// 8자리, 비밀번호 대소문자, 특수문자 체크
						String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
						Matcher matcher = Pattern.compile(pwPattern).matcher(spw);
						
						if (!matcher.matches())
						{
							new CommonPopup(6);		// "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요."
							pw.setText("");
							pwc.setText("");
						}
						else
						{
							/* 회원정보 수정 메소드 호출*/
							MemberDao.updateMember(data);
							new CommonPopup(10);	// "회원정보가 수정되었습니다."
							dispose();
						}
					}
					else 
					{
						new CommonPopup(8);		// "비밀번호가 일치하지 않습니다."
					}
				}
			}
		});
		
	}
}
