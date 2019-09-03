package entity;

public class Result {
	// 标识 0：失败 1：成功
	private int flag;
	// 响应消息内容
	private String content;
	
	public Result(int flag,String content){
		this.flag=flag;
		this.content=content;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
