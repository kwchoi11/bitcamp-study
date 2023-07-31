package pj.handler;

import pj.dao.BoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;

public class BoardDeleteListener implements ActionListener {

  BoardDao boardDao;

  public BoardDeleteListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (boardDao.delete(prompt.inputInt("게시글 번호: ")) == 0) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}

