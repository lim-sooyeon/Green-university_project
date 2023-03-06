package member01_IO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/** Label, TextField, ComboBox, Button 등 필드는 모든 화면에서 공통으로 사용. 다만 해당 화면에서 주로 사용하는 것들은 주석(//) 달아놓은 것뿐임 **/
/** 화면 Layout은 FrameController 클래스에서 메소드 생성해서 관리. 화면 클래스 파일에서 화면 레이아웃 작성 X **/
public class FrameController extends JFrame{
	/* JLabel 객체 생성*/
	// 성적 화면
	JLabel id_label = new JLabel("", 10);
	JLabel name_label = new JLabel("", 10);
	JLabel korGrade = new JLabel("", 10);
	JLabel engGrade = new JLabel("", 10);
	JLabel mathGrade = new JLabel("", 10);
	JLabel average = new JLabel("", 10);
	JLabel rank = new JLabel("", 10);
	// 회원정보수정 화면
	JLabel birth_label = new JLabel();
	JLabel email_label = new JLabel();
	JLabel phone_label = new JLabel();
	JLabel gender_label = new JLabel();
	
	/* TextField 객체 생성 */
	JTextField id = new JTextField(10);
	JPasswordField pw  = new JPasswordField(10);
	JPasswordField pwc  = new JPasswordField(10);
	JTextField email = new JTextField(10);
	JTextField name = new JTextField(10);
	JTextField phone = new JTextField(11);
	// 아이디찾기 필드
	TextField id_name = new TextField(10);
	TextField id_phone = new TextField(10);
	// 비밀번호찾기 필드
	TextField pw_id = new TextField(10);
	// 인증번호확인 필드
	TextField num = new TextField(10);
	
	/* ComboBox 객체 생성 */
	JComboBox<String> emailAddr = new JComboBox<String>();
	JComboBox<String> year = new JComboBox<String>();
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> date = new JComboBox<String>();
	JComboBox<String> gender = new JComboBox<String>();
	
	/* Button 객체 생성 */
	// 로그인 화면 버튼
	JButton btn_login = new JButton("로그인");
	JButton btn_join = new JButton("회원가입");
	JButton btn_searchIDPW = new JButton("아이디/비밀번호 찾기");
	// 회원가입 화면 버튼
	JButton idCheck = new JButton("중복검사");
	JButton btn_save = new JButton("저장");
	// 로그인후 회원정보 화면 버튼
	JButton btn_update = new JButton("회원정보 수정");
	JButton btn_grade = new JButton("성적관리");
	JButton btn_logout = new JButton("로그아웃");
	// 회원정보수정 화면 버튼
	JButton chgPW = new JButton("비밀번호변경");
	// 아이디찾기 버튼
	JButton btn_idRandom = new JButton("인증번호받기");
	JButton btn_idChkRandom = new JButton("인증번호 입력하기");
	// 비밀번호찾기 버튼
	JButton btn_pwRandom = new JButton("인증번호받기");
	JButton btn_pwChkRandom = new JButton("인증번호 입력하기");
	// 인증번호확인 버튼
	JButton btn_check = new JButton("확인");
	
	/* 생성자 호출 시 전체 Layout 세팅 */
	public FrameController() {
		/* 전체 Layout */
		setLayout(new BorderLayout());
	}
	
	/* 로그인 화면 */
	public void getLoginWindow() {
		// ID
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout());
		idPanel.add(new JLabel("ID : "));
		idPanel.add(id);
		
		// PW
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout());
		pwPanel.add(new JLabel("PW : "));
		pwPanel.add(pw);
		
		// btn_login
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		loginPanel.add(btn_login);
		
		// btn_searchID, btn_searchID, btn_searchPW
		JPanel threeBtnPanel = new JPanel();
		threeBtnPanel.setLayout(new FlowLayout());
		threeBtnPanel.add(btn_join);
		threeBtnPanel.add(btn_searchIDPW);
		
		// form
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4,1));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(loginPanel);
		formPanel.add(threeBtnPanel);
		
		add(formPanel, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/* 회원가입 화면 */
	public void getJoinWindow() {
		// 이메일 리스트
		emailAddr.addItem("@naver.com");
		emailAddr.addItem("@gmail.com");
		emailAddr.addItem("@daum.net");
		emailAddr.addItem("@nate.com");
		// 년도 리스트
		for(int i=0; i<100; i++)
			year.addItem(Integer.toString(1920+i)+"년");
		// 월 리스트
		for(int i=0; i<12; i++)
			month.addItem(Integer.toString(i+1)+"월");
		// 일 리스트
		for(int i=0; i<31; i++)
			date.addItem(Integer.toString(i+1)+"일");
		// 성별 리스트
		gender.addItem("남자");
		gender.addItem("여자");
		
		/* Center에 들어갈 각 Panel */
		// ID
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(id);
		idPanel.add(idCheck);
		// PW
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pw); 
		pwPanel.add(new JLabel("8자리 이상, 대소문자와 특수문자를 포함한 비밀번호"));
		// ConfirmPW
		JPanel pwcPanel = new JPanel();
		pwcPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwcPanel.add(new JLabel("비밀번호 재입력 : "));
		pwcPanel.add(pwc);
		// email
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(new JLabel("이메일주소 : "));
		emailPanel.add(email);
		emailPanel.add(emailAddr);
		// name
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		namePanel.add(new JLabel("이름: "));
		namePanel.add(name);
		// 생년월일
		JPanel ymdPanel = new JPanel();
		ymdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ymdPanel.add(new JLabel("생년월일: "));
		ymdPanel.add(year);
		ymdPanel.add(month);
		ymdPanel.add(date);
		// phone
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		phonePanel.add(new JLabel("핸드폰번호: "));
		phonePanel.add(phone);
		// gender
		JPanel genderPanel = new JPanel();
		genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		genderPanel.add(new JLabel("성별: "));
		genderPanel.add(gender);
		// form
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(8,1));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(pwcPanel);
		formPanel.add(emailPanel);
		formPanel.add(namePanel);
		formPanel.add(ymdPanel);
		formPanel.add(phonePanel);
		formPanel.add(genderPanel);
		
		String sphone = phone.getText();
		/* NORTH에 들어갈 패널 */
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("회원가입"));
		
		/* SOUTH에 들어갈 패널 */
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(btn_save);
		
		add(titlePanel, BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/* 성적관리 화면 */
	public void getGradeWindow() {
		
		/* NORTH에 들어갈 패널 */
		JPanel memberPanel = new JPanel();
		memberPanel.setLayout(new GridLayout(2,1));
		// title
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("성적관리"));
		// 기본정보
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(new JLabel("아이디 : "));
		infoPanel.add(id_label);
		infoPanel.add(new JLabel("이름 : "));
		infoPanel.add(name_label);
		
		memberPanel.add(titlePanel);
		memberPanel.add(infoPanel);
		
		/* CENTER에 들어갈 패널 */
		JPanel gradePanel = new JPanel();
		gradePanel.setLayout(new GridLayout(5,1));
		// 국어성적
		JPanel korPanel = new JPanel();
		korPanel.setLayout(new FlowLayout());
		korPanel.add(new JLabel("국어성적 : "));
		korPanel.add(korGrade);
		// 영어성적
		JPanel engPanel = new JPanel();
		engPanel.setLayout(new FlowLayout());
		engPanel.add(new JLabel("영어성적 : "));
		engPanel.add(engGrade);
		// 수학성적
		JPanel mathPanel = new JPanel();
		mathPanel.setLayout(new FlowLayout());
		mathPanel.add(new JLabel("수학성적 : "));
		mathPanel.add(mathGrade);
		// 평균
		JPanel avgPanel = new JPanel();
		avgPanel.setLayout(new FlowLayout());
		avgPanel.add(new JLabel("평균 : "));
		avgPanel.add(average);
		// 등수
		JPanel rankPanel = new JPanel();
		rankPanel.setLayout(new FlowLayout());
		rankPanel.add(new JLabel("등수 : "));
		rankPanel.add(rank);
		
		gradePanel.add(korPanel);
		gradePanel.add(engPanel);
		gradePanel.add(mathPanel);
		gradePanel.add(avgPanel);
		gradePanel.add(rankPanel);
		
		add(memberPanel, BorderLayout.NORTH);
		add(gradePanel, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(300, 250);
	}
	
	/* 로그인후 회원정보 화면 */
	public void getMemberInfoWindow() {
		
		JPanel btnPannel = new JPanel();
		btnPannel.setLayout(new FlowLayout());
		btnPannel.add(btn_update);
		btnPannel.add(btn_grade);
		btnPannel.add(btn_logout);
		
		add(btnPannel);
		
		setVisible(true);
		setSize(400, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/* 회원정보수정 화면 */
	public void getUpdateWindow() {

		/* Center에 들어갈 각 Panel */
		// ID
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(id_label);
		// PW
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pw); 
		pwPanel.add(chgPW); 
		// ConfirmPW
		JPanel pwcPanel = new JPanel();
		pwcPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwcPanel.add(new JLabel("비밀번호 재입력 : "));
		pwcPanel.add(pwc);
		// email
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(new JLabel("이메일주소 : "));
		emailPanel.add(email_label);
		// name
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		namePanel.add(new JLabel("이름: "));
		namePanel.add(name_label);
		// 생년월일
		JPanel ymdPanel = new JPanel();
		ymdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ymdPanel.add(new JLabel("생년월일: "));
		ymdPanel.add(birth_label);
		// phone
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		phonePanel.add(new JLabel("핸드폰번호: "));
		phonePanel.add(phone_label);
		// gender
		JPanel genderPanel = new JPanel();
		genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		genderPanel.add(new JLabel("성별: "));
		genderPanel.add(gender_label);
		
		// form
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(8,1));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(pwcPanel);
		formPanel.add(emailPanel);
		formPanel.add(namePanel);
		formPanel.add(ymdPanel);
		formPanel.add(phonePanel);
		formPanel.add(genderPanel);
		
		/* NORTH에 들어갈 패널 */
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("회원정보 수정"));
		
		add(titlePanel, BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(400, 400);
	}
	
	/* 아이디/비밀번호찾기 화면 */
	public void getSearchWindow() {
		
		JTabbedPane jPane = new JTabbedPane();
		add(jPane);
		
		/* 아이디 찾기 */
		JPanel idPanel = new JPanel(new BorderLayout());
		
		JPanel idcenterPanel = new JPanel(new GridLayout(2,1));
		JPanel idcenterFlow1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idcenterFlow1.add(new JLabel("이름 : "));
		idcenterFlow1.add(id_name);
		JPanel idcenterFlow2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idcenterFlow2.add(new JLabel("핸드폰번호: "));
		idcenterFlow2.add(id_phone);
		idcenterPanel.add(idcenterFlow1);
		idcenterPanel.add(idcenterFlow2);
		
		JPanel ideastPanel = new JPanel(new GridLayout(2,1));
		JPanel ideastFlow1 = new JPanel(new FlowLayout());
		ideastFlow1.add(btn_idRandom);
		JPanel ideastFlow2 = new JPanel(new FlowLayout());
		ideastFlow2.add(btn_idChkRandom);
		ideastPanel.add(ideastFlow1);
		ideastPanel.add(ideastFlow2);
		
		idPanel.add(new JLabel("핸드폰번호로 인증"), BorderLayout.WEST);
		idPanel.add(idcenterPanel, BorderLayout.CENTER);
		idPanel.add(ideastPanel, BorderLayout.EAST);
		
		/* 비밀번호 찾기 */
		JPanel pwPanel = new JPanel(new BorderLayout());

		JPanel pwcenterPanel = new JPanel(new FlowLayout());
		pwcenterPanel.add(new JLabel("아이디 : "));
		pwcenterPanel.add(pw_id);
		
		JPanel pweastPanel = new JPanel(new GridLayout(2,1));
		JPanel pweastFlow1 = new JPanel(new FlowLayout());
		pweastFlow1.add(btn_pwRandom);
		JPanel pweastFlow2 = new JPanel(new FlowLayout());
		pweastFlow2.add(btn_pwChkRandom);
		pweastPanel.add(pweastFlow1);
		pweastPanel.add(pweastFlow2);
		
		pwPanel.add(new JLabel("핸드폰번호로 인증"), BorderLayout.WEST);
		pwPanel.add(pwcenterPanel, BorderLayout.CENTER);
		pwPanel.add(pweastPanel, BorderLayout.EAST);
		
		/* tab에 각각 패널 넣기*/
		jPane.addTab("아이디찾기", idPanel);
		jPane.addTab("비밀번호찾기", pwPanel);
		
		setVisible(true);
		setSize(480, 180);
	}
	
	/* 인증번호확인 화면 */
	public void getChkNumWindow() {
		
		JPanel centerPanel = new JPanel(new GridLayout(3,1));
		
		JPanel numPanel = new JPanel(new FlowLayout());
		numPanel.add(new JLabel("인증번호 입력: "));
		numPanel.add(num);
		
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(btn_check);
		
		centerPanel.add(numPanel);
		centerPanel.add(btnPanel);
		
		add(centerPanel);
		
		setVisible(true);
		setSize(400, 200);
	}
	
	/* 인증번호확인 성공 화면 */
	public void getScsNumWindow(String kubun, String id) {
		
		/* kubun의 값이 "id"인 경우 */
		JPanel idPanel = new JPanel(new FlowLayout());
		idPanel.add(new JLabel("사용자 ID: "));
		idPanel.add(new JLabel(id));
		
		/* kubun의 값이 "pw"인 경우 */
		JPanel pwlPanel = new JPanel(new GridLayout(3,1));
		// PW
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pw); 
		// ConfirmPW
		JPanel pwcPanel = new JPanel();
		pwcPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		pwcPanel.add(new JLabel("비밀번호 재입력 : "));
		pwcPanel.add(pwc);
		// 비밀번호변경 버튼
		JPanel btnPanel = new JPanel();
		btnPanel.add(chgPW);
		
		pwlPanel.add(pwPanel);
		pwlPanel.add(pwcPanel);
		pwlPanel.add(btnPanel);
		
		if(kubun == "id")
			add(idPanel);
		else
			add(pwlPanel);
		
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
