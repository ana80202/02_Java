package edu.kh.todolist.model.service;

import edu.kh.todolist.model.dao.TodoListDAO;
import edu.kh.todolist.model.dto.Todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.model.dao.TOdoListDAOImpl;

public  class TodoListServiceiImpl implements TodoListService {

	//필드
	private TodoListDAO dao = null;

	public TodoListServiceiImpl() throws  FileNotFoundException, IOException, ClassNotFoundException {
		
		//TodoListServiceiImpl 객체가 생성될 때
		dao = new TOdoListDAOImpl();//TodoListDAOiImpl 객체 생성
		//부모타입참조변수 = 자식객체 (다형성 업캐스팅)
	}
	
	//----------------------------------------
	
	/*odoListFullView*/
	@Override
	public Map<String, Object> todoListFullView(){
		
		//1. 할 일 목록 DAO에서 얻어오기
		List<Todo> todoList = dao.todoListFullView();
		
		//2. 할 일 목록에서 완료인 요소가 몇 개인지 카운트(Complete 필드 값이 true)인 요소가 몇 개인지 카운트
		int completeCount = 0;
		
		for(Todo todo : todoList) {
			
			// isComplete() == getComplete()
			if(todo.isComplete()) { //true 인 경우
				completeCount++;
			}
		}
		
		//3. todoList, completeCount를 저장할 Map 생성
		//-> 메서드는 반환을 하나 밖에 못해서
		//   여러개를 반환해야 하는 경우 Map 같은 컬렉션에 묶어서 반환
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		//4. map 반환
		return map;
	}

	@Override
	public String dateFormat(LocalDateTime regDate) {
		//yyyy-mm-dd HH:mm:ss 형태 날짜 반환
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		//regDate에 저장되어있는 날짜 데이터를
		// formatter에 지정된 형식으로 변경
		 String fomattedDateTime = regDate.format(formatter);
		
		
		return fomattedDateTime;
	}

	


	/*할 일 상세 조회 서비스*/
	@Override
	public String todoDetailView(int index) {
	
		//1. DAO에 있는 todoList에서 index번쨰 요소(Todo) 반환 받기
		//   없으면 null 반환
		
		Todo todo = dao.todoDetailView(index);
		
		// 2. 반환받은 todo가 null인 경우 null 반환
		if(todo == null) return null;
		
		//3.Todo가 참조하는 객체가 있다면 문자열 가공 후 반환
		StringBuilder sb = new StringBuilder();
		
		sb.append("---------------------------------------------------------\n");
		sb.append(String.format("제목 : %s\n", todo.getTitle()));
		sb.append(String.format("등록일 : %s\n", dateFormat(todo.getRegDate())));
		sb.append(String.format("완료여부 : %s\n", todo.isComplete() ? "0" : "X"));
		sb.append("\n [세부 내용]\n");
		sb.append("---------------------------------------------------------\n");
		sb.append(String.format("%s\n", todo.getDetail()));
		
		//4. 가공한 문자열을 반환
		return sb.toString();
		
	}

	/*할 일 추가 서비스*/
	@Override
	public int todoAdd(String title, String content) throws Exception {
		
		// Todo 객체 생성
		Todo todo = new Todo(title,content,false,LocalDateTime.now());
		//LocalDateTime.now() : 현재 시간 반환
		
		// DAO 메서드 호출 후 결과 반환 받기
		int index = dao.todoAdd(todo);
		
		return index;
	}

	/*할 일 완료 여부 서비스*/
	@Override
	public boolean todoComplete(int index)  throws Exception {
		return dao.todoComplete(index);
	}
	//service 메서드가 별도 처리를 하는게 없음
	//-> 아무것도 안한다고 해서 서비스를 사용하지 않으면 안됨!!!!!!

	
	/*할 일 수정 서비스*/
	@Override
	public boolean todoUpdate(int index, String title, String content) throws Exception {
		
		return dao.todoUpdate(index,title,content);
	}

	/*할 일 삭제 서비스*/
	@Override
	public String todoDelete(int index) throws Exception {
		
		//DAO 메서드 호출 후 결과 반환 받기
		//-> 삭제된 Todo 또는 null을 반환받기
		Todo todo = dao.todoDelete(index);
		
		if(todo == null) return null;
		
		return todo.getTitle(); //제목 반환 
	}
}
