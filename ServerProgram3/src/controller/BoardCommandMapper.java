package controller;

import command.BoardCommand;
import command.DeleteBoardCommand;
import command.InsertBoardCommand;
import command.InsertBoardPage;
import command.InsertReplyCommand;
import command.SelectOneBoardCommand;

public class BoardCommandMapper {
	
	private static BoardCommandMapper instance = new BoardCommandMapper();
	private BoardCommandMapper() {}
	public static BoardCommandMapper getInstance() {
		if (instance == null) {
			instance = new BoardCommandMapper();
		}
		return instance;
	}
	public BoardCommand getCommand(String cmd) {
		BoardCommand command = null;
		switch (cmd) {		
		case "insertBoardPage.do":
			command = new InsertBoardPage();
			break;
		case "insertBoard.do":
			command = new InsertBoardCommand();
			break;
		case "selectOneBoard.do":
			command = new SelectOneBoardCommand();
			break;
		
		case "deleteBoard.do":
			command = new DeleteBoardCommand();
			break;
		
		case "insertReply.do":
			command = new InsertReplyCommand();
			break;
		
		}
		return command;
	}

}
