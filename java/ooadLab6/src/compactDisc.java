
public class compactDisc 
{

private String title;
private String artist;
private int num_tracks;
private String fav_track;

	public void setTitle(String t)
	{
		title = t;
	}
	
	public void setArtist(String a)
	{
		artist = a;
	}
	
	public void setTrackNum(int n)
	{
		num_tracks = n;
	}
	
	public void setfavTrack(String f)
	{
		fav_track = f;
	}
	
	public String getTitle()
	{
		return title;
	}

	public String getArtist()
	{
		return artist;
	}
	
	public int getTrackNum()
	{
		return num_tracks;
	}
	
	public String getfavTrack()
	{
		return fav_track;
	}
}
