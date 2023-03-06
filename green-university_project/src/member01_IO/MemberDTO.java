package member01_IO;

public class MemberDTO implements Comparable<MemberDTO>{
	private String memberId;
	private String password;
	private String mailAddress;
	private String memberName;				
	private String birthDate;
	private String phoneNum;
	private String gender; 
	private String korGrade;
	private String engGrade;	
	private String mathGrade;
	private String average;
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setKorGrade(String korGrade) {
		this.korGrade = korGrade;
	}
	public void setEngGrade(String engGrade) {
		this.engGrade = engGrade;
	}
	public void setMathGrade(String mathGrade) {
		this.mathGrade = mathGrade;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public String getPassword() {
		return password;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getGender() {
		return gender;
	}
	public String getKorGrade() {
		return korGrade;
	}
	public String getEngGrade() {
		return engGrade;
	}
	public String getMathGrade() {
		return mathGrade;
	}
	public String getAverage() {
		return average;
	}
	
	@Override
	public String toString() {
		String info = getMemberId() + "/" + getPassword() + "/" + getMailAddress() + "/" + 
					getMemberName() + "/" + getBirthDate() + "/" + getPhoneNum() + "/" + 
					getGender() + "/" + getKorGrade() + "/" + getEngGrade() + "/" + 
					getMathGrade() + "/" + getAverage();
		return info;
	}
	
	// why? MemberDTO list의 등수를 계산하기 위해서 Comparable implements
	@Override
	public int compareTo(MemberDTO member) {
		return this.average.compareTo(member.average);
	}
}
