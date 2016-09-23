import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs1 = null;
	// Bean order= new Bean();
	Statement statement;

	public DAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(Bean video) {
		try {
			String queryString = "INSERT INTO Video_Recordings(recording_id,director,title,category,image_name,duration,rating,year_released,price,stock_count) values(?,?,?,?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, video.getRecording_id());
			ptmt.setString(2, video.getDirector());
			ptmt.setString(3, video.getTitle());
			ptmt.setString(4, video.getCategory());
			ptmt.setString(5, video.getImage_name());
			ptmt.setInt(6, video.getDuration());
			ptmt.setString(7, video.getRating());
			ptmt.setInt(8, video.getYear_released());
			ptmt.setFloat(9, video.getPrice());
			ptmt.setInt(10, video.getStock_count());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int recording_id) {

		try {
			String queryString = "DELETE FROM Video_Recordings WHERE recording_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, recording_id);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Bean> GetAll() {
		ArrayList<Bean> videos = null;
		try {
			String queryString = "SELECT * FROM Video_Recordings";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();
				vBean.setRecording_id(rs1.getString("recording_id"));
				vBean.setDirector(rs1.getString("director"));
				vBean.setTitle(rs1.getString("title"));
				vBean.setCategory(rs1.getString("category"));
				vBean.setImage_name(rs1.getString("image_name"));
				vBean.setDuration(rs1.getInt("duration"));
				vBean.setRating(rs1.getString("rating"));
				vBean.setYear_released(rs1.getInt("year_released"));
				vBean.setPrice(rs1.getFloat("price"));
				vBean.setStock_count(rs1.getInt("stock_count"));
				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;

	}

	public ArrayList<Bean> Getcategory() {
		ArrayList<Bean> videos = null;
		try {
			String queryString = "SELECT * FROM Video_Categories";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();

				vBean.setCategory(rs1.getString("name"));

				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;

	}

	public ArrayList<Bean> GetVideobycategory(String category) {
		ArrayList<Bean> videos = null;
		try {
			String queryString = "SELECT * from Video_Recordings where category ='"
					+ category + "'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();
				vBean.setRecording_id(rs1.getString("recording_id"));
				vBean.setDirector(rs1.getString("director"));
				vBean.setTitle(rs1.getString("title"));
				vBean.setCategory(rs1.getString("category"));
				vBean.setImage_name(rs1.getString("image_name"));
				vBean.setDuration(rs1.getInt("duration"));
				vBean.setRating(rs1.getString("rating"));
				vBean.setYear_released(rs1.getInt("year_released"));
				vBean.setPrice(rs1.getFloat("price"));
				vBean.setStock_count(rs1.getInt("stock_count"));
				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;
	}

	public ArrayList<Bean> findbyprice() {
		// TODO Auto-generated method stub
		ArrayList<Bean> videos = null;
		try {
			String queryString = "SELECT price FROM Video_Recordings group by price	";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();

				vBean.setPrice(rs1.getFloat("price"));

				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;

	}

	public ArrayList<Bean> GetVideobyprice(String price) {
		// TODO Auto-generated method stub
		ArrayList<Bean> videos = null;
		try {
			String queryString = "SELECT * from Video_Recordings where price <='"
					+ price + "'order by price asc";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();
				vBean.setRecording_id(rs1.getString("recording_id"));
				vBean.setDirector(rs1.getString("director"));
				vBean.setTitle(rs1.getString("title"));
				vBean.setCategory(rs1.getString("category"));
				vBean.setImage_name(rs1.getString("image_name"));
				vBean.setDuration(rs1.getInt("duration"));
				vBean.setRating(rs1.getString("rating"));
				vBean.setYear_released(rs1.getInt("year_released"));
				vBean.setPrice(rs1.getFloat("price"));
				vBean.setStock_count(rs1.getInt("stock_count"));
				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;
	}

	public ArrayList<Bean> getvideobydirector(String director) {
		// TODO Auto-generated method stub
		ArrayList<Bean> videos = null;
		try {
			String queryString = "select * from Video_Recordings where director ='"
					+ director + "'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();
				vBean.setRecording_id(rs1.getString("recording_id"));
				vBean.setDirector(rs1.getString("director"));
				vBean.setTitle(rs1.getString("title"));
				vBean.setCategory(rs1.getString("category"));
				vBean.setImage_name(rs1.getString("image_name"));
				vBean.setDuration(rs1.getInt("duration"));
				vBean.setRating(rs1.getString("rating"));
				vBean.setYear_released(rs1.getInt("year_released"));
				vBean.setPrice(rs1.getFloat("price"));
				vBean.setStock_count(rs1.getInt("stock_count"));
				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;

	}

	public ArrayList<Bean> GetcategoryM() {
		ArrayList<Bean> music = null;
		try {
			String queryString = "select * from Music_Categories";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();

				mBean.setCategory(rs1.getString("name"));

				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;

	}

	public ArrayList<Bean> GetMusicbycategory(String category) {
		// TODO Auto-generated method stub
		ArrayList<Bean> music = null;
		try {
			String queryString = "SELECT * from Music_Recordings where category ='"
					+ category + "'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();
				mBean.setRecording_id(rs1.getString("recording_id"));
				mBean.setArtist_name(rs1.getString("artist_name"));
				mBean.setTitle(rs1.getString("title"));
				mBean.setCategory(rs1.getString("category"));
				mBean.setImage_name(rs1.getString("image_name"));
				mBean.setNum_tracks(rs1.getInt("num_tracks"));
				mBean.setPrice(rs1.getFloat("price"));
				mBean.setStock_count(rs1.getInt("stock_count"));
				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;
	}

	public ArrayList<Bean> GetAllMusic() {
		// TODO Auto-generated method stub
		ArrayList<Bean> music = null;
		try {
			String queryString = "SELECT * from Music_Recordings ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();
				mBean.setRecording_id(rs1.getString("recording_id"));
				mBean.setArtist_name(rs1.getString("artist_name"));
				mBean.setTitle(rs1.getString("title"));
				mBean.setCategory(rs1.getString("category"));
				mBean.setImage_name(rs1.getString("image_name"));
				mBean.setNum_tracks(rs1.getInt("num_tracks"));
				mBean.setPrice(rs1.getFloat("price"));
				mBean.setStock_count(rs1.getInt("stock_count"));
				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;
	}

	public ArrayList<Bean> findbypriceM() {
		// TODO Auto-generated method stub
		ArrayList<Bean> music = null;
		try {
			String queryString = "SELECT price from Music_Recordings group by price";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();
				mBean.setPrice(rs1.getFloat("price"));
				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;
	}

	public ArrayList<Bean> GetMusicbyprice(String price) {
		// TODO Auto-generated method stub
		ArrayList<Bean> music = null;
		try {
			String queryString = "SELECT * from Music_Recordings where price<='"
					+ price + "'order by price asc";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();
				mBean.setRecording_id(rs1.getString("recording_id"));
				mBean.setArtist_name(rs1.getString("artist_name"));
				mBean.setTitle(rs1.getString("title"));
				mBean.setCategory(rs1.getString("category"));
				mBean.setImage_name(rs1.getString("image_name"));
				mBean.setNum_tracks(rs1.getInt("num_tracks"));
				mBean.setPrice(rs1.getFloat("price"));
				mBean.setStock_count(rs1.getInt("stock_count"));
				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;
	}

	public ArrayList<Bean> GetMusicbArtist_name(String artist_name) {
		// TODO Auto-generated method stub
		ArrayList<Bean> music = null;
		try {
			String queryString = "SELECT * from Music_Recordings where artist_name ='"
					+ artist_name + "'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();
				mBean.setRecording_id(rs1.getString("recording_id"));
				mBean.setArtist_name(rs1.getString("artist_name"));
				mBean.setTitle(rs1.getString("title"));
				mBean.setCategory(rs1.getString("category"));
				mBean.setImage_name(rs1.getString("image_name"));
				mBean.setNum_tracks(rs1.getInt("num_tracks"));
				mBean.setPrice(rs1.getFloat("price"));
				mBean.setStock_count(rs1.getInt("stock_count"));
				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;
	}

	public ArrayList<Bean> GetVideobytitles(String title) {
		// TODO Auto-generated method stub
		ArrayList<Bean> videos = null;
		try {
			String queryString = "select * from Video_Recordings where title ='"
					+ title + "'";
			connection = getConnection();
			System.err.println("DEBUG: Query: " + queryString);
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();
				vBean.setRecording_id(rs1.getString("recording_id"));
				vBean.setDirector(rs1.getString("director"));
				vBean.setTitle(rs1.getString("title"));
				vBean.setCategory(rs1.getString("category"));
				vBean.setImage_name(rs1.getString("image_name"));
				vBean.setDuration(rs1.getInt("duration"));
				vBean.setRating(rs1.getString("rating"));
				vBean.setYear_released(rs1.getInt("year_released"));
				vBean.setPrice(rs1.getFloat("price"));
				vBean.setStock_count(rs1.getInt("stock_count"));
				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;
	}

	/*
	 * public ArrayList<Bean> GetVideobytitle(String title) { // TODO
	 * Auto-generated method stub ArrayList<Bean> videos = null; try { String
	 * queryString = "select * from Video_Recordings where title ='" + title +
	 * "'"; connection = getConnection(); //System.err.println("DEBUG: Query: "
	 * + queryString); ptmt = connection.prepareStatement(queryString); rs1 =
	 * ptmt.executeQuery();
	 * 
	 * videos = new ArrayList<Bean>(); while (rs1.next()) { Bean vBean = new
	 * Bean(); vBean.setRecording_id(rs1.getString("recording_id"));
	 * vBean.setDirector(rs1.getString("director"));
	 * vBean.setTitle(rs1.getString("title"));
	 * vBean.setCategory(rs1.getString("category"));
	 * vBean.setImage_name(rs1.getString("image_name"));
	 * vBean.setDuration(rs1.getInt("duration"));
	 * vBean.setRating(rs1.getString("rating"));
	 * vBean.setYear_released(rs1.getInt("year_released"));
	 * vBean.setPrice(rs1.getFloat("price"));
	 * vBean.setStock_count(rs1.getInt("stock_count")); videos.add(vBean); } }
	 * catch (SQLException e) { e.printStackTrace(); } finally { try { if (rs1
	 * != null) rs1.close(); if (ptmt != null) ptmt.close(); if (connection !=
	 * null) connection.close(); } catch (SQLException e) { e.printStackTrace();
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * } return videos; }
	 */

	public void storeVorder(Bean order) {
		// TODO Auto-generated method stub

		try {
			String queryString = "Insert INTO Vorders(recording_id,session_id) values(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, order.getRecording_id());
			ptmt.setString(2, order.getSession_id());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Bean> GetVideoinfo(String recording_id) {
		// TODO Auto-generated method stub
		ArrayList<Bean> videos = null;
		try {
			String queryString = "SELECT Video_Recordings.title, Video_Actors.name from Video_Recordings join Video_Actors on Video_Recordings.recording_id = Video_Actors.recording_id and Video_Recordings.recording_id="+recording_id;
			connection = getConnection();
			System.err.println("DEBUG: Query: " + queryString);
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			videos = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean vBean = new Bean();
				vBean.setRecording_id(rs1.getString("recording_id"));
				vBean.setDirector(rs1.getString("director"));
				vBean.setTitle(rs1.getString("title"));
				vBean.setCategory(rs1.getString("category"));
				vBean.setImage_name(rs1.getString("image_name"));
				vBean.setDuration(rs1.getInt("duration"));
				vBean.setRating(rs1.getString("rating"));
				vBean.setYear_released(rs1.getInt("year_released"));
				vBean.setPrice(rs1.getFloat("price"));
				vBean.setStock_count(rs1.getInt("stock_count"));
				vBean.setActors(rs1.getString("name"));
				videos.add(vBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return videos;
	}

	public ArrayList<Bean> getmTrack(String recording_id) {
		// TODO Auto-generated method stub
		ArrayList<Bean> music = null;
		try {
			String queryString = "SELECT price from Music_Recordings group by price";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			rs1 = ptmt.executeQuery();

			music = new ArrayList<Bean>();
			while (rs1.next()) {
				Bean mBean = new Bean();
				mBean.setPrice(rs1.getFloat("price"));
				music.add(mBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null)
					rs1.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return music;
	}
}
