본인이 잘 이해했는지 확인하는 가장 정확한 방법은 가르쳐 보는 것!<br>
클린코드 읽으며 뼈맞았던 내용 중 `3가지 원칙` 를 고르고,
원칙 따르는 예시 총 3가지를 만들어보세요.

클린코드 읽을 때 분명 참고하라고 적어준 예시인데 자바로 되어있어서 공감이 잘 안됐죠?
이제 본인이 가장 잘하는 언어로(JS, Python 등등) 더러운 코드를 깨끗한 코드로 리팩토링하는 예시를 만들어보세요. 

<hr>

## 원칙 1. 주석에는 코드가 포함되어서는 안 된다

### Before 😣
``` java
public boolean updateCodeGroup(@RequestParam String cdKindId, @RequestParam String lang, String cdKindInstcn, String cdKindClssCd, String useYn, String mngrId) throws Exception {

  Map<String, Object> sqlParam = new HashMap<>();
  sqlParam.put("CD_KIND_ID", cdKindId);
  sqlParam.put("lang", lang);

  simpleTransactionService.transaction(sqlParam, p ->{

    /* 
    int intResult = cdMapper.updateCodeGroup(sqlParam);

    if (intResult == 0) {
      throw new DatabaseUpdateException("Error occurred. Contact administrator for assistance.");
    }
    else {
      cdMapper.insertCodeGroupHistory(sqlParam);			
    }
    */

    int intResult = cdMapper.updateCodeGroup(sqlParam);

    if (intResult == 0) {
      throw new DatabaseUpdateException("Error occurred. Contact administrator for assistance.");
    }
    else {
      cdMapper.insertCodeGroupHistory(sqlParam);			
    }
  });

  return true;
}
```

## 무엇을 고치려고 하는지, 고치려는 문제가 무엇인지 알려주세요.
주석은 꼭 필요한 경우에만 사용하여야 하는데, 꼭 필요한 경우가 아님에도 주석을 사용했다. 특히 코드 전체를 주석으로 처리해 두어 해당 코드가 무엇을 의미하는지 알 수 없게 되었다. 이는 개선되어야 한다.  

### After 😎
``` java
public boolean updateCodeGroup(@RequestParam String cdKindId, @RequestParam String lang, String cdKindInstcn, String cdKindClssCd, String useYn, String mngrId) throws Exception {

  Map<String, Object> sqlParam = new HashMap<>();
  sqlParam.put("CD_KIND_ID", cdKindId);
  sqlParam.put("lang", lang);

  simpleTransactionService.transaction(sqlParam, p ->{

  int intResult = cdMapper.updateCodeGroup(sqlParam);

    if (intResult == 0) {
      throw new DatabaseUpdateException("Error occurred. Contact administrator for assistance.");
    }
    else {
      cdMapper.insertCodeGroupHistory(sqlParam);			
    }
  });
		
  return true;
}
```

## 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
주석에는 꼭 필요한 내용만 포함되어야 한다. 추후에 사용하기 위해 남겨 두었을 수 있으나, 이는 유지보수에 도움이 되지 않는다. 이후에 코드가 아닌 주석까지 읽을 확률이 낮기 때문이다. 해당 부분도 읽어 보면 아래 코드와 다른 부분이 없다. 이런 주석은 코드를 지저분하게만 만들뿐이다.  

<hr>

## 원칙 2. 변수는 의미 있는 이름을 사용해야 한다. 

### Before 😣
``` java
@RequestMapping("addChatView.ct")
public String addChatView(Model model) {
	ArrayList<Department> list = cService.getChatDepartmentList();
	
	if(list != null) {
		JSONArray jArr = new JSONArray();
		
		for(Department d : list) {
			JSONObject jo = new JSONObject();
			jo.put("id", d.getdNo());
			jo.put("pId", d.getdParent());
			jo.put("name", d.getdName());
			
			jArr.add(jo);
		}
		
		model.addAttribute("jsonArray", jArr);
		return "insertChatView";
	} else {
		throw new ChatException("채팅방 생성 화면 조회에 실패하였습니다.");
	}
}
```

## 무엇을 고치려고 하는지, 고치려는 문제가 무엇인지 알려주세요.
해당 코드만 보면 이 변수를 왜 사용하고, 왜 사용되는 코드인지 명확히 알기 어렵다. 다른 메서드로 넘어가야 해당 코드를 정확히 알 수 있다. 이는 유지보수 시 많은 시간을 할애하게 되며, 유지 보수 비용도 크게 늘어날 이유가 된다.  

### After 😎
``` java
@RequestMapping("addChatView.ct")
public String addChatView(Model model) {
	ArrayList<Department> departments = cService.getChatDepartmentList();
	
	if(departments != null) {
		JSONArray jArr = new JSONArray();
		
		for(Department department : departments) {
			JSONObject jo = new JSONObject();
			jo.put("id", department.getdNo());
			jo.put("pId", department.getdParent());
			jo.put("name", department.getdName());
			
			jArr.add(jo);
		}
		
		model.addAttribute("jsonArray", jArr);
		return "insertChatView";
	} else {
		throw new ChatException("채팅방 생성 화면 조회에 실패하였습니다.");
	}
}
```

## 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.  
단순히 알파벳 하나, 또는 타입으로 작성되어 있던 변수명을 조금 더 직관적으로 수정하였다. 따라서 d가 부서를 의미하고, list가 부서들의 목록이 담긴 리스트라는 것을 한눈에 알 수 있도록 수정하였다. 하지만, 해당 변수를 실제로 view로 넘기는 변수인 jArr과 jo는 어떤 이름으로 수정해야 코드의 가독성을 높일 수 있을지 아직 모호하여 수정되지 않은 상태로 두었다. 이 부분에 대해서는 조금 더 고민해봐야 할 문제라고 생각한다.  

<hr>

## 원칙 3. 개념은 빈 행으로 구분하여야 한다.

### Before 😣
``` java
public ModelAndView selectList(CommandMap commandMap) throws Exception {
	ModelAndView mv = new ModelAndView();
	List<Map<String , Object>> list = operationService.selectList(commandMap.getMap());
	mv.addObject("datalist",list);
	mv.setViewName("jsonView");
	return mv;
}
```

## 무엇을 고치려고 하는지, 고치려는 문제가 무엇인지 알려주세요.
모든 코드가 빈 부분 없이 뭉쳐 있어 짧지만, 읽을 때 가독성이 떨어진다. 몇 줄의 개행으로 조금 더 가독성있게 수정한다.  

### After 😎
``` java
public ModelAndView selectList(CommandMap commandMap) throws Exception {
	ModelAndView mv = new ModelAndView();
	
	List<Map<String , Object>> list = operationService.selectList(commandMap.getMap());
	
	mv.addObject("datalist",list);
	mv.setViewName("jsonView");
	
	return mv;
}
```

## 어떻게 고쳤는지, 사례에서 무엇을 배워야 하는지 설명해주세요.
책에서는 개념 별로 구분하여 개행해야 한다고 설명하고 있다. 따라서 비슷한 개념끼리 묶는 방시긍로 개행하였다. 하지만, 아직 부족한 부분이 있어 명확하게 구분되는 개념으로 나눈 것인지는 정확하지 않다. 따라서 이 부분에 대해서 조금 더 학습이 필요하다.  
<br>
