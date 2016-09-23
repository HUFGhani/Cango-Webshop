public class ServletUtilities {
	public static final String DOCTYPE = "<!DOCTYPE>";
	public static final String nav = "<link rel='stylesheet' href='css/nav.css'>";

	public static String headWithTitle(String title) {
		return (DOCTYPE
				+ "\n"
				+ "<HTML>\n"
				+ "<HEAD>\n"
				+ nav
				+ "\n<TITLE>"
				+ title
				+ "</TITLE>\n"
				+ "</HEAD>\n "
				+ "<Body>\n"
				+ "<div><img src='images/logo.gif' alt='logo'class='center' /></div>\n"
				+ "<div id='cssmenu'>\n"
				+ "<ul>\n"
				+ "<li><a href='index.html'><span>Home</span></a></li>\n"
				+ "<li class='active has-sub'><a href='#'><span>Products</span></a>\n"
				+ "<ul>\n"
				+ "<li class='has-sub'><a href='video'><span>Video</span></a>\n"
				+ "<ul>\n"
				+ " <li><a href='search'><span>search</span></a></li>\n"
				+ " </ul>\n"
				+ "</li>\n"
				+ "<li class='has-sub'><a href='music'><span>Music</span></a>\n"
				+ "<ul>\n"
				+ "<li><a href='searchm'><span>search</span></a></li>\n"
				+ "</ul>\n"
				+ "</li>\n"
				+ "</ul>\n"
				+ "</li>\n"
				+ "<li><a href='#'><span>About</span></a></li>\n"
				+ "<li class='last'><a href='#'><span>Contact</span></a></li>\n"
				+ "</ul>\n" + "</div>");

	}

	public static String footer() {
		return ("</Body>" + "</HTML>");
	}
}
