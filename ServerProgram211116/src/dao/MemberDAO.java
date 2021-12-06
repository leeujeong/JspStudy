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
		List<MemberDTO> list = ss.selectList("dao.member.memberList");
		ss.close();
		return list;
	}
	//총 member
	public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.member.getTotalCount");
		ss.close();
		return totalCount;
	}
	
	//top 반환
	public List<MemberDTO> topList(){
		SqlSession ss = factory.openSession();
		List<MemberDTO> toplist = ss.selectOne("dao.member.topList");
		ss.close();
		return toplist;
	}
		
	//member 수정
	public int updateMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.member.updateMember", member);
		if(result > 0)ss.commit();
		ss.close();
		return result;
	
	}
}
