package StudentCRUD.StudentCRUD;


public class StudentModel {
	private int student_no;
	private String student_name;
	private String student_dob;
	private String student_doj;
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentModel(int student_no, String student_name, String student_dob, String student_doj) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.student_dob = student_dob;
		this.student_doj = student_doj;
	}
	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_dob() {
		return student_dob;
	}
	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}
	public String getStudent_doj() {
		return student_doj;
	}
	public void setStudent_doj(String student_doj) {
		this.student_doj = student_doj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + student_no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModel other = (StudentModel) obj;
		if (student_no != other.student_no)
			return false;
		return true;
	}

}


