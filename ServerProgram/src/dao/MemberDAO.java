package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {

private SqlSessionFactory factory;
	
	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	//member List
	public List<MemberDTO> memberList(){
		SqlSession ss = factory.openSession();
		List<MemberDTO> list = ss.selectList("dao.members.memberList");
		ss.close();
		return list;
	}
	//member선택
	public MemberDTO selectMember(MemberDTO member) {
		SqlSession ss = factory.openSession();
		MemberDTO dto = ss.selectOne("dao.members.selectMember", member);
		ss.close();
		return dto;
	}
	//삽입
	public int insertMember(MemberDTO member) {
		SqlSession ss = factory.openSession();
		int result = ss.insert("dao.members.insertMember", member);
		if(result>0)ss.commit();
		ss.close();
		return result;
	}
	//삭제
	public int deleteMember(Long no) {
		SqlSession ss = factory.openSession();
		int result = ss.insert("dao.members.deleteMember", no);
		if(result>0)ss.commit();
		ss.close();
		return result;
	}
	// 수정
	public int updateMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.members.updateMember", member);
		if(result > 0)ss.commit();
		ss.close();
		return result;
	}
	
	//top 반환
	public MemberDTO topList(){
		SqlSession ss = factory.openSession();
		MemberDTO toplist = ss.selectOne("dao.members.topList");
		ss.close();
		return toplist;
	
	}
}
