package simbest.com.sharelib;

import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

/**
 * Created by zhangxiaolong on 2016/4/14.
 */
public class ShareModel {
    private String title;
    private String content;
    private UMEmoji emojiMedia;
    private UMImage imageMedia;
    private UMusic musicMedia;
    private UMVideo videoMedia;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UMEmoji getEmojiMedia() {
        return emojiMedia;
    }

    public void setEmojiMedia(UMEmoji emojiMedia) {
        this.emojiMedia = emojiMedia;
    }

    public UMImage getImageMedia() {
        return imageMedia;
    }

    public void setImageMedia(UMImage imageMedia) {
        this.imageMedia = imageMedia;
    }

    public UMusic getMusicMedia() {
        return musicMedia;
    }

    public void setMusicMedia(UMusic musicMedia) {
        this.musicMedia = musicMedia;
    }

    public UMVideo getVideoMedia() {
        return videoMedia;
    }

    public void setVideoMedia(UMVideo videoMedia) {
        this.videoMedia = videoMedia;
    }
}
