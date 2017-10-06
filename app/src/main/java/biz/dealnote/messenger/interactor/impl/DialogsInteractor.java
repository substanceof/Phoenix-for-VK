package biz.dealnote.messenger.interactor.impl;

import biz.dealnote.messenger.api.interfaces.INetworker;
import biz.dealnote.messenger.db.interfaces.IRepositories;
import biz.dealnote.messenger.exception.NotFoundException;
import biz.dealnote.messenger.interactor.IDialogsInteractor;
import biz.dealnote.messenger.interactor.mappers.Dto2Model;
import biz.dealnote.messenger.model.Chat;
import biz.dealnote.messenger.model.Peer;
import io.reactivex.Single;

import static biz.dealnote.messenger.util.Utils.isEmpty;

/**
 * Created by admin on 19.03.2017.
 * phoenix
 */
public class DialogsInteractor implements IDialogsInteractor {

    private final INetworker networker;

    private final IRepositories repositories;

    public DialogsInteractor(INetworker networker, IRepositories repositories) {
        this.networker = networker;
        this.repositories = repositories;
    }

    @Override
    public Single<Chat> getChatById(int accountId, int peerId) {
        return repositories.dialogs()
                .findChatById(accountId, peerId)
                .flatMap(optional -> {
                    if(optional.nonEmpty()){
                        return Single.just(optional.get());
                    }

                    final int chatId = Peer.toChatId(peerId);
                    return networker.vkDefault(accountId)
                            .messages()
                            .getChat(chatId, null, null, null)
                            .map(chats -> {
                                if(isEmpty(chats)){
                                    throw new NotFoundException();
                                }

                                return chats.get(0);
                            })
                            .map(Dto2Model::transform);
                });
    }
}