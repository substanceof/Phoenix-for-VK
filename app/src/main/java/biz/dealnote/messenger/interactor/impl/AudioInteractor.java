package biz.dealnote.messenger.interactor.impl;

import java.util.Collection;

import biz.dealnote.messenger.api.interfaces.INetworker;
import biz.dealnote.messenger.api.model.IdPair;
import biz.dealnote.messenger.interactor.IAudioInteractor;
import biz.dealnote.messenger.model.Audio;
import biz.dealnote.messenger.util.Objects;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by admin on 07.10.2017.
 * Phoenix-for-VK
 */
public class AudioInteractor implements IAudioInteractor {

    private final INetworker networker;

    public AudioInteractor(INetworker networker) {
        this.networker = networker;
    }

    @Override
    public Single<Audio> add(int accountId, Audio orig, Integer groupId, Integer albumId) {
        return networker.vkDefault(accountId)
                .audio()
                .add(orig.getId(), orig.getOwnerId(), groupId, albumId)
                .map(resultId -> {
                    final int targetOwnerId = Objects.nonNull(groupId) ? -groupId : accountId;
                    //clone
                    return new Audio()
                            .setId(resultId)
                            .setOwnerId(targetOwnerId)
                            .setAlbumId(Objects.nonNull(albumId) ? albumId : 0)
                            .setArtist(orig.getArtist())
                            .setTitle(orig.getTitle())
                            .setUrl(orig.getUrl())
                            .setLyricsId(orig.getLyricsId())
                            .setGenre(orig.getGenre())
                            .setDuration(orig.getDuration());
                });
    }

    @Override
    public Completable delete(int accountId, int audioId, int ownerId) {
        return networker.vkDefault(accountId)
                .audio()
                .delete(audioId, ownerId)
                .toCompletable();
    }

    @Override
    public Completable restore(int accountId, int audioId, int ownerId) {
        return networker.vkDefault(accountId)
                .audio()
                .restore(audioId, ownerId)
                .toCompletable();
    }

    @Override
    public Completable sendBroadcast(int accountId, int audioOwnerId, int audioId, Collection<Integer> targetIds) {
        return networker.vkDefault(accountId)
                .audio()
                .setBroadcast(new IdPair(audioId, audioOwnerId), targetIds)
                .toCompletable();
    }
}