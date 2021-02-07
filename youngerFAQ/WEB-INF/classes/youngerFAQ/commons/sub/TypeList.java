package youngerFAQ.commons.sub;

import java.util.ArrayList;

public class TypeList {
	ArrayList<String> list;
	public TypeList() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<String>();
		list.add("Java");
		list.add("C++");
		list.add("科学教育");
		list.add("体育运动");
		list.add("生活");
		list.add("时政");
		list.add("娱乐休闲");
		list.add("数组");
		list.add("更多");
		list.add("不知道");
		
		
		
	}
	public ArrayList<String> getList(){
		return list;
	}

}
