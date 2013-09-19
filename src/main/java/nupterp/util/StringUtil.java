package nupterp.util;

public class StringUtil {
	public static String filterHtml(String input) {
		if (input == null) {
			return null;
		}
		if (input.trim().length() == 0) {
			return input;
		}
		input = input.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
				.replaceAll(" ", "&nbsp;").replaceAll("'", "&#39;").replaceAll("\"", "&quot;")
				.replaceAll("\n", "<br>");
		return input;
	}

	public static String filterSql(String input) {
		if (input == null) {
			return null;
		}
		if (input.trim().length() == 0) {
			return input;
		}
		input = input.replaceAll(":", "").replaceAll("[?]", "").replaceAll(",", "").replaceAll(" ", "")
				.replaceAll(" ", "").replaceAll("%", "").replaceAll("[|]", "").replaceAll("&", "")
				.replaceAll("[(]", "").replaceAll("[)]", "");
		return input;
	}
	
	public static String filterAll(String input){
		if (input == null) {
			return null;
		}
		if (input.trim().length() == 0) {
			return input;
		}
		input = filterSql(filterHtml(input));
		return input;
	}
}
