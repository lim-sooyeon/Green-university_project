package member03_Mybatis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SearchWindow extends FrameController {
	
	static String randomNum = "";

	public SearchWindow() {
		/* 아이디/비밀번호찾기 Frame */
		getSearchWindow();
		
		/* 아이디찾기 인증번호받기 */
		btn_idRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((id_name.getText()).equals("") || (id_phone.getText()).equals(""))
				{
					new CommonPopup(1);			// "빈값은 입력할 수 없습니다."
				}
				else
				{
					String id_sname = id_name.getText(); 
					String id_sphone = id_phone.getText(); 
					
					MemberDTO member = MemberDao.getMemberNPInfo(id_sname, id_sphone);
					
					//System.out.println(Objects.isNull(member));
					// member 객체가 null인지 체크
					if(!Objects.isNull(member))
					{
						CommonPopup cp = new CommonPopup(13);	// "인증번호: xxxxxx"
						randomNum = cp.getRandomStr();
						System.out.println(randomNum);
					}
					else
					{
						new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
					}
				}
			}
		});
		
		/* 아이디찾기 인증번호입력 */
		btn_idChkRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id_sname = id_name.getText(); 
				String id_sphone = id_phone.getText(); 
				
				new ChkNumWindow(randomNum, id_sname, id_sphone);
			}
		});
		
		/* 비밀번호찾기 인증번호받기 */
		btn_pwRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((pw_id.getText()).equals(""))
				{
					new CommonPopup(1);			// "빈값은 입력할 수 없습니다."
				}
				else
				{
					String pw_sid = pw_id.getText(); 
					
					MemberDTO member = MemberDao.getMemberInfo(pw_sid);
					
					//System.out.println(Objects.isNull(member));
					// member 객체가 null인지 체크
					if(!Objects.isNull(member))
					{
						CommonPopup cp = new CommonPopup(13);	// "인증번호: xxxxxx"
						randomNum = cp.getRandomStr();
						System.out.println(randomNum);
					}
					else
					{
						new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
					}
				}
			}
		});
		
		/* 비밀번호찾기 인증번호입력 */
		btn_pwChkRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pw_sid = pw_id.getText(); 
				
				new ChkNumWindow(randomNum, pw_sid);
			}
		});
	}
}
