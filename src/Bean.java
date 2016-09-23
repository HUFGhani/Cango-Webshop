import java.io.Serializable;

public class Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3107000165584593102L;
	private String recording_id;
	private String director;
	private String title;
	private String category;
	private String image_name;
	private int duration;
	private String rating;
	private int year_released;
	private float price;
	private int stock_count;

	private String artist_name;
	private int num_tracks;
	private String session_id;
	
	private String actors;
	
	private String trackname;
	

	public Bean() {
		setRecording_id(recording_id);
		setDirector(director);
		setTitle(title);
		setCategory(category);
		setImage_name(image_name);
		setDuration(duration);
		setRating(rating);
		setYear_released(year_released);
		setPrice(price);
		setStock_count(stock_count);
		setArtist_name(artist_name);
		setNum_tracks(num_tracks);
		setSession_id(session_id);
		setActors(actors);
		setTrackname(trackname);
	}

	public Bean(String Recording_id, String Director, String Title,
			String Category, String Image_name, int Duration, String Rating,
			int Year_released, int Stock_count, float Price,
			String Artist_name, int num_Tracks, String Session_id, String Actors, String Trackname) {
		setRecording_id(Recording_id);
		setDirector(Director);
		setTitle(Title);
		setCategory(Category);
		setImage_name(Image_name);
		setDuration(Duration);
		setRating(Rating);
		setYear_released(Year_released);
		setPrice(Price);
		setStock_count(Stock_count);
		setArtist_name(Artist_name);
		setNum_tracks(num_Tracks);
		setSession_id(Session_id);
		setActors(Actors);
		setTrackname(Trackname);
	}

	/**
	 * @return the recording_id
	 */
	public String getRecording_id() {
		return recording_id;
	}

	/**
	 * @param recording_id2
	 *            the recording_id to set
	 */
	public void setRecording_id(String recording_id) {
		this.recording_id = recording_id;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the image_name
	 */
	public String getImage_name() {
		return image_name;
	}

	/**
	 * @param image_name
	 *            the image_name to set
	 */
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the year_released
	 */
	public int getYear_released() {
		return year_released;
	}

	/**
	 * @param year_released
	 *            the year_released to set
	 */
	public void setYear_released(int year_released) {
		this.year_released = year_released;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the stock_count
	 */
	public int getStock_count() {
		return stock_count;
	}

	/**
	 * @param stock_count
	 *            the stock_count to set
	 */
	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}

	public String toString() {
		return "VideoBean[recording_id=" + recording_id + ", director="
				+ director + ",title=" + title + ",category=" + category
				+ ",image_name=" + image_name + ",duration=" + duration
				+ ", rating=" + "year_released=" + year_released + ",price="
				+ price + ",stock_count=" + stock_count + ", artist_name="
				+ artist_name + ", getNum_tracks" + session_id + ", session_id"+"]";

	}

	/**
	 * @return the artist_name
	 */
	public String getArtist_name() {
		return artist_name;
	}

	/**
	 * @param artist_name
	 *            the artist_name to set
	 */
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	/**
	 * @return the num_tracks
	 */
	public int getNum_tracks() {
		return num_tracks;
	}

	/**
	 * @param num_tracks
	 *            the num_tracks to set
	 */
	public void setNum_tracks(int num_tracks) {
		this.num_tracks = num_tracks;
	}

	/**
	 * @return the session_id
	 */
	public String getSession_id() {
		return session_id;
	}

	/**
	 * @param session_id the session_id to set
	 */
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(String actors) {
		this.actors = actors;
	}

	/**
	 * @return the trackname
	 */
	public String getTrackname() {
		return trackname;
	}

	/**
	 * @param trackname the trackname to set
	 */
	public void setTrackname(String trackname) {
		this.trackname = trackname;
	}

}
