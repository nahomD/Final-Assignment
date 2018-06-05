package Models;

/**
 * Created by Admin on 6/1/2018.
 */
public class News {
    private String mTitle;
    private String mSummary;
    private String mType;

    public News(String title, String summary, String type){
        setTitle(title);
        setSummary(summary);
        setType(type);
    }
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
