package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDAO;
import dto.MemberDTO;

public class Top implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		MemberDTO top = MemberDAO.getInstance().topList();
		File file = new File("top.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write("회원번호:" + top.getNo() + "\n");
			bw.write("회원아이디:" + top.getId() + "\n");
			bw.write("회원명:" + top.getName() + "\n");
			bw.write("회원등급:" + top.getGrade() + "\n");
			bw.write("회원포인트" + top.getPoint() + "\n");
			System.out.println("top.list 파일생성완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
