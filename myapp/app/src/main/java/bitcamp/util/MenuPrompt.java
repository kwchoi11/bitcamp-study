package bitcamp.util;

public class MenuPrompt extends Prompt {

  private Queue commandHistory = new Queue();
  private Stack menus = new Stack();
  private Stack breadcrumbs = new Stack();

  // 추가
  public void appendBreadcrumb(String title, String menu) {
    this.breadcrumbs.push(title);
    this.menus.push(menu);
  }

  // 삭제
  public void removeBreadcrumb() {
    this.breadcrumbs.pop();
    this.menus.pop();
  }

  public void printMenu() {
    System.out.println(menus.peek());
  }

  // 명령 기록 출력
  public void printCommandHistory() {
    for (int i = 0; i < commandHistory.size(); i++) {
      System.out.println(commandHistory.get(i));
    }
  }

  // breadcrumb 메뉴 순서대로 출력
  public String inputMenu() {
    // StringBuilder 사용
    StringBuilder titleBuilder = new StringBuilder(); // 예) 메인/회원>
    for (int i = 0; i < this.breadcrumbs.size(); i++) {
      // 기존에 title 이 있다면 사이에 "/" 추가
      if (titleBuilder.length() > 0) {
        titleBuilder.append("/");
      }
      titleBuilder.append(this.breadcrumbs.get(i));
    }
    titleBuilder.append("> ");

    String command = null;

    while (true) {
      command = this.inputString(titleBuilder.toString());
      if (command.equals("history")) {
        printCommandHistory();
      } else {
        break;
      }
    }

    // 사용자가 입력한 명령어를 history 에 보관
    if (commandHistory.size() == 10) {
      // 명령어 목록은 최대 10개만 유지한다.
      // 10개를 초과할 경우 맨 앞의 기록을 삭제한다.
      commandHistory.poll();
    }
    String menuTitle = findMenuTitle(command);
    commandHistory.offer(command);
    return command;
  }

  private String findMenuTitle(String command) {
    String menuTitle = null;

    // 메뉴에서 command에 해당하는 메뉴가 있다면 그 메뉴 이름을 return하고
    // 없다면 null을 return한다.

    // 1) 현재 메뉴를 알아낸다. 메뉴 스택에서 맨 마지막에 입력한 메뉴를 조회한다.
    String menu = (String) menus.peek();

    // 2) 꺼낸 메뉴에서 해당 번호의 메뉴를 찾는다.'
    String[] menuItems = menu.split("\n");
    for (String menuItem : menuItems) {
      System.out.println("====>" + line);
    }

    return menuTitle;
  }
}

