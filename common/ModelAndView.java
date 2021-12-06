package common;

//어디로 어떻게 이동할 것인지 저장하는 class
public class ModelAndView {
	
	private String view;		//어디로
	private boolean isRedirect;	//어떻게 (true -> redirect / false -> forward)
	
	public ModelAndView() {
		super();
	}
	public ModelAndView(String view, boolean isRedirect) {
		super();
		this.view = view;
		this.isRedirect = isRedirect;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
