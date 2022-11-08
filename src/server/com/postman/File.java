package application;

import java.util.ArrayList;

public class File {
	private String urlPath;
	private ArrayList<String> paramName ;
	
	public File(String urlPath,ArrayList<String> paramName) {
		this.urlPath = urlPath;
		this.paramName = paramName;
	}
	
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	
	public void setParamNames(ArrayList<String> paramName) {
		this.paramName = paramName;
	}
	
	public String getUrlPath() {
		return urlPath;
	}
	
	public ArrayList<String> getParamNames() {
		return paramName;
	}
}
