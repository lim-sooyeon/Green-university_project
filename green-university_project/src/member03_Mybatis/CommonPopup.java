package member03_Mybatis;

import javax.swing.JOptionPane;

/** 팝업화면은 CommonPopup 생성자에 매개변수인 숫자값 넘겨서 관리 **/
public class CommonPopup extends JOptionPane{

	String message;
	String randomStr;
	int confirm_num;
	
	public CommonPopup(int num) {
		
		message = null;
		int messageIcon = ERROR_MESSAGE;
		
		switch (num) {
		case 1:
			message = "빈값은 입력할 수 없습니다.";
			break;
		case 2:
			message = "이미 존재하는 아이디입니다.";
			break;
		case 3:
			message = "사용할 수 있는 아이디입니다.";
			messageIcon = INFORMATION_MESSAGE;
			break;
		case 4:
			message = "로그아웃되었습니다.";
			messageIcon = INFORMATION_MESSAGE;
			break;
		case 5:
			message = "중복검사 버튼을 클릭하세요.";
			break;
		case 6:
			message = "8자리 이상, 대소문자와 특수문자를 포함한 비밀번호를 입력해주세요.";
			break;
		case 7:
			message = "비밀번호를 재입력하세요.";
			break;
		case 8:
			message = "비밀번호가 일치하지 않습니다.";
			break;
		case 9:
			message = "회원가입 되었습니다.";
			messageIcon = INFORMATION_MESSAGE;
			break;
		case 10:
			message = "회원정보가 수정되었습니다.";
			messageIcon = INFORMATION_MESSAGE;
			break;
		case 11:
			message = "비밀번호가 일치하지 않거나 해당 아이디가 존재하지 않습니다.";
			break;
		case 12:
			message = "일치하는 회원정보가 없습니다.";
			break;
		case 13:
			String randomStr = "";
			for(int i=0; i<6; i++)
			{
				int random = (int)(Math.random()*10);
				randomStr += Integer.toString(random);
			}
			this.randomStr = randomStr;
			message = "인증번호: " + randomStr;
			break;
		case 14:
			message = "인증번호가 일치하지 않습니다.";
			break;
		case 15:
			message = "핸드폰번호는 11자리만 가능합니다.";
			break;
		case 16:
			message = "정말 탈퇴하시겠습니까?";
			break;
		case 17:
			message = "회원 탈퇴되었습니다.";
			messageIcon = INFORMATION_MESSAGE;
			break;
		default:
			break;
		}
		
		if (num == 16)
		{
			confirm_num = showConfirmDialog(null, message, "MESSAGE", YES_NO_OPTION, messageIcon, null);
		}
		else
		{
			showMessageDialog(null, message, "MESSAGE", messageIcon);
		}
	}
	
	public String getRandomStr() {
		return this.randomStr;
	}
	
	public int getConfirm_num() {
		return this.confirm_num;
	}
}
