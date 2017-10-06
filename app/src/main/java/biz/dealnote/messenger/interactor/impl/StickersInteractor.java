package biz.dealnote.messenger.interactor.impl;

import biz.dealnote.messenger.api.interfaces.INetworker;
import biz.dealnote.messenger.db.interfaces.IStickersRepository;
import biz.dealnote.messenger.interactor.IStickersInteractor;
import io.reactivex.Completable;

/**
 * Created by admin on 20.03.2017.
 * phoenix
 */
public class StickersInteractor implements IStickersInteractor {

    private final INetworker networker;
    private final IStickersRepository repository;

    public StickersInteractor(INetworker networker, IStickersRepository repository) {
        this.networker = networker;
        this.repository = repository;
    }

    @Override
    public Completable getAndStore(int accountId) {
        return networker.vkDefault(accountId)
                .store()
                .getProducts(true, "active", "stickers")
                .flatMapCompletable(items -> repository.store(accountId, items.getItems()));
    }
}