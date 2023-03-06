package member01_IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ChkNumWindow extends FrameController {
	
	/* 아이디찾기 인증번호확인 생성자 */
	public ChkNumWindow(String randomNum, String name, String phone) {
		/* 아이디찾기 인증번호확인 Frame */
		getChkNumWindow();
		
		btn_check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((num.getText()).equals(""))
				{
					new CommonPopup(1);			// "빈값은 입력할 수 없습니다."
				}
				else
				{
					if((num.getText()).equals(randomNum))
					{
						MemberDTO member = MemberDao.getMemberNPInfo(name, phone);
						if(!Objects.isNull(member))
							new ScsNumWindow("id", member.getMemberId());
						else
							new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
					}
					else
					{
						new CommonPopup(14);	// "인증번호가 일치하지 않습니다."
					}
				}
			}
		});		
	}
	
	/* 비밀번호찾기 인증번호확인 생성자 */
	public ChkNumWindow(String randomNum, String id) {
		/* 비밀번호찾기 인증번호확인 Frame */
		getChkNumWindow();
		
		btn_check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((num.getText()).equals(""))
				{
					new CommonPopup(1);			// "빈값은 입력할 수 없습니다."
				}
				else
				{
					if((num.getText()).equals(randomNum))
					{
						MemberDTO member = MemberDao.getMemberInfo(id);
						if(!Objects.isNull(member))
							new ScsNumWindow("pw", member.getMemberId());
						else
							new CommonPopup(12);	// "일치하는 회원정보가 없습니다."
					}
					else
					{
						new CommonPopup(14);	// "인증번호가 일치하지 않습니다."
					}
				}
			}
		});		
	}
	
}
