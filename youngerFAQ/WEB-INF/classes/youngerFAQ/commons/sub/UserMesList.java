package youngerFAQ.commons.sub;

import java.util.ArrayList;

public class UserMesList {

	ArrayList<UserMes> userList = null;
	private int num;
	private int pos;
	private int defaultSize = 25;

	public UserMesList() {
		setup(defaultSize);
	}

	public UserMesList(int size) {
		setup(size);
	}

	private void setup(int size) {
		userList = new ArrayList<UserMes>(size);
		num=pos=0;
	}
	
	public void insert(UserMes item)
	{
			this.userList.add(this.pos, item);
			this.num++;
	}
	
	public void append(UserMes item)
	{
		this.userList.add(item);
		this.num++;
	}
	
	public UserMes remove()
	{
		UserMes temp=(UserMes)this.userList.get(pos);
		this.userList.remove(this.pos);
		num--;
		return temp;
	}

	public void setFirst()
	{
		this.pos=0;
	}
	
	public void next()
	{
		if(pos<=num-1)
			pos++;
	}
	
	public void prev()
	{
		if(pos>=0)
			pos--;
	}
	
	public int length()
	{
		return this.num;
	}
	
	public void setPos(int pos)
	{
		if(pos>=0 &&  pos<=num-1)
			this.pos=pos;
		else
			System.out.println("当前位置不合法，无法更改!");
	}
	
	public void setValue(UserMes item)
	{
		this.userList.set(pos, item);
	}
	
	public UserMes currValue()
	{
		return (UserMes)this.userList.get(pos);
	}
	
	public boolean isEmpty()
	{
		return this.num==0;
	}
	
	public boolean isInList()
	{
		return (pos>=0)&&(pos<=num-1);
	}
	

}
