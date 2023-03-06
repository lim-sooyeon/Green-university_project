package member02_DB;

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
		
		// 회원탈퇴
		btn_withdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CommonPopup cp = new CommonPopup(16);	// "정말 탈퇴하시겠습니까?"
				int confirm_num = cp.getConfirm_num();	// yes: 0, no: 1
				if(confirm_num == 0)
				{
					// 회원삭제 호출
					MemberDao.deleteMember(loginID);
					new CommonPopup(17);	// "회원 탈퇴되었습니다."
					dispose();
					new LoginWindow();
				}
			}
		});
		
	}
}
