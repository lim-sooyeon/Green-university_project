package member01_IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberInfoWindow extends FrameController {

	public MemberInfoWindow(String loginID) {
		/* 로그인후 회원정보 Frame */
		getMemberInfoWindow();
		
		// 회원정보수정
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateWindow(loginID);
			}
		});
		
		// 성적관리
		btn_grade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GradeWindow(loginID);
			}
		});
		
		// 로그아웃
		btn_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CommonPopup(4);
				dispose();
				new LoginWindow();
				
			}
		});
		
	}
}
