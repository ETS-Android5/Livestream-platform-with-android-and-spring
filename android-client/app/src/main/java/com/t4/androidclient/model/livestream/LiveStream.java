package com.t4.androidclient.model.livestream;

import java.util.Date;
import java.util.List;

public class LiveStream {
    private User owner;
    private Integer streamId;
    private String name;
    private String thumbnail;
    private List<String> genreList;
    private FacebookUser facebookUser;
    private Integer totalView;
    private int likeCount;
    private Date startTime;
    private Date endTime;
    private Integer status;
    public List<StreamingForward> forwards;
    //private String forwards;
    private String forwardsUrl;
    private String storedUrl;
    private List<Comment> comments;
    private String primaryServerURL;
    private int hostPort;
    private String application;
    private String streamName;

    public LiveStream(String name, Date endTime, Integer totalView) {
        this.name = name;
        this.endTime = endTime;
        this.totalView = totalView;
    }

    public LiveStream() {

    }

    public void setForwards(List<StreamingForward> forwards) {
        this.forwards = forwards;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getStreamId() {
        return streamId;
    }

    public void setStreamId(Integer streamId) {
        this.streamId = streamId;
    }

    public String toString() {
        if (facebookUser == null) {
            return this.name + ", "
                    + this.thumbnail +", "
                    + this.genreList.toString();
        }
        return this.name + ", "
                + this.thumbnail +", "
                + this.genreList.toString() + ", "
                + this.facebookUser.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }

    public FacebookUser getFacebookUser() {
        return facebookUser;
    }

    public void setFacebookUser(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getForwardsUrl() {
        return forwardsUrl;
    }

    public void setForwardsUrl(String forwardsUrl) {
        this.forwardsUrl = forwardsUrl;
    }

    public String getStoredUrl() {
        return storedUrl;
    }

    public void setStoredUrl(String storedUrl) {
        this.storedUrl = storedUrl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getPrimaryServerURL() {
        return primaryServerURL;
    }

    public void setPrimaryServerURL(String primaryServerURL) {
        this.primaryServerURL = primaryServerURL;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }
}
