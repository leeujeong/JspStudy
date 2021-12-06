package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDAO;
import dto.MemberDTO;

public class Top implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		List<MemberDTO> toplist = MemberDAO.getInstance().topList();
		
		//list를 파일로 만들기
		File file = new File("top.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			for(MemberDTO member : toplist) {
				bw.write(member.getNo() + "\n" );
				bw.write(member.getId() + "\n" );
				bw.write(member.getName() + "\n" );
				bw.write(member.getGrade() + "\n" );
				bw.write(member.getPoint() + "\n" );

			}
			System.out.println("파일 생성완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
