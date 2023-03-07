📌 그린대학교(Green university)
====================

* 그린대학교 성적 관리 페이지 구현

🔸 소개
------------

* 프로젝트명 : 그린대학교(Green university)
* 수행 기간  : 2022.06.10 ~ 2022.06.24
* 기능 구현  : 회원가입, 로그인, 아이디/비밀번호 찾기, 회원정보 수정, 성적 조회, 수업목록 조회
* 중요 기능
  * [JAVA]Mybatis-mvc패턴을 이용
  * GUI 프로그래밍 - AWT 컴포넌트, Swing컴포넌트 사용
  * 회원가입시 랜덤으로 점수 부여
  ```
  public void setKorGrade(String korGrade) {
		int random = (int)(Math.random()*100)+1;
		if("".equals(korGrade))
			this.korGrade = Integer.toString(random);
		else
			this.korGrade = korGrade;
	}
  ```
  * CommonPopup.java 파일을 별도로 관리하여 Popup 창을 편리하게 사용하도록 구현
 
   ```
    public CommonPopup(int num) {

      message = null;
      int messageIcon = ERROR_MESSAGE;

      switch (num) {
      case 1:
        message = "빈값은 입력할 수 없습니다.";
        break;

            case 11:
        message = "비밀번호가 일치하지 않거나 해당 아이디가 존재하지 않습니다.";
        break;
          }
     }
     ```
  
   ``` 
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
  ```
🔸 개발 과정
------------
* 티스토리에 정리-첫 시작 URL: <https://developer-jeri.tistory.com/18> 

🔸구현 이미지
------------
* 로그인

![image](https://user-images.githubusercontent.com/102607435/223306626-52d1f4a0-eb0e-4b95-b7ae-768db8fac490.png)

* 회원가입

<img src="https://user-images.githubusercontent.com/102607435/223306770-23aa592a-b59b-4f15-972a-dfbd97afd05d.png" width="405" height="320">

![image](https://user-images.githubusercontent.com/102607435/223307897-e687cdbc-6eff-414a-9522-50f29e98775e.png)

![image](https://user-images.githubusercontent.com/102607435/223307975-c5eb09c5-3dfa-4562-be73-dceadcb7e6c0.png)

![image](https://user-images.githubusercontent.com/102607435/223308039-e33f7d5d-4a1f-4430-9a3c-be20d4c6e75a.png)

* 

![image](https://user-images.githubusercontent.com/102607435/223307194-f0368b55-6a42-466b-ab37-c66583e58bb5.png)

* 회원정보 

![image](https://user-images.githubusercontent.com/102607435/223307307-c47b1188-1b03-48ea-8085-341b8f3bf93f.png)

* 성적관리

![image](https://user-images.githubusercontent.com/102607435/223307371-9db28d9b-0f08-42b2-9368-8f1abc815885.png)




 
 
