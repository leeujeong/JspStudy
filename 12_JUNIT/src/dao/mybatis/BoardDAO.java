package dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Board;
import mybatis.config.DBService;

public class BoardDAO {

	private SqlSessionFactory factory;
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<Board> selectBoardList() {
		SqlSession ss = factory.openSession();
		List<Board> list = ss.selectList("dao.mybatis.board.selectBoardList");
		ss.close();
		return list;
	}
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession();
		int result = ss.insert("dao.mybatis.insertBoard", board);
		if(result > 0)ss.commit();
		ss.close();
		return result;
	}
	public int deleteBoard(String bNo) {
		SqlSession ss = factory.openSession();
		int result = ss.delete("dao.mybatis.deleteBoard", bNo);
		if(result > 0)ss.commit();
		ss.close();
		return result;
	}
	public Board selectBoard(String bNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("dao.mybatis.board.selectBoard", bNo);
		ss.close();
		return board;
	}
	
	
	
	
}