package biz.dealnote.messenger.model;

/**
 * Created by admin on 04.10.2017.
 * phoenix
 */
public class CommunityDetails {

    private int allWallCount;

    private int ownerWallCount;

    private int postponedWallCount;

    private int suggestedWallCount;

    private boolean canMessage;

    private int membersCount;

    private int topicsCount;

    private int docsCount;

    private int photosCount;

    private int audiosCount;

    private int videosCount;

    private String status;

    private Audio statusAudio;

    public int getAllWallCount() {
        return allWallCount;
    }

    public CommunityDetails setAllWallCount(int allWallCount) {
        this.allWallCount = allWallCount;
        return this;
    }

    public int getOwnerWallCount() {
        return ownerWallCount;
    }

    public CommunityDetails setOwnerWallCount(int ownerWallCount) {
        this.ownerWallCount = ownerWallCount;
        return this;
    }

    public int getPostponedWallCount() {
        return postponedWallCount;
    }

    public CommunityDetails setPostponedWallCount(int postponedWallCount) {
        this.postponedWallCount = postponedWallCount;
        return this;
    }

    public int getSuggestedWallCount() {
        return suggestedWallCount;
    }

    public CommunityDetails setSuggestedWallCount(int suggestedWallCount) {
        this.suggestedWallCount = suggestedWallCount;
        return this;
    }

    public CommunityDetails setCanMessage(boolean canMessage) {
        this.canMessage = canMessage;
        return this;
    }

    public boolean isCanMessage() {
        return canMessage;
    }

    public Audio getStatusAudio() {
        return statusAudio;
    }

    public String getStatus() {
        return status;
    }

    public CommunityDetails setStatus(String status) {
        this.status = status;
        return this;
    }

    public CommunityDetails setStatusAudio(Audio statusAudio) {
        this.statusAudio = statusAudio;
        return this;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public CommunityDetails setMembersCount(int membersCount) {
        this.membersCount = membersCount;
        return this;
    }

    public int getTopicsCount() {
        return topicsCount;
    }

    public CommunityDetails setTopicsCount(int topicsCount) {
        this.topicsCount = topicsCount;
        return this;
    }

    public int getDocsCount() {
        return docsCount;
    }

    public CommunityDetails setDocsCount(int docsCount) {
        this.docsCount = docsCount;
        return this;
    }

    public int getPhotosCount() {
        return photosCount;
    }

    public CommunityDetails setPhotosCount(int photosCount) {
        this.photosCount = photosCount;
        return this;
    }

    public int getAudiosCount() {
        return audiosCount;
    }

    public CommunityDetails setAudiosCount(int audiosCount) {
        this.audiosCount = audiosCount;
        return this;
    }

    public int getVideosCount() {
        return videosCount;
    }

    public CommunityDetails setVideosCount(int videosCount) {
        this.videosCount = videosCount;
        return this;
    }
}