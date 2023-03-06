package member01_IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginWindow extends FrameController {
	
	public LoginWindow() {
		/* 로그인 Frame */
		getLoginWindow();
		
		// 로그인 버튼
		btn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sid = id.getText();
				String spw = new String(pw.getPassword());
				if(sid.equals("") || spw.equals(""))
				{
					new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
				}
				else
				{
					boolean loginTF = loginCheck();
					if(loginTF)
					{
						dispose();
						new MemberInfoWindow(id.getText());
					}
					else
					{
						new CommonPopup(11);	// "비밀번호가 일치하지 않거나 해당 아이디가 존재하지 않습니다."
					}
				}
			}
		});
		
		// 회원가입 버튼
		btn_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JoinWindow();
			}
		});
		
		// 아이디/비밀번호찾기 버튼
		btn_searchIDPW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchWindow();
			}
		});
	}
	
	public boolean loginCheck() {
		MemberDTO member = MemberDao.getMemberInfo(id.getText());
		String spw = new String(pw.getPassword());
		
		boolean result = false;
		// 받아온 객체가 null이면
		if(!Objects.isNull(member))
		{
			if(spw.equals(member.getPassword()))
				result = true;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		new LoginWindow();
	}
}
