package common;

public class ModelAndView {

	//String view : 응답 View
	//private boolean isRedirect : true(redirect) / false(forward)
	
	private String view;
	private boolean isRedirect;
	
	public ModelAndView() {
		
	}

	public ModelAndView(String view, boolean isRedirect) {
		super();
		this.view = view;
		this.isRedirect = isRedirect;
	}

	/**
	 * @return the view
	 */
	public String getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(String view) {
		this.view = view;
	}

	/**
	 * @return the isRedirect
	 */
	public boolean isRedirect() {
		return isRedirect;
	}

	/**
	 * @param isRedirect the isRedirect to set
	 */
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
