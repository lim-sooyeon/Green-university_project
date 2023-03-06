package member03_Mybatis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinWindow extends FrameController{
	
	// 중복검사 클릭 건수 
	static int idCheckCnt = 0;
	
	public JoinWindow() {
		/* 회원가입 Frame */
		getJoinWindow();
		
		// 저장 버튼 클릭 시 
		btn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String spw = new String(pw.getPassword());		// PW
				String spwc = new String(pwc.getPassword());	// PWC
				String sgender = String.valueOf(gender.getSelectedItem());
				if("남자".equals(sgender)) sgender = "male";
				else sgender = "female";
				
				MemberDTO member = new MemberDTO();
				member.setMemberId(id.getText());
				member.setPassword(String.valueOf(pw.getPassword()));
				member.setMailAddress(email.getText() + emailAddr.getSelectedItem());
				member.setMemberName(name.getText());
				String syear = (String.valueOf(year.getSelectedItem())).substring(0, 4);
				String smonth = (String.valueOf(month.getSelectedItem())).substring(0, 2);
				String sdate = (String.valueOf(date.getSelectedItem())).substring(0, 2);
				member.setBirthDate(syear + smonth + sdate);
				member.setPhoneNum(phone.getText());
				member.setGender(sgender);
				member.setKorGrade("");
				member.setEngGrade("");
				member.setMathGrade("");
				member.setAverage("");
				
				// 8자리, 비밀번호 대소문자, 특수문자 체크
				String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
				Matcher matcher = Pattern.compile(pwPattern).matcher(spw);
				
				if ("".equals(id.getText()) || "".equals(spw) || "".equals(spwc) || "".equals(email.getText()) || 
					"".equals(name.getText()) || "".equals(phone.getText()))
				{
					new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
				}
				else if (idCheckCnt == 0)
				{
					new CommonPopup(5);		// "중복검사 버튼을 클릭하세요";
				}	
//				else if (!matcher.matches())
//				{
//					System.out.println("폰번호이상함");
//				}
				else if (!spw.equals(spwc))
				{
					new CommonPopup(8);		// "비밀번호가 일치하지 않습니다."
				}
//				else if (!matcher.matches())
//				{
//					new CommonPopup(6);		// "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요."
//					pw.setText("");
//					pwc.setText("");
//				}
				else if ((phone.getText()).length() != 11)
				{
					new CommonPopup(15);	// "핸드폰번호는 11자리만 가능합니다."
				}
				else
				{
					/* text파일로 내보내기위해 IO작업하는 공통 메소드 호출 */
					MemberDao.joinMember(member);
					dispose();
					new LoginWindow();
				}
			}
		});
		
		/* 아이디 중복검사 */
		idCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 해당 아이디가 존재하는지 체크
				MemberDTO member = MemberDao.getMemberInfo(id.getText());
				
				if(!Objects.isNull(member))
				{
					new CommonPopup(2);			// "이미 존재하는 아이디입니다."
					id.setText("");
				}
				else
				{
					if((id.getText()).equals(""))
					{
						new CommonPopup(1);		// "빈값은 입력할 수 없습니다."
					}
					else
					{
						idCheckCnt++;
						new CommonPopup(3);		// "사용할 수 있는 아이디입니다."
					}
				}
			}
		});
	}
}
